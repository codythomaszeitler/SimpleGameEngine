package SimpleGameEngine;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/18/2016.
 */
public class KeyboardInputManager {


    private KeyListener keyListener;

    private KeyboardInput keyboardInput;


    public KeyboardInputManager(){
        keyboardInput = new KeyboardInput();

        keyListener = keyboardInput;

    }

    public KeyListener getKeyListener(){
        return keyListener;
    }

    public boolean isKeyPressed(int e){
        return keyboardInput.isKeyPressed(e);
    }

    public void addKey(int keyEvent){
        keyboardInput.addKey(keyEvent);
    }

    private class KeyboardInput implements KeyListener{

        private class Key{
            private int keyEvent;
            private boolean isKeyPressed;

            public Key(int keyEvent, boolean isKeyPressed){
                this.keyEvent = keyEvent;
                this.isKeyPressed = isKeyPressed;
            }

            public void setKeyEvent(int keyEvent){
                this.keyEvent = keyEvent;
            }
            public int getKeyEvent(){
                return keyEvent;
            }
            public void setKeyPressed(boolean isKeyPressed){
                this.isKeyPressed = isKeyPressed;
            }
            public boolean getKeyPressed(){
                return isKeyPressed;
            }
        }

        private LinkedList<Key> keyLinkedList;
        private Key key;
        private Key lastKeyPressed;

        public KeyboardInput(){
            keyLinkedList = new LinkedList<>();
        }

        public void addKey(int keyEvent){
            key = new Key(keyEvent, false);
            keyLinkedList.add(key);
        }

        public void keyPressed(KeyEvent e){

            if(lastKeyPressed != null) {
                if (lastKeyPressed.getKeyEvent() == e.getKeyCode()) {
                    return;
                }
            }

            ListIterator listIterator = keyLinkedList.listIterator();

            while(listIterator.hasNext()){

                Key temp = (Key)listIterator.next();

                if(temp.getKeyEvent() == e.getKeyCode()){
                    temp.setKeyPressed(true);
                    lastKeyPressed = temp;
                    System.out.println("Key set to true");
                }
            }
        }

        public void keyReleased(KeyEvent e){

            ListIterator listIterator = keyLinkedList.listIterator();

            while(listIterator.hasNext()){

                Key temp = (Key)listIterator.next();

                if(temp.getKeyEvent() == e.getKeyCode()){
                    temp.setKeyPressed(false);
                    lastKeyPressed = null;
                    System.out.println("Key set to false.");
                }
            }
        }

        public void keyTyped(KeyEvent e){


        }

        public boolean isKeyPressed(int keyEvent){

            ListIterator listIterator = keyLinkedList.listIterator();

            while(listIterator.hasNext()){

                Key temp = (Key)listIterator.next();

                if(temp.getKeyEvent() == keyEvent){
                    return temp.getKeyPressed();
                }

            }
            System.out.println("The key was not found.");
            return false;


        }

    }




}

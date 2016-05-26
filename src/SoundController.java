package SimpleGameEngine;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/21/2016.
 */
public class SoundController {

    private LinkedList<SoundDoublet> soundDoubletLinkedList;

    public SoundController(){
        soundDoubletLinkedList = new LinkedList<>();
    }

    public void add(String source, String name){

        Sound sound = new Sound(source);

        SoundDoublet soundDoublet = new SoundDoublet(name, sound);

        soundDoubletLinkedList.add(soundDoublet);

    }

    public void play(String name){

        ListIterator listIterator = soundDoubletLinkedList.listIterator();

        while(listIterator.hasNext()){

            SoundDoublet temp = (SoundDoublet)listIterator.next();

            if(temp.getName().equals(name)){
                temp.play();
                return;
            }
        }
    }

    private class SoundDoublet{

        private String name;
        private Sound sound;

        public SoundDoublet(String name, Sound sound){
            this.name = name;
            this.sound = sound;
        }

        public String getName(){
            return name;
        }
        public void play(){
            sound.play();
        }

    }

    private class Sound implements Runnable{

        private File soundFile;
        private AudioInputStream audioInputStream;
        private AudioFormat audioFormat;
        private DataLine.Info info;
        private Clip clip;
        private String source;
        private int loopCount;
        private boolean isInfiniteLoop;

        public Sound(String source){

            this.source = source;
            isInfiniteLoop = false;

            soundFile = new File(this.source);



        }

        public void setInfiniteLoop(boolean isInfiniteLoop){
            this.isInfiniteLoop = isInfiniteLoop;
        }

        public void play(){

            SwingUtilities.invokeLater(this);

        }

        public void run(){

            if(SwingUtilities.isEventDispatchThread()){
                System.out.println("The run thing is on the EDT");
            }

            if(isInfiniteLoop){
                System.out.println("INFINITE LOOP ACTIVATED");
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else{
                try {

                    audioInputStream = AudioSystem.getAudioInputStream(soundFile);

                } catch (IOException e){
                    System.out.println("IOException has occured wihtin the private Sound object within the SoundController" +
                            " object");
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e){
                    System.out.println("UnsupportedAudioFileException has been caught within the private Sound object"
                            + " within the SoundController.");
                    e.printStackTrace();
                }

                audioFormat = audioInputStream.getFormat();

                info = new DataLine.Info(Clip.class, audioFormat);
                try {
                    clip = (Clip) AudioSystem.getLine(info);
                } catch (LineUnavailableException e){
                    e.printStackTrace();
                }

                try {
                    clip.open(audioInputStream);
                } catch (LineUnavailableException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
                clip.start();
            }
        }
    }
}

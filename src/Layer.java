package SimpleGameEngine;

import java.awt.*;
import java.util.*;

/**
 * Created by Cody Thomas Zeitler on 5/14/2016.
 */
public class Layer {

    private LinkedList<GameObject> gameObjectsToPaint;
    private int degree;

    public Layer(){

        gameObjectsToPaint = new LinkedList<>();
        degree = 1;

    }

    public void add(GameObject gameObject){
        gameObjectsToPaint.add(gameObject);
    }

    public void remove(GameObject gameObject){

        ListIterator listIterator = gameObjectsToPaint.listIterator();

        int indexRemove = 0;

        while(listIterator.hasNext()){
            if(listIterator.next() == gameObject){
                gameObjectsToPaint.remove(indexRemove);
            }
            indexRemove++;
        }


    }

    public void update(int x, int y){

        ListIterator listIterator = gameObjectsToPaint.listIterator();

        while(listIterator.hasNext()){

            GameObject gameObject = (GameObject)listIterator.next();
            gameObject.setXCoordinate( gameObject.getXCoordinate() + (degree * x) );
            gameObject.setYCoordinate( gameObject.getYCoordinate() + (degree * y) );

        }



    }

    public void paint(Graphics g){

        ListIterator listIterator = gameObjectsToPaint.listIterator();
        while(listIterator.hasNext()){

            GameObject temp = (GameObject)listIterator.next();
            temp.paint(g);
        }

    }

}

import java.awt.*;
import java.util.*;

/**
 * Created by Cody Thomas Zeitler on 5/14/2016.
 */
public class Layer {

    private LinkedList<GameObject> gameObjectsToPaint;

    public Layer(){

        gameObjectsToPaint = new LinkedList<>();

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

    public void paint(Graphics g){

        ListIterator listIterator = gameObjectsToPaint.listIterator();

        while(listIterator.hasNext()){

            GameObject temp = (GameObject)listIterator.next();
            temp.paint(g);
        }

    }

}

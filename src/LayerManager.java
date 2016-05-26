package SimpleGameEngine;

import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/14/2016.
 */
public class LayerManager {

    private LinkedList<Layer> layerLinkedList;

    public LayerManager(){
        layerLinkedList = new LinkedList<>();
    }

    public void add(Layer layer){
        layerLinkedList.add(layer);
    }

    public void paint(Graphics g){

        ListIterator listIterator = layerLinkedList.listIterator();

        while(listIterator.hasNext()){

            Layer layer = (Layer)listIterator.next();

            layer.paint(g);

        }

    }

    public void update(int x, int y){

        ListIterator listIterator = layerLinkedList.listIterator();

        while(listIterator.hasNext()){

            Layer layer = (Layer)listIterator.next();
            layer.update(x,y);

        }


    }



}

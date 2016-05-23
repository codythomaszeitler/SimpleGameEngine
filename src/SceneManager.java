import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/15/2016.
 */
public class SceneManager extends JComponent {

    private LinkedList<Scene> sceneLinkedList;

    public SceneManager(){
        sceneLinkedList = new LinkedList<>();
    }

    public void add(Scene scene){
        sceneLinkedList.add(scene);
    }

    public void paintComponent(Graphics g){

        ListIterator listIterator = sceneLinkedList.listIterator();

        while(listIterator.hasNext()){
            Scene temp = (Scene)listIterator.next();

            temp.paint(g);

        }

    }



}

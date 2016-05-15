import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/15/2016.
 */
public class RelativeGameObjectManager {

    private GameObject gameObject;
    private LinkedList<RelativeGameObject> relativeGameObjectLinkedList;

    public RelativeGameObjectManager(GameObject gameObject){
        this.gameObject = gameObject;
        relativeGameObjectLinkedList = new LinkedList<>();
    }
    public void add(GameObject gameObject, int x, int y){
        RelativeGameObject relativeGameObject = new RelativeGameObject(gameObject, x, y);
        relativeGameObjectLinkedList.add(relativeGameObject);
    }
    public void paint(Graphics g){

        if(relativeGameObjectLinkedList.size() == 0){
            return;
        }

        ListIterator listIterator = relativeGameObjectLinkedList.listIterator();

        while(listIterator.hasNext()){
            RelativeGameObject temp = (RelativeGameObject)listIterator.next();

            int xCoordinate = temp.getX() + gameObject.getxCoordinate();
            int yCoordinate = temp.getY() + gameObject.getyCoordinate();


            g.fillRect(xCoordinate, yCoordinate,
                    gameObject.getWidth(),
                    gameObject.getHeight());


        }

    }

    private class RelativeGameObject{
        private int x;
        private int y;
        private GameObject gameObject;

        public RelativeGameObject(GameObject gameObject, int x, int y){
            this.x = x;
            this.y = y;
            this.gameObject = gameObject;
        }
        public int getX(){
            return x;
        }
        public void setX(int x){
            this.x = x;
        }
        public int getY(){
            return y;
        }
        public void setY(int y){
            this.y = y;
        }

    }

}

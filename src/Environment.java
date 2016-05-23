import java.awt.*;
import java.util.*;

/**
 * Created by Cody Thomas Zeitler on 5/15/2016.
 */


//collection of GameObjects that are used by a Scene to determine when actions should take place.
public abstract class Environment implements Script{

    protected LinkedList<GameObject> gameObjectLinkedList;
    private ScriptRunner scriptRunner;

    private LinkedList<GameObjectGravityTriplet> gameObjectGravityTripletLinkedList;

    public Environment(){
        gameObjectLinkedList = new LinkedList<>();
        gameObjectGravityTripletLinkedList = new LinkedList<>();
        scriptRunner = new ScriptRunner(this, 5);
    }

    public void add(GameObject gameObject){

        if(gameObject.getHasScript()){
            System.out.println("Gameobject with a script was added.");
            GravityController gravityController = new GravityController(gameObject, 10, true);
            gravityController.setEnvironment(this);
            gameObject.setGravityController(gravityController);
            EnvironmentCollisionDetector environmentCollisionDetector  = new EnvironmentCollisionDetector(
                    gameObject, this
            );
            GameObjectGravityTriplet temp = new GameObjectGravityTriplet(gameObject, gravityController, environmentCollisionDetector);



            gameObjectGravityTripletLinkedList.add(temp);
        }
        else{
            //When a gameObject does not have a script, it is considered part of an environment.
            gameObjectLinkedList.add(gameObject);
        }
    }

    public void start(){

        ListIterator listIterator = gameObjectGravityTripletLinkedList.listIterator();

        while(listIterator.hasNext()){
            GameObjectGravityTriplet temp = (GameObjectGravityTriplet)listIterator.next();
            temp.start();
        }

        scriptRunner.start();
    }

    public boolean collides(GameObject gameObject, String whichCollisionBox){

        whichCollisionBox = whichCollisionBox.toLowerCase();

        if(whichCollisionBox.equals("top")) {
            ListIterator listIterator = gameObjectLinkedList.listIterator();

            while (listIterator.hasNext()) {

                GameObject next = (GameObject) listIterator.next();

                Rectangle topRectangle = next.getCollisionBox("top");

                if (topRectangle.intersects(gameObject.getCollisionBox("bottom"))) {
                    return true;
                }


            }
            return false;
        }

        else if (whichCollisionBox.equals("left")) {
            ListIterator listIterator = gameObjectLinkedList.listIterator();

            while(listIterator.hasNext()){

                GameObject next = (GameObject) listIterator.next();

                Rectangle leftRectangle = next.getCollisionBox("left");

                if(leftRectangle.intersects(gameObject.getCollisionBox("right"))){
                    return true;
                }
            }
            return false;
        }
        else if (whichCollisionBox.equals("right")) {
            ListIterator listIterator = gameObjectLinkedList.listIterator();

            while(listIterator.hasNext()){

                GameObject next = (GameObject) listIterator.next();

                Rectangle rightRectangle = next.getCollisionBox("right");

                if(rightRectangle.intersects(gameObject.getCollisionBox("left"))){
                    return true;
                }
            }
            return false;
        }
        else if (whichCollisionBox.equals("bottom")) {
            ListIterator listIterator = gameObjectLinkedList.listIterator();

            while(listIterator.hasNext()){

                GameObject next = (GameObject) listIterator.next();

                Rectangle bottomRectangle = next.getCollisionBox("bottom");

                if(bottomRectangle.intersects(gameObject.getCollisionBox("top"))){
                    return true;
                }
            }
            return false;
        }
        else{
            return false;
        }


    }

    private class GameObjectGravityTriplet {

        private GameObject gameObject;
        private GravityController gravityController;
        private EnvironmentCollisionDetector environmentCollisionDetector;

        public GameObjectGravityTriplet(GameObject gameObject, GravityController gravityController,
                                        EnvironmentCollisionDetector environmentCollisionDetector){
            this.gameObject = gameObject;
            this.gravityController = gravityController;
            this.environmentCollisionDetector = environmentCollisionDetector;
        }
        public void start(){
            environmentCollisionDetector.start();
            gravityController.start();
        }

    }

    public abstract void script();

    //Detects whether the game object has collided with the bottom, left or right side of an environment.
    private class EnvironmentCollisionDetector implements  Script{

        private ScriptRunner scriptRunner;
        private Environment environment;
        private GameObject gameObject;

        public EnvironmentCollisionDetector(GameObject gameObject, Environment environment){
            this.gameObject = gameObject;
            this.environment = environment;

            scriptRunner = new ScriptRunner(this, 10);


        }
        public void start(){
            scriptRunner.start();
        }


        public void script(){
            if (environment.collides(gameObject, "left")) {
                gameObject.setCanMoveRight(false);
            }
            else{
                gameObject.setCanMoveRight(true);
            }
            if(environment.collides(gameObject, "right")){
                gameObject.setCanMoveLeft(false);
            }
            else{
                gameObject.setCanMoveLeft(true);
            }
            if(environment.collides(gameObject, "bottom")){
                gameObject.setCanMoveUp(false);
            }
            else{
                gameObject.setCanMoveUp(true);
            }
        }


    }

}

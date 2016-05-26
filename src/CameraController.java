package SimpleGameEngine;

import java.awt.*;

/**
 * Created by Cody Thomas Zeitler on 5/22/2016.
 */
public class CameraController implements Script{

    //Mario should always be at the center of the screen.
    private int centerXCoordinate;
    private int centerYCoordinate;
    private final int ZERO;
    private int cameraSpeed;

    private Rectangle right;
    private Rectangle left;
    private Rectangle top;
    private Rectangle bottom;
    private ScriptRunner scriptRunner;

    private int gameFrameWidth;
    private int gameFrameHeight;

    private GameFrame gameFrame;
    private GameObject gameObject;
    private LayerManager layerManager;

    public CameraController(GameFrame gameFrame, GameObject gameObject, Scene scene){
        ZERO = 0;
        cameraSpeed = 10;
        this.gameFrame = gameFrame;
        this.gameObject = gameObject;
        this.gameFrameHeight = gameFrame.getHeight();
        this.gameFrameWidth = gameFrame.getWidth();
        this.layerManager = scene.getLayerManager();

        int xCoordinateDx = (int)(gameFrameWidth * .25);
        int xDx = gameFrameWidth - xCoordinateDx;

        int yCoordinateDy = (int)(gameFrameHeight * .25);
        int yDx = gameFrameHeight - yCoordinateDy;


        centerXCoordinate = this.gameFrame.getWidth() / 2;
        centerYCoordinate = this.gameFrame.getHeight() / 2;


        right = new Rectangle(xDx, 0, xCoordinateDx, gameFrameHeight);
        left = new Rectangle(0, 0, xCoordinateDx, gameFrameHeight);
        top = new Rectangle(0, 0,  gameFrameWidth, yCoordinateDy);
        bottom = new Rectangle(0, yDx, gameFrameWidth, yCoordinateDy);

        scriptRunner = new ScriptRunner(this, 1);
        scriptRunner.start();

    }

    public void setCameraSpeed(int cameraSpeed){
        this.cameraSpeed = cameraSpeed;
    }

    public void print(){

        System.out.format("Top: %s\nBottom: %s\nLeft: %s\nRight: %s\n",
                top.toString(), bottom.toString(), left.toString(), right.toString());


    }

    public void script(){


        centerXCoordinate = this.gameFrame.getWidth() / 2;
        centerYCoordinate = this.gameFrame.getHeight() / 2;

        int gameObjectXCoordinate = gameObject.getXCoordinate();
        int gameObjectYCoordinate = gameObject.getYCoordinate();

        /*if (gameObjectXCoordinate > gameFrameWidth || gameObjectYCoordinate > gameFrameHeight){

            gameObject.setXCoordinate(gameObjectXCoordinate);
            gameObject.setYCoordinate(gameObjectYCoordinate);

            layerManager.update(gameObjectXCoordinate, gameObjectYCoordinate);

        }*/

        if (top.intersects(gameObject.getCollisionBox("top"))) {

            System.out.println("GameObject has intersected the top.");

            layerManager.update(ZERO, cameraSpeed);

        }

        if (bottom.intersects(gameObject.getCollisionBox("bottom"))) {
            System.out.println("GameObject has intersected the bottom.");

            layerManager.update(ZERO, -1 * cameraSpeed);

        }

        if (right.intersects(gameObject.getCollisionBox("right"))) {
            System.out.println("GameObject has intersected the right.");

            layerManager.update(-1 * cameraSpeed, ZERO);

        }

        if (left.intersects(gameObject.getCollisionBox("left"))) {
            System.out.println("GameObject has intersected the left.");

            layerManager.update(cameraSpeed, ZERO);

        }

        if(gameFrame.getHeight() != gameFrameHeight || gameFrame.getWidth() != gameFrameWidth){

            gameFrameHeight = gameFrame.getHeight();
            gameFrameWidth = gameFrame.getWidth();

            //Change the camera controller rectangles.
            //You want the movement rectangles to be 25% of the screen.

            int xCoordinateDx = (int)(gameFrameWidth * .25);
            int xDx = gameFrameWidth - xCoordinateDx;

            int yCoordinateDy = (int)(gameFrameHeight * .25);
            int yDx = gameFrameHeight - yCoordinateDy;

            right.setBounds( xDx, 0, xCoordinateDx, gameFrameHeight );
            left.setBounds( 0, 0 ,  xCoordinateDx, gameFrameHeight );
            top.setBounds(0 , 0 , gameFrameWidth, yCoordinateDy);
            bottom.setBounds(0, yDx, gameFrameWidth, yCoordinateDy);
        }
    }
}

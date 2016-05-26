package SimpleGameEngine;

import java.awt.*;

/**
 * Created by Cody Thomas Zeitler on 5/19/2016.
 */
public class CollisionBoxes {

    private Rectangle leftAssociativeCollisionBox;
    private Rectangle rightAssociativeCollisionBox;
    private Rectangle topAssociativeCollisionBox;
    private Rectangle bottomAssociativeCollisionBox;
    private int offset = 10;

    private int x ;
    private int y ;
    private int width;
    private int height;

    public CollisionBoxes(GameObject gameObject){
        x = gameObject.getXCoordinate();
        y = gameObject.getYCoordinate();
        width = gameObject.getWidth();
        height = gameObject.getHeight();

        leftAssociativeCollisionBox = new Rectangle(x, y + offset, offset, height - (2 * offset));
        topAssociativeCollisionBox = new Rectangle(x, y, width, offset);
        rightAssociativeCollisionBox = new Rectangle( x + width - offset, y + offset, offset, height - (2 * offset));
        bottomAssociativeCollisionBox = new Rectangle(x, y + height - offset, width, offset);
    }

    public void print(){

        System.out.format("Left: %s\nRight: %s\nTop: %s\nBottom: %s\n",
                leftAssociativeCollisionBox.toString(),
                rightAssociativeCollisionBox.toString(),
                topAssociativeCollisionBox.toString(),
                bottomAssociativeCollisionBox.toString());


    }

    public Rectangle getCollisionBox(String collisonBox){

        collisonBox = collisonBox.toLowerCase();

        if(collisonBox.equals("left")){
            return leftAssociativeCollisionBox;
        }
        else if (collisonBox.equals("right")){
            return rightAssociativeCollisionBox;
        }
        else if (collisonBox.equals("top")){
            return topAssociativeCollisionBox;
        }
        else if (collisonBox.equals("bottom")) {
            return bottomAssociativeCollisionBox;
        }
        else{
            System.out.println("Incorrect parameter entered. Returning left associative collision rectangle");
            return leftAssociativeCollisionBox;
        }

    }

    public void update(int x, int y){

        leftAssociativeCollisionBox.setLocation(

                x, y + offset

        );

        topAssociativeCollisionBox.setLocation(

                x, y

        );


        rightAssociativeCollisionBox.setLocation(

                x + width - offset, y + offset

        );

        bottomAssociativeCollisionBox.setLocation(

                x, y + height - offset

        );

    }

}

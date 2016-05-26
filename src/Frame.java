package SimpleGameEngine;

/**
 * Created by Cody Thomas Zeitler on 5/16/2016.
 */
public class Frame {

    private int topLeftXCoordinate;
    private int topLeftYCoordinate;
    private int bottomRightXCoordinate;
    private int bottomRightYCoordinate;

    public Frame(int topLeftXCoordinate, int topLeftYCoordinate, int bottomRightXCoordinate, int bottomRightYCoordinate){
        this.topLeftXCoordinate = topLeftXCoordinate;
        this.topLeftYCoordinate = topLeftYCoordinate;
        this.bottomRightXCoordinate = bottomRightXCoordinate;
        this.bottomRightYCoordinate = bottomRightYCoordinate;
    }

    public void print(){
        System.out.format("Top-left-x: %d\nTop-left-y: %d\nBottom-right-x: %d\nBottom-right-y: %d\n",
                topLeftXCoordinate, topLeftYCoordinate, bottomRightXCoordinate, bottomRightYCoordinate);
    }

    public int getTopLeftXCoordinate(){
        return topLeftXCoordinate;
    }
    public int getTopLeftYCoordinate(){
        return topLeftYCoordinate;
    }
    public int getBottomRightXCoordinate(){
        return bottomRightXCoordinate;
    }
    public int getBottomRightYCoordinate(){
        return bottomRightYCoordinate;
    }


}

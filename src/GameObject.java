import java.awt.*;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public abstract class GameObject {

    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int rotation;

    private ScriptRunner scriptRunner;

    public GameObject(int xCoordinate, int yCoordinate, int width, int height){

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;

        scriptRunner = new ScriptRunner();

    }

    public void addScript(Script script){
        scriptRunner.setScript(script);
    }
    public void addScript(Script script, long waitTime){
        scriptRunner.setScript(script);
        scriptRunner.setWaitTime(waitTime);
    }
    public void start(){
        scriptRunner.start();
    }
    public void stop(){
        scriptRunner.stop();
    }

    public void paint(Graphics g){
        //System.out.format("X == %d\n Y == %d\n Width == %d\n Height == %d\n", xCoordinate, yCoordinate, width, height);
        g.fillRect(xCoordinate, yCoordinate, width, height);
        //relativeGameObjectManager.paint(g);
    }

    public void setxCoordinate(int xCoordinate){
        this.xCoordinate = xCoordinate;
    }
    public int getxCoordinate(){
        return xCoordinate;
    }
    public void setyCoordinate(int yCoordinate){
        this.yCoordinate = yCoordinate;
    }
    public int getyCoordinate(){
        return yCoordinate;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }
    public void setRotation(int rotation){
        this.rotation = rotation;
    }
    public int getRotation(){
        return rotation;
    }

}

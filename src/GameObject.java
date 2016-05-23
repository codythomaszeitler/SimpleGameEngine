import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public abstract class GameObject {

    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int rotation;
    private int weight;
    private boolean isOnEnvironment;
    private boolean hasScript;
    private boolean canMoveLeft;
    private boolean canMoveRight;
    private boolean canMoveUp;
    private boolean canMoveDown;

    private ScriptRunner scriptRunner;

    private AnimationController animationController;

    private KeyboardInputManager keyboardInputManager;

    private CollisionBoxes collisionBoxes;

    private String id;

    private GravityController gravityController;

    private SoundController soundController;

    public GameObject(int xCoordinate, int yCoordinate, int width, int height, boolean hasScript, boolean hasSound){

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.weight = 5;
        this.hasScript = hasScript;


        if(hasScript) {
            scriptRunner = new ScriptRunner();
        }
        canMoveDown = true;
        canMoveLeft = true;
        canMoveRight = true;
        canMoveUp = true;

        if(hasSound){

        }

        collisionBoxes = new CollisionBoxes(this);

        keyboardInputManager = new KeyboardInputManager();

        animationController = new AnimationController();

        soundController = new SoundController();

    }

    public void addSound(String soundPath, String nameOfSound){
        soundController.add(soundPath, nameOfSound);
    }

    public void playSound(String nameOfSound){
        soundController.play(nameOfSound);
    }

    public boolean isCanMoveLeft(){
        return canMoveLeft;
    }
    public void setCanMoveLeft(boolean canMoveLeft){
        this.canMoveLeft = canMoveLeft;
    }
    public boolean isCanMoveRight(){
        return canMoveRight;
    }
    public void setCanMoveRight(boolean canMoveRight){
        this.canMoveRight = canMoveRight;
    }
    public boolean isCanMoveUp(){
        return canMoveUp;
    }
    public void setCanMoveUp(boolean canMoveUp){
        this.canMoveUp = canMoveUp;
    }
    public boolean isCanMoveDown(){
        return canMoveDown;
    }
    public void setCanMoveDown(boolean canMoveDown){
        this.canMoveDown = canMoveDown;
    }


    public void setGravityController(GravityController gravityController){
        this.gravityController = gravityController;
    }

    public void setGravity(boolean isGravity){
        gravityController.setIsGravityOn(isGravity);
    }

    /*
    Parameters must be of the string (in any capitlization) left, right, bottom, top
     */
    public Rectangle getCollisionBox(String collisionBox){
        return collisionBoxes.getCollisionBox(collisionBox);
    }

    public void printCollisionBoxes(){
        collisionBoxes.print();
    }

    public boolean getHasScript() {
        return hasScript;
    }

    public boolean getIsOnEnvironment(){
        return isOnEnvironment;
    }
    public void setIsOnEnvironment(boolean isOnTopOfEnvironment){
        this.isOnEnvironment = isOnTopOfEnvironment;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
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

    public void addState(State state){
        animationController.addState(state);
    }

    public void setState(String state){
        animationController.setCurrentState(state);
    }

    public void setSpriteSheet(String spriteSheetPath){
        animationController.setSpriteSheet(spriteSheetPath);
    }

    public boolean isKeyBeingPressed(int keyEvent){

        return keyboardInputManager.isKeyPressed(keyEvent);

    }

    public KeyListener getKeyListener(){

        return keyboardInputManager.getKeyListener();

    }

    public void addKeyToListenFor(int keyEvent){

        keyboardInputManager.addKey(keyEvent);

    }


    public void paint(Graphics g){

        Frame frame = animationController.getCurrentFrame();

        g.drawImage(animationController.getImage(),
                xCoordinate, yCoordinate,
                xCoordinate + width,
                yCoordinate  + height,
                frame.getTopLeftXCoordinate(), frame.getTopLeftYCoordinate(),
                frame.getBottomRightXCoordinate(), frame.getBottomRightYCoordinate(),
                null);

    }

    public void setXCoordinate(int xCoordinate){

        int currentXCoordinate = this.xCoordinate;
        int xCoordinateChange = currentXCoordinate - xCoordinate;


        //The new xCoordinate is negative. Thus, the game object will be moving to the right.
        if(xCoordinateChange < 0){


            if(canMoveRight){
                this.xCoordinate = xCoordinate;
                collisionBoxes.update(this.xCoordinate, yCoordinate);
            }

        }
        //The new XCoordinate is positive. Thus, the game will be moving to the left.
        if(xCoordinateChange > 0){

            if(canMoveLeft){
                this.xCoordinate = xCoordinate;
                collisionBoxes.update(this.xCoordinate, yCoordinate);
            }
        }

    }
    public int getXCoordinate(){
        return xCoordinate;
    }
    public void setYCoordinate(int yCoordinate){
        this.yCoordinate = yCoordinate;
        collisionBoxes.update(xCoordinate, this.yCoordinate);
    }
    public int getYCoordinate(){
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

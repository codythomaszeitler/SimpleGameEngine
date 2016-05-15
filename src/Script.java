import javax.swing.*;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public abstract class Script implements Runnable {

    private GameObject gameObject;

    public Script(GameObject gameObject){
        this.gameObject = gameObject;
    }
    protected final GameObject getGameObject(){
        return gameObject;
    }

    public abstract void run();

}

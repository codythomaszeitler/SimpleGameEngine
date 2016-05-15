import javax.swing.*;
import java.awt.*;

/**
 * Created by Cody Thomas Zeitler on 5/15/2016.
 */
public class ImplementedScript extends Script {

    public ImplementedScript(GameObject gameObject){
        super(gameObject);
    }

    public void run(){
        GameObject gameObject = super.getGameObject();

        if(SwingUtilities.isEventDispatchThread()){
            System.out.println("The runnable in Script is on the EDT.");
        }

        while(true) {

            gameObject.setxCoordinate(gameObject.getxCoordinate() + 1);
            gameObject.setyCoordinate(gameObject.getyCoordinate() + 1);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}

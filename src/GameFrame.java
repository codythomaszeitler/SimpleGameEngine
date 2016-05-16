import javax.swing.*;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public class GameFrame extends AbstractGameFrame {

    private SceneManager sceneManager;
    private FPSManager fpsManager;

    public GameFrame(){

        if(SwingUtilities.isEventDispatchThread()){
            System.out.println("The game frame constructor is on the EDT");
        }
        else{
            System.out.println("The game frame constructor is NOT on the EDT.");
        }


    }
}

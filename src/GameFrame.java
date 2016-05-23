import javax.swing.*;
import java.awt.event.KeyListener;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public class GameFrame extends AbstractGameFrame {

    private SceneManager sceneManager;
    private FPSManager fpsManager;
    private CameraController cameraController;


    public GameFrame(){
        System.setProperty("sun.java2d.opengl", "True");

        fpsManager = new FPSManager(this, 1000/60);

    }

    public void addRelativeGameObject(GameObject gameObject, Scene scene){
        cameraController = new CameraController(this, gameObject, scene);
    }

    public void addKeyboardInput(KeyListener keyListener){
        super.addKeyListener(keyListener);
    }
}

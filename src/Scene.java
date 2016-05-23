import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public abstract class Scene implements Script{

    private LayerManager layerManager;
    private EnvironmentManager environmentManager;
    private CameraController cameraController;

    public Scene(LayerManager layerManager, EnvironmentManager environmentManager) {

        this.layerManager = layerManager;
        this.environmentManager = environmentManager;

    }

    public void start(){

        environmentManager.start();

    }

    public LayerManager getLayerManager(){
        return layerManager;
    }


    public void paint(Graphics g){
        layerManager.paint(g);
    }

    public abstract void script();

}

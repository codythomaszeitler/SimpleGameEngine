package SimpleGameEngine;

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

    public Scene(){

    }

    public Scene(LayerManager layerManager){
        this.layerManager = layerManager;
    }

    public Scene(EnvironmentManager environmentManager){
        this.environmentManager = environmentManager;
    }

    public Scene(LayerManager layerManager, EnvironmentManager environmentManager) {

        this.layerManager = layerManager;
        this.environmentManager = environmentManager;

    }

    public void setLayerManager(LayerManager layerManager){
        this.layerManager = layerManager;
    }

    public void setEnvironmentManager(EnvironmentManager environmentManager){
        this.environmentManager = environmentManager;
    }

    public void start(){

        environmentManager.start();

    }

    public LayerManager getLayerManager(){
        return layerManager;
    }

    public EnvironmentManager getEnvironmentManager(){
        return environmentManager;
    }


    public void paint(Graphics g){
        layerManager.paint(g);
    }

    public abstract void script();

}

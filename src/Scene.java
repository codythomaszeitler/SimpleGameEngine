import javax.swing.*;
import java.awt.*;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public class Scene extends JPanel {

    private LayerManager layerManager;

    private Environment environment;

    public Scene(LayerManager layerManager){

        this.layerManager = layerManager;
    }

    public void paintComponent(Graphics g){
        layerManager.paint(g);
    }

}

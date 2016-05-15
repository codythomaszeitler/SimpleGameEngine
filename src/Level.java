import javax.swing.*;
import java.awt.*;

/**
 * Created by Cody Thomas Zeitler on 5/13/2016.
 */
public class Level extends JPanel {

    private LayerManager layerManager;

    public Level(LayerManager layerManager){

        this.layerManager = layerManager;
    }



    public void paintComponent(Graphics g){
        layerManager.paint(g);
    }



}

import javax.swing.*;

/**
 * Created by Cody Thomas Zeitler on 5/11/2016.
 */
public class Main {



    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        GameObject gameObject = new RedRectangle(10, 10 , 150, 150);

        gameObject.addScript((RedRectangle)gameObject, 50);
        gameObject.start();

        Layer layer = new Layer();
        layer.add(gameObject);

        LayerManager layerManager = new LayerManager();
        layerManager.add(layer);

        Scene level = new Scene(layerManager);

        frame.add(level);
        frame.setVisible(true);
        while(true){
            frame.repaint();
        }




    }



}
/*
        //new Tester();

        GameFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        GameObject cody = new GameObject(350,350,100,100);
        GameObject sam = new GameObject(0,0, 50, 50);
        cody.addRelative(sam, -250, -250);

        //Change here
        Script script = new CodyScript(cody);
        GameObject kirk = new GameObject(500,500, 350, 350);
        Script kirkScript = new KirkScript(kirk);
        //Change here

        cody.setUpGameObjectThread(script);
        kirk.setUpGameObjectThread(kirkScript);
        cody.start();
        kirk.start();

        Layer layer = new Layer();
        layer.add(cody);
        layer.add(kirk);

        LayerManager layerManager = new LayerManager();
        layerManager.add(layer);

        Scene level = new Scene(layerManager);

        frame.add(level);
        frame.setVisible(true);

        while(true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            frame.repaint();
        }

    }


 */
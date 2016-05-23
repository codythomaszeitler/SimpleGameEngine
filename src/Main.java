import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Cody Thomas Zeitler on 5/11/2016.
 */
public class Main{


    public static void main(String[] args) {
        new MainGameControl();


    }



}
/*

 GameFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        GameObject gameObject = new Mario(10, 10 , 150, 150);

        gameObject.addScript((Mario)gameObject, 50);
        gameObject.start();

        GameObject blueThing = new TestingMarioBlockBlueDot(850,850,250,250);
        blueThing.setId("BlueThing");
        gameObject.setId("Mario");

        Layer layer = new Layer();
        layer.add(blueThing);
        layer.add(gameObject);


        LayerManager layerManager = new LayerManager();
        layerManager.add(layer);

        Environment environment = new TestingEnvironment((Mario)gameObject);
        environment.add(blueThing);
        environment.start();

        Scene level = new TestingScene(layerManager, environment);
        SceneManager sceneManager = new SceneManager();
        sceneManager.add(level);
        level.startScene();

        frame.add(sceneManager);
        frame.setVisible(true);
        while(true){
            frame.repaint();
        }
    }





State marioStanding = new State(1, 2, "MarioStanding");
        State marioRunningLeft = new State(2, 2, "MarioRunningLeft");
        State marioRunningRight = new State(2, 2, "MarioRunningRight");
        State marioSwimmingRight = new State(5, 2, "MarioSwimmingRight");

        marioStanding.addFrame(14,10,28,30);

        marioRunningLeft.addFrame(28,10,14,30);
        marioRunningLeft.addFrame(46,10,31,30);

        marioRunningRight.addFrame(14,10,28,30);
        marioRunningRight.addFrame(31,10,46,30);


        marioSwimmingRight.addFrame(12,37,27,56);
        marioSwimmingRight.addFrame(29,37,44,56);
        marioSwimmingRight.addFrame(45,37,60,56);
        marioSwimmingRight.addFrame(63,37,80,56);
        marioSwimmingRight.addFrame(80,37,97,56);

        animationController
                = new AnimationController("C:\\Users\\Cody Thomas Zeitler\\SimpleGameEngine\\src\\SNES - Super Mario World - Mario copy.png");

        animationController.addState(marioStanding);
        animationController.addState(marioRunningLeft);
        animationController.addState(marioRunningRight);
        animationController.addState(marioSwimmingRight);

        animationController.print();
        animationController.setCurrentState("MarioSwimmingRight");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);




        while(true){
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }



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


 */        /*State marioStanding = new State(1, 30, "MarioStanding");
        State marioRunningLeft = new State(2, 30, "MarioRunningLeft");
        State marioRunningRight = new State(2, 30, "MarioRunningRight");

        marioStanding.addFrame(14,10,28,30);

        marioRunningLeft.addFrame(28,10,14,30);
        marioRunningLeft.addFrame(46,10,31,30);

        marioRunningRight.addFrame(14,10,28,30);
        marioRunningRight.addFrame(31,10,46,30);

        animationController
                = new AnimationController("C:\\Users\\Cody Thomas Zeitler\\SimpleGameEngine\\src\\SNES - Super Mario World - Mario copy.png");

        animationController.addState(marioStanding);
        animationController.addState(marioRunningLeft);
        animationController.addState(marioRunningRight);

        animationController.print();
        animationController.setCurrentState("MarioRunningLeft");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);

        Thing thing = new Thing(animationController);

        frame.addKeyListener(thing);

        frame.add(thing);

        while(true){
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }


*/

        /*GameFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);


        GameObject gameObject = new RedRectangle(10, 10 , 150, 150);

        gameObject.addScript((RedRectangle)gameObject, 50);
        gameObject.start(); //this line



        Layer layer = new Layer();
        layer.add(gameObject);

        LayerManager layerManager = new LayerManager();
        layerManager.add(layer);

        Scene level = new Scene(layerManager);

        frame.add(level);
        frame.setVisible(true);

        int i = 0;


        while(true){
            frame.repaint();
            i++;

            try{
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            if( i == 400) {
                gameObject.stop();
            }
        }



*/
/**
 * Created by Cody Thomas Zeitler on 5/15/2016.
 */
public class FPSManager implements Script{

    private GameFrame gameFrame;
    private long waitTime;
    private ScriptRunner scriptRunner;


    public FPSManager(GameFrame gameFrame, long waitTime){
        this.gameFrame = gameFrame;
        this.waitTime = waitTime;
        scriptRunner = new ScriptRunner(this, waitTime);
        scriptRunner.start();
    }

    public void script(){
        gameFrame.repaint();
    }



}

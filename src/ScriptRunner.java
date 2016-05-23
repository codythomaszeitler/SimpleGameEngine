import java.util.concurrent.Semaphore;

/**
 * Created by Cody Thomas Zeitler on 5/15/2016.
 */
public class ScriptRunner implements  Runnable {

    private final long STANDARD_WAIT_TIME = 1000;

    private String id;
    private Script script;
    private long waitTime;
    private static int numberOfScriptRunner = 0;
    private volatile boolean isActive;
    private volatile boolean isRunning;

    private volatile Thread scriptCode;

    /*
    Default Constructor.
    Sets script to null.
    Sets isRunning to False.
    Sets waitTime to standard of 1 seconds, or 1000 milliseconds).
    id is set to a static integer that is increased at every creation of a ScriptRunner.
     */
    public ScriptRunner(){
        script = null;
        isRunning = false;
        waitTime = STANDARD_WAIT_TIME;
        id = Integer.toString(numberOfScriptRunner);
        numberOfScriptRunner = numberOfScriptRunner + 1;
        scriptCode = new Thread(null, this, id);
        scriptCode.start();
        isActive = true;

    }

    /*
    Parameters:
    Script script: Script is an interface that has a method in it called script(). This method is the one that will
    be executed by the run commands listed in this object.
     */
    public ScriptRunner(Script script){
        this.script = script;
        this.waitTime = STANDARD_WAIT_TIME;
        isRunning = false;
        id = Integer.toString(numberOfScriptRunner);
        numberOfScriptRunner = numberOfScriptRunner + 1;
        scriptCode = new Thread(null, this, id);
        scriptCode.start();
        isActive = true;
    }

    /*
    Parameters:
    Script script: Script is an interface that has a method in it called script(). This method is the one that will
    be executed by the run commands listed in this object.
    long waitTime: waitTime is the amount of time the thread waits before re-executing the script.
     */
    public ScriptRunner(Script script, long waitTime){
        this.script = script;
        this.waitTime = waitTime;
        isRunning = false;
        id = Integer.toString(numberOfScriptRunner);
        numberOfScriptRunner = numberOfScriptRunner + 1;
        scriptCode = new Thread(null, this, id);
        scriptCode.start();
        isActive = true;
    }

    /*
    delete() makes the thread cease execution completely. The thread cannot call any
    other function after this call and hopefully the JVM will delete the thread object
    for purposes of efficiency.
    DO NOT CALL THIS UNLESS YOU KNOW FOR A FACT YOU WILL NOT USE THIS THREAD AGAIN.
     */
    public void delete(){
        isActive = false;
        isRunning = false;
        scriptCode = null;
    }

    /*
    start() makes the thread start executing the script code within the scriptrunner class.
     */
    public void start(){
        isRunning = true;
    }
    /*
    stop() stops the thread from executing the script after the current iteration ends.
     */
    public void stop(){
        isRunning = false;
    }

    /*
    Parameters: Script script. This function will change the current script code to the one provided by script.
     */
    public void setScript(Script script){
        this.script = script;
    }

    /*
    Parameters: long waitTime. This function will change the wait time of the script to the one provided by waitTime.
     */
    public void setWaitTime(long waitTime){
        this.waitTime = waitTime;
    }

    public void run(){

        while(isActive){

            while(isRunning){
                script.script(); //Executes the code one time that is held by the script reference.
                try {
                    Thread.sleep(waitTime); //Makes the thread wait for a certain amount of time before it's next execution.
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }
}

/**
 * Created by Cody Thomas Zeitler on 5/19/2016.
 */


/*
All this class does is take in gameObject and makes it continually fall.
This controller needs to know about a environment to tell the gameObject when to stop falling.

 */
public class GravityController implements Script{

    private boolean isGravityOn;
    private boolean isOnEnvironment;
    private ScriptRunner scriptRunner;
    private int gravityStrength;
    private GameObject gameObject;
    private Environment environment;

    public GravityController(GameObject gameObject, int gravityStrength, boolean isGravityOn){

        this.gameObject = gameObject;
        this.gravityStrength = gravityStrength;
        this.isGravityOn = isGravityOn;

        isOnEnvironment = false;

        scriptRunner = new ScriptRunner(this, 10);

    }
    public void start(){
        scriptRunner.start();
    }

    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

    public void setIsGravityOn(boolean isGravityOn){
        this.isGravityOn = isGravityOn;
    }

    public void script(){

        if(isGravityOn){

            if(!isOnEnvironment){

                gameObject.setYCoordinate(gameObject.getYCoordinate() + gravityStrength);

                if(environment.collides(gameObject, "top")){
                    isOnEnvironment = true;
                    gameObject.setIsOnEnvironment(true);
                    gameObject.setCanMoveDown(false);
                }
            }
            else{
                if(!environment.collides(gameObject, "top")){
                    isOnEnvironment = false;
                    gameObject.setIsOnEnvironment(false);
                    gameObject.setCanMoveDown(true);
                }
            }
        }
    }
}

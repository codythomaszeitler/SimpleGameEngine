import javafx.animation.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/16/2016.
 */
public class AnimationController {

    private LinkedList<State> stateLinkedList; //where all states are linked together.
    private String currentState; //what state the Animation Controller is accessing.
    private BufferedImage image; //the sprite sheet the Animation Controller is looking at.

    /*
    Default constructor of the Animation Controller.
    Parameters: NONE.
    All this does is allocate memory for the linked list of states.
    You still need to set a path for the sprite sheet, and also add states to make any use of the Animation Controller.
     */
    public AnimationController(){
        stateLinkedList = new LinkedList<>();
        image = null;
    }

    /*
    AnimationController with a one parameter constructor.
    Parameters: imagePathName.
    Creates an Animation Controller with a path towards a bufferedImage as dented by imagePathName.
    There are no states currently in the AnimationController. You need to add states to make any use of the
    AnimationController.
     */
    public AnimationController(String imagePathName){
        stateLinkedList = new LinkedList<>();
        try{
            image = ImageIO.read(new File(imagePathName));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    Sets the sprite sheet of the Aninmation Controller to the path denoted by imagePathName.
     */
    public void setSpriteSheet(String imagePathName){
        try{
            image = ImageIO.read(new File(imagePathName));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Parameters: String currentState.
    Changes the current state of the Animation Controller to the string provided by currentState.
     */
    public void setCurrentState(String currentState){
        this.currentState = currentState;
    }

    /*
    Returns BufferedImage image.
    Returns a reference to the sprite sheet that this AnimationController is acting on.
     */
    public BufferedImage getImage(){
        return image;
    }
    /*
    Parameters: State state.
    Adds a state to this animation controller. Once this state is in the Animation Controller, you can swap to this
    state by calling setCurrentState(String currentState). The state will then run and switch frames as whatever is
    denoted by the State object.
    NOTE. You switch states by passing the identifier of the state of the state to currentState. Thus, make
    sure you have a non-null value for your string.
     */
    public void addState(State state){
        stateLinkedList.add(state);
    }

    /*
    Print function used for debugging purposes.
    Shows you all states listed in this Animation Controller and all frames located within those states.
     */
    public void print(){
        ListIterator listIterator = stateLinkedList.listIterator();

        while(listIterator.hasNext()){
            State temp = (State)listIterator.next();
            temp.print();
        }
    }

    /*
    Returns a Frame Object.
    getCurrentFrame gets the current frame based on the what the current State is (as deonted by setCurrentState)
    and what frame is currently active within that state.
     */
    public Frame getCurrentFrame(){
        ListIterator listIterator = stateLinkedList.listIterator();

        while(listIterator.hasNext()){
            State temp = (State)listIterator.next();
            if(temp.getId().equals(currentState)){
                return temp.getCurrentFrame();
            }
        }
        return null;
    }
}

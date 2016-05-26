package SimpleGameEngine;

/**
 * Created by Cody Thomas Zeitler on 5/16/2016.
 */
public class State {

    private Frame[] frame; //holds all frames of the state.

    private int counter; //how many getCurrentFrame function call there has been.
    private int numberOfFrames; //max number of frames.
    private int frameChange; //how many getCurrentFrame has to be called  for the sprite to change frame.
    private int currentFrame; //what frame index of frame array is currently being accessed by the state.

    private int frames; //how many frames are currently allocated to the state (note: can be different than numberOfFrames.

    private String id; //identifier of the State.

    /*
    Constructor, 3 argument.
    Parameters:
    int numberOfFrames: shows the max number of frames this AnimationConroller can hold.
    int frameChange: shows at how many frames will the state change to another frame.
    String id: the identifier used to access this state once given to an Animation Controller.
     */
    public State(int numberOfFrames, int frameChange, String id){
        this.numberOfFrames = numberOfFrames;
        this.frameChange = frameChange;
        this.id = id;
        counter = 0;
        frame = new Frame[numberOfFrames];
        frames = 0;
        currentFrame = 0;

        for(int i = 0; i < numberOfFrames; i ++){
            frame[i] = null;
        }

    }
    /*
    Returns String.
    Returns the identifier held by the State object.
     */
    public String getId(){
        return id;
    }

    /*
    Parameters: String id;
    Sets the identifier of the state to whatever String is provided by id.
     */
    public void setId(String id){
        this.id = id;
    }

    /*
    Print is used for debugging.
    Prints out all frames data within the state.
     */
    public void print(){
        System.out.format("Id: %s\nNumber of frames: %d\nFrame change on: %d\n", id, numberOfFrames, frameChange);

        for(int i = 0; i < frames; i++){
            frame[i].print();
        }
    }

    /*
    Parameters: int topLeftXCoordinate, int topLeftYCoordinate, int bottomRightXCoordinate, int bottomRightYCoordinate
    The first two parameters correlate to the top left sub-image coordinate of the sprite sheet.
    The last two parameters correlate to the bottom right sub-image coordinate of the sprite sheet.

    Creates a new Frame object given the four parameters.
    Adds the newly created frame at the next null spot of the frame array
     */
    public void addFrame(int topLeftXCoordinate, int topLeftYCoordinate, int bottomRightXCoordinate, int bottomRightYCoordinate){

        /*int i =0;
        while(frame[i] != null){
            i++;
        }
        System.out.format("The frame was added at index i: %d \n", i);

        //This denotes the user has entered to many frames. Thus, no more frames can or will be added.
        if(i >= numberOfFrames){
            System.out.println("Too many frames added! Frame entered has not been added to state." +
                "You have exceeded the max amount of frames for this state.");
            return;
        }*/


        if(frames == numberOfFrames){
            System.out.println("Too many frames added! Frame entered has not been added to state." +
                    "You have exceeded the max amount of frames for this state.");
            return;
        }

        frame[frames] = new Frame(topLeftXCoordinate, topLeftYCoordinate, bottomRightXCoordinate, bottomRightYCoordinate);
        frames++;
    }

    /*
    Parameters: NONE.
    Returns a Frame object. Frames objects hold the proper s location arguments for the nine parameter drawImage function
    call. Every time this function is called, the counter is moved up once. Once the counter has exceeded or become
    equivalent to frameChange(how many frames have to pass before the Frame changes within the state) the currentFrame
    index will increase by one. If the currentFrame becomes equivalent of greater than the total number of frames
    located within the state, the currentFrame counter goes back to 0.
    The frame returned is the frame held by the array of frames at currentFrame.
    This function gives the illusion of animation by cylcing through all the frames of the State. The frame changes
    at every frameChange calls of getCurrentFrame.
     */
    public Frame getCurrentFrame(){

        if(counter >= frameChange){
            currentFrame++;
            if(currentFrame == numberOfFrames){
                currentFrame = 0;
            }
            counter = 0;
        }
        counter++;
        return frame[currentFrame];

    }



}

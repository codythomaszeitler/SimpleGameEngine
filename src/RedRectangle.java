/**
 * Created by Cody Thomas Zeitler on 5/16/2016.
 */
public class RedRectangle extends GameObject implements Script {


    public RedRectangle(int x, int y, int width, int height){
        super(x, y, width, height);

    }

    public void script(){

        super.setxCoordinate(super.getxCoordinate() + 1);
        super.setyCoordinate(super.getyCoordinate() + 1);
    }
}

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 5/17/2016.
 */
public class EnvironmentManager {

    private LinkedList<Environment> environmentLinkedList;

    public EnvironmentManager(){
        environmentLinkedList = new LinkedList<>();
    }
    public void add(Environment environment){
        environmentLinkedList.add(environment);
    }
    public void start(){
        ListIterator listIterator = environmentLinkedList.listIterator();
        while(listIterator.hasNext()){
            Environment temp = (Environment)listIterator.next();
            temp.start();
        }
    }


}

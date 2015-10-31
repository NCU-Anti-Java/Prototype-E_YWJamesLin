/**
 * Created by User on 2015/10/30.
 */
import java.util.Random;

public class BasicBlock {
    private int type;

    public BasicBlock () {
        Random rand = new Random();
        type = rand.nextInt(5);
    }

    public int getType () { return type; }
}
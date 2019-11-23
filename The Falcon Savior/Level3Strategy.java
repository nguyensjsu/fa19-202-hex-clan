import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Level3Strategy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level3Strategy implements ILevelStrategy {

    private int targetScore = 0;

    public int getTargetScore() {
        return targetScore;
    }

    public List<IComponent> getTroops() {
        return new ArrayList<>();
    }
}
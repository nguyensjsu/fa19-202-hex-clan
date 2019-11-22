import greenfoot.Color;
import greenfoot.GreenfootImage;

import java.util.List;

public class Level extends Leaf {

    private int level = 1;

    private ILevelStrategy currentStrategy;

    Level(int x, int y) {
        super(x, y);
        setLevelForStrategy(level);
    }

    List<IComponent> getEnemyTroops() {
        return currentStrategy.getTroops();
    }

    private void setLevelForStrategy(int level) {
        switch (level) {
            case 2:
                currentStrategy = new Level2Strategy();
                break;
            case 3:
                currentStrategy = new Level3Strategy();
                break;
            default:
                currentStrategy = new Level1Strategy();
                break;
        }
    }

    public void act() {
        setImage(new GreenfootImage("Level : " + level, 20, Color.GREEN, Color.BLACK, Color.YELLOW));
    }
}

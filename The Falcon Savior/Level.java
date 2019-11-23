import greenfoot.Color;
import greenfoot.GreenfootImage;

import java.util.List;

public class Level extends Leaf implements ILevelSubject {

    private int level = 1;
    private ILevelStrategy currentStrategy;
    private int targetScore = 0;
    private int currentScore = 0;
    private ILevelObserver levelObserver;

    Level(int x, int y) {
        super(x, y);
        setLevelForStrategy(level);
    }

    List<IComponent> getEnemyTroops() {
        List<IComponent> troops = currentStrategy.getTroops();
        targetScore += currentStrategy.getTargetScore();
        return troops;
    }

    void levelIncrementCheck(int score) {
        currentScore += score;
        if (targetScore == currentScore) {
            setLevelForStrategy(++level);
            notifyObserver();
            act();
        }
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

    public void addObserver(ILevelObserver observer) {
        this.levelObserver = observer;
    }

    public void removeObserver(ILevelObserver observer) {
        if (this.levelObserver == observer) {
            this.levelObserver = null;
        }
    }

    public void notifyObserver() {
        if (null != levelObserver) {
            levelObserver.onLevelIncreased();
        }
    }
}

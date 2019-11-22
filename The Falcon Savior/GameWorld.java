import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class GameWorld extends World {

    /**
     * Constructor for objects of class GameWorld.
     */
    GameWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();

        IComponent gameScreen = new Component();
        IComponent enemyGroup = new Component();

        Level level = new Level(50, 50);
        enemyGroup.addChildren(level.getEnemyTroops());

        gameScreen.addChild(level);
        gameScreen.addChild(enemyGroup);

        PlayerShip firstplayer = new PlayerShip1(500, 700);
        PlayerShip secondplayer = new PlayerShip2(400, 700);

        gameScreen.addChild(firstplayer);
        gameScreen.addChild(secondplayer);
        gameScreen.display(this);
    }

    private void scaleBackground() {
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(1000, 800);
        setBackground(backgroundImage);
    }
}

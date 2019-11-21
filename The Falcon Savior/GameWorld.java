import greenfoot.*;

/**
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameWorld extends World {

    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
        IComponent gameScreen=new Component();
        IComponent enemyGroup=new Component();
        
        enemyGroup.addChild(new EnemyShip(this,100,80));
        enemyGroup.addChild(new EnemyShip(this,150,90));
        enemyGroup.addChild(new EnemyShip(this,200,90));
        enemyGroup.addChild(new EnemyShip(this,250,90));
        enemyGroup.addChild(new EnemyShip(this,350,90));
        
        gameScreen.addChild(enemyGroup);
        gameScreen.addChild(new MilleniumFalcon(this, 500, 700));
        gameScreen.display();
    }
    
    private void scaleBackground() {
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(1000, 800);
        setBackground(backgroundImage);
    }
}

import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class EnemyShip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyShip extends Leaf {
    /**
     * Act - do whatever the EnemyShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int direction = 1;
    int speed = 4;
    GreenfootImage image = new GreenfootImage("enemy_ship.png");

    public EnemyShip(World world, int x, int y) {

        super(world, x, y);
        //this.world=world;
        //setLocation(x,y);
    }

    public void act() {
        // Add your action code here.
        move();
    }

    public void move() {
        if (isAtEdge()) {
            toggleDirection();
        }

        this.setLocation(getX() + (speed * direction), getY());

        if (isTouching(Rocket.class)) {
            removeTouching(Rocket.class);
        }
    }

    public void toggleDirection() {
        direction = direction * -1;
    }

    public void display() {
        setImage(image);
        world.addObject(this, x, y);
    }


}
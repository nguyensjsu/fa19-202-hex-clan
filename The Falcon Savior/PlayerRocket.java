import greenfoot.World;

/**
 * Write a description of class Rocket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerRocket extends Projectile {
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    PlayerRocket(int x, int y) {
        super(x, y, LeafFactory.getLeafType("PlayerRocket", "player_rocket.png", null));
    }

    public void act() {
        // Add your action code here.
        this.setLocation(getX(), getY() - 4);

        if (this.isTouching(EnemyShip.class)) {
            notifyProjectileOwner(Event.SCORE);
            removeTouching(EnemyShip.class);
            inWorld = false;
            getWorld().removeObject(this);
        }

        if (inWorld && getY() <= 0) {
            getWorld().removeObject(this);
            inWorld = false;
        }
    }

    public void display(World world) {
        inWorld = true;
        super.display(world);
    }
}

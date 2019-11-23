import greenfoot.World;

/**
 * Write a description of class EnemyRocket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyRocket extends Projectile {
    /**
     * Act - do whatever the EnemyRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    EnemyRocket(int x, int y) {
        super(x, y, LeafFactory.getLeafType("EnemyRocket", "enemy_rocket.png", null));
    }

    public void act() {
        // Add your action code here.
        this.setLocation(getX(), getY() + 4);

        if (this.isTouching(PlayerShip.class) || this.isTouching(PlayerRocket.class)) {
            if (this.isTouching(PlayerShip.class)) {
                PlayerShip playerShip = (PlayerShip) (getOneIntersectingObject(PlayerShip.class));
                playerShip.notifyHandlers(Event.LIFE);
                notifyProjectileOwner(Event.LIFE);
            }
            removeTouching(PlayerRocket.class);
            inWorld = false;
            getWorld().removeObject(this);
        }

        if (inWorld && getY() + 10 > getWorld().getHeight()) {
            getWorld().removeObject(this);
            inWorld = false;
        }
    }

    public void display(World world) {
        inWorld = true;
        super.display(world);
    }
}

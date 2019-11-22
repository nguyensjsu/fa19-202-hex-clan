/**
 * Write a description of class EnemyRocket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyRocket extends Leaf {
    /**
     * Act - do whatever the EnemyRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    EnemyRocket(int x, int y) {
        super(x, y, LeafFactory.getLeafType("EnemyRocket", "rocket.png", null));
        turn(180);
    }

    public void act() {
        // Add your action code here.
        this.setLocation(getX(), getY() + 4);

        if (this.isTouching(PlayerShip.class) || this.isTouching(Rocket.class)) {
            removeTouching(PlayerShip.class);
            removeTouching(Rocket.class);
            inWorld = false;
            getWorld().removeObject(this);
        }

        if (inWorld && getY() + 10 > getWorld().getHeight()) {
            getWorld().removeObject(this);
            inWorld = false;
        }
    }
}

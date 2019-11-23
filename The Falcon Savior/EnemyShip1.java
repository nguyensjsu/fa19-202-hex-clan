import greenfoot.Greenfoot;

/**
 * Write a description of class EnemyShip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyShip1 extends EnemyShip {

    private int rocketWaitLock = 0;

    EnemyShip1(int direction, int x, int y) {
        super(direction, x, y, LeafFactory.getLeafType("EnemyShip1", "enemy_ship_1.png", null));
    }

    public void act() {
        // Add your action code here.
        checkMove();
        if (script == Script.NORMAL) {
            move();
            shoot();
        } else if (script == Script.DOWN) {
            moveDown();
        }
        if (rocketWaitLock > 0) {
            rocketWaitLock--;
        }
    }

    private void shoot() {
        if (Greenfoot.getRandomNumber(700) <= 1 && rocketWaitLock == 0) {
            rocketWaitLock = 300 + Greenfoot.getRandomNumber(600);
            IProjectile rocket = new EnemyRocket(getX(), getY() + 10);
            rocket.addProjectileOwner(this);
            IComponent wrappedRocket = new DualSoundDecorator((IComponent) rocket);
            wrappedRocket.display(getWorld());
        }
    }
}
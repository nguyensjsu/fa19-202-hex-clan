import greenfoot.Greenfoot;

/**
 * Write a description of class Player1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerShip1 extends PlayerShip {

    private boolean isShooting = false;

    private int reloadDelayCount = 25;

    PlayerShip1(int x, int y) {
        super(x, y, LeafFactory.getLeafType("PlayerShip1", "millennium_falcon.png", null));
        speed = 5;
    }

    public void control() {
        reloadDelayCount++;
        if (Greenfoot.isKeyDown("LEFT")) {
            //moves right
            moveRight();
        }
        if (Greenfoot.isKeyDown("RIGHT")) {
            //moves left
            moveLeft();
        }

        if (Greenfoot.isKeyDown("space") && !isShooting && reloadDelayCount >= 25) {
            shoot();
            isShooting = true;
            reloadDelayCount = 0;
        }

        if (!Greenfoot.isKeyDown("space") && isShooting) {
            isShooting = false;
        }
    }
}

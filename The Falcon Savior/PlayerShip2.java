import greenfoot.Greenfoot;

/**
 * Write a description of class Player2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerShip2 extends PlayerShip {

    private boolean isShooting = false;

    private int reloadDelayCount = 25;

    PlayerShip2(int x, int y) {
        super(x, y, LeafFactory.getLeafType("PlayerShip2", "millennium_falcon.png", null));
        speed = 5;
    }

    public void control() {
        reloadDelayCount++;
        if (Greenfoot.isKeyDown("a")) {
            //moves right
            moveRight();
        }
        if (Greenfoot.isKeyDown("d")) {
            //moves left
            moveLeft();
        }

        if (Greenfoot.isKeyDown("w") && !isShooting && reloadDelayCount >= 25) {
            shoot();
            isShooting = true;
            reloadDelayCount = 0;
        }

        if (!Greenfoot.isKeyDown("w") && isShooting) {
            isShooting = false;
        }
    }
}

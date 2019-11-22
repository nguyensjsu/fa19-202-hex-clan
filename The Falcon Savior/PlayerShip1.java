import greenfoot.Greenfoot;

/**
 * Write a description of class Player1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerShip1 extends PlayerShip {

    private boolean isShooting = false;

    PlayerShip1(int x, int y) {
        super(x, y, LeafFactory.getLeafType("Player1", "millennium_falcon.png", null), new ScoreBoard(30, 15));
    }

    public void control() {
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
        }

        if (Greenfoot.isKeyDown("right")) {
            moveRight();
        }

        if (Greenfoot.isKeyDown("space") && !isShooting) {
            shoot();
            isShooting = true;
        }

        if (!Greenfoot.isKeyDown("space") && isShooting) {
            isShooting = false;
        }
    }
}

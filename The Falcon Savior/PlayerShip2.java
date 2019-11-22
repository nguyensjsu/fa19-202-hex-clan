import greenfoot.Greenfoot;

/**
 * Write a description of class Player2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerShip2 extends PlayerShip {

    private boolean isShooting = false;

    PlayerShip2(int x, int y) {
        super(x, y, LeafFactory.getLeafType("Player2", "millennium_falcon.png", null), new ScoreBoard(530, 15));
    }

    public void control() {
        if (Greenfoot.isKeyDown("a")) {
            moveLeft();
        }

        if (Greenfoot.isKeyDown("d")) {
            moveRight();
        }

        if (Greenfoot.isKeyDown("w") && !isShooting) {
            shoot();
            isShooting = true;
        }

        if (!Greenfoot.isKeyDown("w") && isShooting) {
            isShooting = false;
        }
    }
}

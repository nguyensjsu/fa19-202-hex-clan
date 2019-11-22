import greenfoot.Greenfoot;

/**
 * Write a description of class EnemyShip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyShip extends Leaf {
    private int count = 200 + Greenfoot.getRandomNumber(500);
    private int direction = 1;

    EnemyShip(int x, int y) {
        super(x, y, LeafFactory.getLeafType("EnemyShip", "enemy_ship.png", null));
    }

    public void act() {
        // Add your action code here.
        move();
        shoot();
        if (count > 0) {
            count--;
        }
    }

    private void move() {
        if (isAtEdge()) {
            toggleDirection();
        }

        this.setLocation(getX() + (2 * direction), getY());
    }

    private void toggleDirection() {
        direction = direction * -1;
    }

    private void shoot() {
        int number = Greenfoot.getRandomNumber(100);
        if (number >= 99 && count == 0) {
            count = 300 + Greenfoot.getRandomNumber(600);
            EnemyRocket rocket = new EnemyRocket(getX(), getY() + 10);
            rocket.display(getWorld());
        }
    }
}
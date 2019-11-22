import greenfoot.World;

/**
 * Write a description of class Rocket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rocket extends Leaf implements IScoreSubject {
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private IScoreObserver observer;

    Rocket(int x, int y) {
        super(x, y, LeafFactory.getLeafType("Rocket", "rocket.png", null));
    }

    public void act() {
        // Add your action code here.
        this.setLocation(getX(), getY() - 4);

        if (this.isTouching(EnemyShip.class)) {
            removeTouching(EnemyShip.class);
            inWorld = false;
            getWorld().removeObject(this);

            notifyObserver();
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

    public void addObserver(IScoreObserver observer) {
        this.observer = observer;
    }

    public void removeObserver(IScoreObserver observer) {
        this.observer = null;
    }

    public void notifyObserver() {
        observer.scoreUpdate();
    }
}

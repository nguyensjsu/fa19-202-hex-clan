/**
 * Write a description of class Life here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Life extends Leaf {
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Life(int x, int y) {
        super(x, y, LeafFactory.getLeafType("Life", "life.png", null));
    }

    public void act() {
        // Add your action code here.
    }

    void removeLife() {
        getWorld().removeObject(this);
    }
}
import greenfoot.Actor;
import greenfoot.World;

import java.util.List;

/**
 * Write a description of class Leaf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Leaf extends Actor implements IComponent {
    boolean inWorld = true;
    private int x;
    private int y;
    private LeafType leafType;
    private boolean hasFireSound = false;
    private boolean hasCollisionSound = false;

    /**
     * Constructor for objects of class Leaf
     */
    //public Leaf(World world, Actor actor, int x, int y)
    Leaf(int x, int y, LeafType type) {
        this.x = x;
        this.y = y;
        this.leafType = type;
    }

    Leaf(int x, int y) {
        this(x, y, null);
    }

    public void addChild(IComponent component) {
        //Ignore at root leaf.
    }

    public void addChildren(List<IComponent> components) {
        //Ignore at root leaf.
    }

    @Override
    public void enableSound(boolean hasFire, boolean hasCollision) {
        this.hasFireSound = hasFire;
        this.hasCollisionSound = hasCollision;
    }

    public void display(World world) {
        if (null != leafType) {
            leafType.setImage(this);
        }
        world.addObject(this, x, y);
    }
}
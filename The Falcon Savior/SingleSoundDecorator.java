import greenfoot.World;

/**
 * Write a description of class RocketDecorator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SingleSoundDecorator extends SoundDecorator {
    /**
     * Constructor for objects of class EnemyShipDecorator
     */
    SingleSoundDecorator(IComponent component) {
        super(component);
    }

    @Override
    public void enableSound(boolean hasFire, boolean hasCollision) {
        component.enableSound(hasFire, hasCollision);
    }

    public void display(World world) {
        enableSound(true, true);
        component.display(world);
    }
}
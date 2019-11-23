import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

/**
 * Write a description of class LeafType here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LeafType {
    private GreenfootImage image;
    private GreenfootSound fireSound;
    private GreenfootSound collisionSound;

    /**
     * Constructor for objects of class LeafType
     */
    LeafType(GreenfootImage image, GreenfootSound fireSound, GreenfootSound collisionSound) {
        this.image = image;
        this.fireSound = fireSound;
        this.collisionSound = collisionSound;
    }

    void setImage(Actor actor) {
        actor.setImage(this.image);
    }

    public void playFireSound() {
        if (null != fireSound) {
            fireSound.play();
        }
    }

    public void playCollisonSound() {
        if (null != collisionSound) {
            collisionSound.play();
        }
    }
}

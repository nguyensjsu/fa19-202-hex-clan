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
    private GreenfootSound sound;

    /**
     * Constructor for objects of class LeafType
     */
    LeafType(GreenfootImage image, GreenfootSound sound) {
        this.image = image;
        this.sound = sound;
    }

    void setImage(Actor actor) {
        actor.setImage(this.image);
    }

    public void playSound() {
        if (null != sound) {
            sound.play();
        }
    }
}

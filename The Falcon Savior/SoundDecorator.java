import java.util.List;

/**
 * Write a description of class SoundDecorator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class SoundDecorator implements IComponent {
    IComponent component;

    /**
     * Constructor for objects of class SoundDecorator
     */

    SoundDecorator(IComponent component) {
        this.component = component;
    }


    public void addChild(IComponent component) {
        this.component.addChild(component);
    }

    public void addChildren(List<IComponent> components) {
        this.component.addChildren(components);
    }
}

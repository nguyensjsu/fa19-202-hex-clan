import greenfoot.World;

import java.util.ArrayList;
import java.util.List;

/**
 * @author (your name)
 * @version (a version number or a date)
 */
public class Component implements IComponent {

    private ArrayList<IComponent> components = new ArrayList<>();

    Component() {
    }

    public void addChild(IComponent component) {
        components.add(component);
    }

    public void addChildren(List<IComponent> components) {
        this.components.addAll(components);
    }

    @Override
    public void enableSound(boolean hasFire, boolean hasCollision) {
        // Handle at root level
    }

    public void display(World world) {
        for (IComponent component : components) {
            component.display(world);
        }
    }

    ArrayList<IComponent> getComponents() {
        return components;
    }
}
import greenfoot.*;
import java.util.*;
/**
 *
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Component implements IComponent
{

    private ArrayList<IComponent> components = new ArrayList<>();


    public Component()
    {
    }

    public void addChild(IComponent c)
    {
        components.add(c);
    }

    public void removeChild(IComponent c)
    {
        components.remove(c);
    }

    public void display()
    {
        for(IComponent c: components)
        {
            c.display();
        }

    }
}
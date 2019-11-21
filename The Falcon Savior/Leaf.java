import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Leaf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaf extends Actor implements IComponent
{
    public int x;
    public int y;
    //private Actor actor;
    public World world;

    /**
     * Constructor for objects of class Leaf
     */
    //public Leaf(World world, Actor actor, int x, int y)
    public Leaf(World world, int x, int y)
    {
        //this.actor=actor;
        this.world=world;
        this.x=x;
        this.y=y;
        //setLocation(x,y);
    }

   
    public void addChild(IComponent c)
    {
       
    }
    
    public void removeChild(IComponent c)
    {
        
    }
    
    public void display()
    {
        
          //world.addObject(this, getX(), getY());
    }
}

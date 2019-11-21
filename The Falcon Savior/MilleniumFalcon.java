import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class millenium_falcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MilleniumFalcon extends Leaf
{
    /**
     * Act - do whatever the millenium_falcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean shooting = false;
    GreenfootImage image = new GreenfootImage("millennium_falcon.png");
    public MilleniumFalcon(World world, int x, int y)
    {
        super(world,x,y);
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            moveRight();
        }  
        
        if(Greenfoot.isKeyDown("space") && shooting == false)
        {
            shoot();
            shooting = true;
        }
        
        if(!Greenfoot.isKeyDown("space") && shooting == true)
        {
            shooting = false;
        }
        
    }    
    
    public void moveLeft()
    {
        if(getX() - 10 > 0)
        {
            this.setLocation(getX() -2, getY());
        }
        
    }
    
    public void moveRight()
    {
        if(getX() + 10 < this.getWorld().getWidth())
        {
            this.setLocation(getX() + 2, getY());
        }
        
    }
    
    public void shoot()
    {
        Rocket rocket = new Rocket(getWorld(),getX(), getY() -10);
        rocket.display();
        //this.getWorld().addObject(r, getX(), getY() -10);
//        Greenfoot.delay(5);
    }
    
    public void display()
    {
        setImage(image);
        world.addObject(this, x, y);
    }
        
}
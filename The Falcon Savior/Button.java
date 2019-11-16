import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    
    private String type;
    private World world;
    public Button(String type){
        //normal constructor for button(no world declaration)
        this.type = type;
        setPicture();
        
    }

    public Button(String type, World world)
    {
        //button constructor that lets you choose which world its in
        this(type);
        this.world = world;
    }

    public Button(String type, World world, GreenfootImage image)
    {
        this.type = type;
        this.world = world;
        setImage(image);
    }

     public void setPicture()
    {
        //sets pictures of buttons
        switch(type)
        {
           
            case "newgame": setImage(new GreenfootImage("New Game",25,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "help": setImage(new GreenfootImage("Help",25,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "credits": setImage(new GreenfootImage("Credit",25,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            
            //For Reference, no use till now
            case "teancodetext": setImage(new GreenfootImage("Made by TeaNCode, Copyright 2016", 12, Color.WHITE, new Color(0,0,0,0))); 
            setLocation(87, 25);break;
            case "world": setImage(new GreenfootImage("Continue", 60, Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
             case "teacup": setImage(new GreenfootImage("tecup.png")); setLocation(25, 15); break;
            
        }
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GamePreCheck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePreCheck extends KinectWorld
{

    /**
     * Constructor for objects of class GamePreCheck.
     * 
     */
    public GamePreCheck()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 480, 1,false); 
        GreenfootImage g = new GreenfootImage("first_screen.png");
        setBackground(g);

    }

    public void act()
    {
        super.act();
        
        if(isStartPressed())
        {
            System.out.println("Inside if GamePrecheck class");
            Greenfoot.setWorld(new GameWorld());
            repaint();
        }else{
            Greenfoot.delay(500);
            GreenfootImage g = new GreenfootImage("start_screen.png");
            setBackground(g);
            repaint();
        }
    }
    
    public boolean isStartPressed()
    {
        boolean startPressed = false;
        
        if(Greenfoot.mouseClicked(null)){
            startPressed = true;
        }
        
        return startPressed;  
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoadCenter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoadCenter extends Actor
{
    int speed = 1;

     public RoadCenter(){
      this.setRotation(90);
    }
    public void act() 
    {
         this.move(speed);
        if(this.getY() >= 449){
            this.setLocation(311 , 0);
        }

    }    
    
   
}

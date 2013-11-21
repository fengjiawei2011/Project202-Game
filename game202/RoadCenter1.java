import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoadCenter1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoadCenter1 extends RoadCenter
{
    /**
     * Act - do whatever the RoadCenter1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */        
    
   public RoadCenter1(){
     // this.setRotation(110);
      this.turn(31);
    }
    public void act() 
    {
        // Add your action code here.
        this.move(speed);
        if(this.getY() >= 449){
            this.setLocation(250 , 0);
        }
    }    
}

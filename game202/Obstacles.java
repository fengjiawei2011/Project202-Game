import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor implements ISubject
{
    private ObstacleType obstacle = null;

    IObserver gameLogic = null;
    GameLogic gl =  GameLogic.getGameLogicInstance();
    
     public void attach(IObserver ob){
       
    }
    public void detach(IObserver ob){
        gameLogic = null;
    }
    public void notifyObserver(){
       notifyGameLogic();
    }
    public Obstacles(ObstacleType obstacle) {
        this.obstacle = obstacle;
    }
    
    public ObstacleType getObstacle() {
        return obstacle;
    }

    public void setObstacle(ObstacleType obstacle) {
        this.obstacle = obstacle;
    }
    
    public void notifyGameLogic(){
         
         if(this.getY() == 360 ){
             System.out.println("IF--- Notify Obstacle class");
           gl.update(this,"obstacle");
         }
    }
    

    
    public void act() {
    }    
    
    public void moveRight(){}
    
    public void moveLeft(){}  
}

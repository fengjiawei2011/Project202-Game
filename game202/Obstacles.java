import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor
{
    private ObstacleType obstacle = null;

    public Obstacles(ObstacleType obstacle) {
		this.obstacle = obstacle;
	}
    
	public ObstacleType getObstacle() {
		return obstacle;
	}

	public void setObstacle(ObstacleType obstacle) {
		this.obstacle = obstacle;
	}
    
    public void act() {}    
    
    public void moveRight(){}
    
    public void moveLeft(){}  
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround extends Actor implements Subject
{

    int counter = 0;
    private boolean gamePaused = false;

    public BackGround(){
        Greenfoot.setWorld(new GamePreCheck());
    }
<<<<<<< HEAD
    
    int counter = 0;
    
    public void attach(Observer ob){
    
    }
    public void detach(Observer ob){
    
    }
    public void notifyObserver(){
    
    }
    public void act() 
    {
        
=======

    /**
     * Act - do whatever the BackGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
>>>>>>> 4cfb1423351c564f48a364be3245410be4e603c4
        GreenfootImage g = new GreenfootImage("roadSides2-new.png");
        this.setImage(g);
        if(!isGamePaused())
        {
            counter++;
            if(counter==200){
                counter = 0;
                this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.TREE), 300, 160);
                this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.TREE), 410, 160);

                if(((int)(Math.random()*10) % 3) == 0){
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 352, 160);
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 361, 160);
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 368, 160);  
                }else if(((int)(Math.random()*10) % 4) == 0){
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 352, 160);  
                    //  this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 355, 160);
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROADBLOCK), 362, 160);
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 367, 160);
                }else{
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 352, 160);
                    //     this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 358, 160);
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.OVERHEAD), 360, 160);
                    this.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 368, 160);
                }
            }
        }
    }  

    public boolean isGamePaused()
    {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused)
    {
        this.gamePaused = gamePaused;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround extends Actor
{
    public BackGround(){
        /*GreenfootImage g = new GreenfootImage("roadSides2-new.png");
        this.setImage(g);*/
        Greenfoot.setWorld(new GamePreCheck());
    }
    
    int counter = 0;
    /**
     * Act - do whatever the BackGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        GreenfootImage g = new GreenfootImage("roadSides2-new.png");
        this.setImage(g);
        //Rock testObj = (Rock)ObstacleFactory.buildObstacle(ObstacleType.ROCK);
        //GameWorld gema = GameWorld.getInstance();
        //System.out.println("Gema kay mhanto--->"+gema);
        //gema.addObject(testObj, 352, 160);
        //this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROCK), 352, 160);
        /*GreenfootImage g = new GreenfootImage("roadSides2.png");
        GameWorld.getInstance().setBackground(g);*/
        counter++;
        if(counter==200){
            counter = 0;
            /*this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 352, 160);
            this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 356, 160);
            this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 365, 160);
            this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 368, 160);*/
            
            this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.TREE), 300, 160);
            this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.TREE), 410, 160);
                  
            if(((int)(Math.random()*10) % 3) == 0){
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROCK), 352, 160);
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 361, 160);
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROCK), 368, 160);
                  //this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.OVERHEAD), 360, 160);   
            }else if(((int)(Math.random()*10) % 4) == 0){
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROCK), 352, 160);  
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 355, 160);
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROADBLOCK), 360, 160);
                  this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROCK), 367, 160);
                  //addObject(new Tree(), 307, 160);
                  //addObject(new Tree(), 403, 160);
            }else{
                    this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.OVERHEAD), 360, 160);
                    this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 352, 160);
                    this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.ROCK), 358, 160);
                    this.getWorld().addObject(ObstacleFactory.buildObstacle(ObstacleType.COIN), 365, 160);
            }
            Greenfoot.stop();
        }
        
        /* if(counterTree==100){
            counterTree=0;
            addObject(new Tree(), 307, 160);
            addObject(new Tree(), 403, 160);
        }*/
/*        Rock rockObj = new Rock();
        GameWorld.getInstance().addObject(rockObj, 250, 10);*/
    }   
}

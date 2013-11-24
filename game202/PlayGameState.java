import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayGameState implements IGameState
{
    int counter;
    boolean paused = false;
    
    boolean gameStoped = false;
    BackGround backGround = null;

    public PlayGameState(BackGround backGround)
    {
        this.backGround= backGround;
        backGround.setImage("play_screen.png");
        
    }

    public void playGame(BackGround backGround) 
    {
        if(!isPaused())
        {
            counter++;
            if(counter==200){
                counter = 0;
                backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.TREE), 300, 160);
                backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.TREE), 410, 160);
                //this will display the Score cloud
                backGround.getWorld().addObject(Score.getInstance(), 600, 80);
                //this will display the score
                //Label scoreCard = new Label("");
                //backGround.getWorld().addObject(scoreCard,625,50);
                //this will display the number of lives

                if(((int)(Math.random()*10) % 3) == 0){
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 352, 160);
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 361, 160);
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 368, 160);  
                }else if(((int)(Math.random()*10) % 4) == 0){
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 352, 160);  
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROADBLOCK), 362, 160);
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 367, 160);
                }else{
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 352, 160);
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.ROCK), 360, 160);
                    backGround.getWorld().addObject(ObstacleFactory.getInstance().buildObstacle(ObstacleType.COIN), 368, 160);
                }
            }
        }
        else
        {
            backGround.setGameState(new PauseGameState(backGround));
            
            System.out.println("backGround.setGameState(new PauseGameState(backGround));");
        }
        
        if ( gameStoped ){            
            
            backGround.setGameState(new StopGameState(backGround));
            
        }
    }  

    public boolean isPaused()
    {
        return paused;
    }
    
    public void setGamePaused(boolean paused)
    {
        this.paused = paused;
    }
    
        
    public void setGameStoped(boolean gameStoped)
    {
        this.gameStoped = gameStoped;
    }
    
        public void setActorCalibrated(boolean actorCalibrated)
    {
  
    }
    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PauseGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseGameState implements IGameState
{
    private boolean paused = true;
    BackGround backGround = null;

    public PauseGameState(BackGround backGround)
    {
        this.backGround = backGround;
        backGround.setImage("pause_screen.png");
    }

    /**
     * Act - do whatever the PauseGameState wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void playGame(BackGround backGround) 
    {
        if(!isPaused())
        {
            backGround.setGameState(new PlayGameState(backGround));
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
    
          public void setActorCalibrated(boolean actorCalibrated)
    {
  
    }
  
        public void setGameStoped(boolean gameStoped)
    {
    }
}

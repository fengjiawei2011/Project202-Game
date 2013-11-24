import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameState implements IGameState
{
    private BackGround backGround = null;
    private boolean gamePaused = true;
    private boolean actorCalibrated = false;

    public StartGameState(BackGround backGround)
    {
        this.backGround = backGround;
        backGround.setImage("instructions.png");
    }

    /**
     * Act - do whatever the StartGameState wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void playGame(BackGround backGround) 
    {
        if(!isGamePaused())
        {
            backGround.setImage("roadSides2-new.png");
            if(isActorCalibrated())
            {
                backGround.setGameState(new PlayGameState(backGround));
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

    public boolean isActorCalibrated()
    {
        return actorCalibrated;
    }

    public void setActorCalibrated(boolean actorCalibrated)
    {
        this.actorCalibrated = actorCalibrated;
    }
    
     public void setGameStoped(boolean gameStoped)
    {
    }
}
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround extends Actor
{
    private boolean gamePaused = false;
    private boolean gameStoped = false;
        
    private boolean actorCalibrated = false;
    private IGameState currentGameState = null;
    public static BackGround backGround = null;

    public static BackGround getInstance()
    {
        if(backGround == null)
        {
            backGround = new BackGround();
        }
        return backGround;
    }

    public BackGround(){
       
    }

    /**
     * Act - do whatever the BackGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ( currentGameState == null ){
            
            currentGameState = new StartGameState(this);
            setGameState(currentGameState);

            if(((isGamePaused()) && ((currentGameState.getClass().getName()).contains("StartGameState"))))
            { 
                currentGameState.setGamePaused(true);
            }

            currentGameState.playGame(this);

        }
        else { 
            currentGameState.playGame(this);
        }
    } 

    public IGameState getGameState()
    {
        return currentGameState;
    }

    
    public void setGameState(IGameState currentGameState)
    {
        this.currentGameState = currentGameState;
    }

    public boolean isGamePaused()
    {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused)
    {
        
        this.gamePaused = gamePaused;
        this.currentGameState.setGamePaused(gamePaused);
    }
    public boolean isGameStoped()
    {
        return gameStoped;
    }

    public void setGameStoped(boolean gameStoped)
    {
        
        this.gameStoped = gameStoped;
        this.currentGameState.setGameStoped(gameStoped);
    }

    public void setActorCalibrated(boolean actorCalibrated)
    {
        this.actorCalibrated = actorCalibrated;
        this.currentGameState.setActorCalibrated( actorCalibrated );

    }
}
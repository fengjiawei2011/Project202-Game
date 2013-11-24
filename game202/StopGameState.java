import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StopGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StopGameState implements IGameState
{
    BackGround backGround = null;

    public StopGameState(BackGround backGround)
    {
        this.backGround = backGround;
        backGround.setImage("score_screen.png");
    }

    public void playGame(BackGround backGround) 
    {
    }    

    public void setGamePaused(boolean gamepaused ){}

    public void setActorCalibrated(boolean actorCalibrated)
    {

    }
        public void setGameStoped(boolean gameStoped)
    {
    }

}

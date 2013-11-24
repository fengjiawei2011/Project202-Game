/**
 * Write a description of class IBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IGameState
{
  public void playGame(BackGround backGround);
 
  public void setGamePaused ( boolean gamepaused );
  
    public void setGameStoped ( boolean gameStoped );

    public void setActorCalibrated(boolean actorCalibrated);
}

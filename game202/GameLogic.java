import greenfoot.*;

/**
 * Write a description of class GameLogics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameLogic implements IObserver,ISubject
{
    // instance variables - replace the example below with your own
    private int score = 0;

    private Label scoreL;

    private Character player = null;

    private BackGround backGround = null;

    private IGameState iGameState = null;

    static GameLogic gl = null;
    
    private int numOfLives = 5;
    
    
    
    //-----------------------------------
    
    private Score scoreBoard = Score.getInstance();
    private Obstacles obstacle;
    
    //-----------------------------------

    public void setCharacter(  Character p ){
        player = p;
    }

    public Character getCharacter()
    {
        return player;
    }

    public BackGround getBackGround()
    {
        return backGround;
    }

    /**
     * Constructor for objects of class GameLogics
     */

    public GameLogic( ){

        player = new Character( this );
        backGround = new BackGround();
        setBackGround(backGround);

        gl = this;
        //backGround.setGameState(new StartGameState(backGround));
    }

    public void setBackGround(BackGround backGround)
    {
        this.backGround = backGround;
    }

    public int CheckObstracle(int type, int lane)
    {
        return 0;
    }

    public int getScore(){
        return score;
    }

    public void setGamePaused(boolean pauseGame)
    {
        backGround.setGamePaused(pauseGame);
    }

    public void setActorCalibrated(boolean actorCalibrated)
    {
        backGround.setActorCalibrated(actorCalibrated);
    }

    public static GameLogic getGameLogicInstance(){
        return gl;
    }

//    ------------------------------------------------------------------------------

    public void attach(IObserver score){
    
    }
    
    public void detach(IObserver score){
        scoreBoard = null;
    }
    
    
    
    public void subscribe(Character subject){
        player = subject;
        subject.attach(this);
    }
    

    public  boolean isOverlap(Obstacles  ob, Character character ){
        
        
        
        int characterX_R = character.getX()+character.getImage().getWidth()/2;
        int characterX_L = character.getX()-character.getImage().getWidth()/2;
        int obstacleX_R = ob.getX()+ ob.getImage().getWidth()/2;
        int obstacleX_L = ob.getX()- ob.getImage().getWidth()/2;
        boolean flag = false;
        
        
        
        if(character.getX()< ob.getX()){
            if(characterX_R > obstacleX_L && characterX_L < obstacleX_R ){
                flag = true;           
            }else{
                flag = false;
            }
        }else{
            if(characterX_L < obstacleX_R && characterX_R > obstacleX_L){
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }
    
    public void calculateScore(){
       // System.out.println("Inside Calculate Score");
        
        if(isOverlap(obstacle , player)){
                        
             if(obstacle.getObstacle().toString().contains("COIN") ){

                 score++;
                 setScore(score);
             }
             
             if(obstacle.getObstacle().toString().contains("ROCK") || obstacle.toString().contains("ROADBLOCK") ){
                                
                 if( player.getCurrentState_Int() == 1) {  //1 == jump
                
                    score++;
                    setScore(score);
                    
                }else{
                    
                    score--;
                    numOfLives--;
                    setScore(score);
                    
                }
                
             }            
                          
        }
       
        scoreBoard.update();
        
        if ( numOfLives <= 0 ){
            
            backGround.setGameStoped(true);
            player.stop();
            
        }
        
        
    }
    
        public void update(ISubject subject, String who){
          //System.out.println("I am in the update");
         if(who.equalsIgnoreCase("obstacle")){
            // System.out.println("I am in the oo");

           this.obstacle = (Obstacles)subject;
           calculateScore();
        }else if(who.equalsIgnoreCase("character")){
            //System.out.println("I am in the chochco");
           this.player = (Character)subject;
        }
    }
    
    
    // notify score
    public void notifyObserver(){
        scoreBoard.update();
    }
     public void setScore(int score ){
        this.score = score;
        notifyObserver();
    }
    
    public void clearScore(){
        score = 0;
    }
    
    public int getNumOfLives(){
        return numOfLives;
    }
    
    public void setNumOfLives(int numOfLives){
        this.numOfLives = numOfLives;
    }
    
}

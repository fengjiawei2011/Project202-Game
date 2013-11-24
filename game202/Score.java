import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor implements IObserver
{
    private static Score scoreObj = null;
    
    Label scoreCard = null;
    Label lives = null;
    GameLogic gameLogic =null;
    
    int maxScore = 0;
    
    public Score(){
       
        this.getImage().scale(275,140);
        scoreObj = this;
        
        maxScore = 0;
       
    }
    
    public static Score getInstance(){
        if(scoreObj==null){
            scoreObj = new Score();
        }
        return scoreObj;
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        displayScore();
    }
   
    public void update(ISubject s, String string){
       
    }
    
    public void update(){
        
    }
    
    public void remove(){
        scoreCard.setText( "" );
        lives.setText( "" );
        getImage().scale( 1,1 );
        
        Label maxScoreL = new Label(" Max Score : " + maxScore );
        this.getWorld().addObject( maxScoreL , 300, 450 );
        
        
    }
    
    public void displayScore(){
                
       if ( gameLogic == null ){
           
            gameLogic = GameLogic.getGameLogicInstance();
            
            scoreCard = new Label(""+gameLogic.getScore());
            this.getWorld().addObject( scoreCard, 625, 50 );
        
            lives = new Label(""+gameLogic.getNumOfLives());
            this.getWorld().addObject( lives, 625, 90 );

        }else{
            
            int score = gameLogic.getScore();
            
            scoreCard.setText( ""+ score );
            lives.setText( ""+gameLogic.getNumOfLives() );
            
            maxScore = score > maxScore ? score : maxScore;
            
            if ( 0 >= gameLogic.getNumOfLives() ){
                remove();    
            }
            
        }
        
        
    }
}

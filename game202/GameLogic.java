import greenfoot.*;

/**
 * Write a description of class GameLogics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameLogic implements Observer
{
    // instance variables - replace the example below with your own
    private int score = 0;
    
    private Label scoreL;
    
    private Character player;
    
    public void setCharacter(  Character p ){
        player = p;
    }

    /**
     * Constructor for objects of class GameLogics
     */
    
    public GameLogic( Character p ){
        player = p;
    }
    
    public void update(){
    
    }

    public void clearScore(){
        score = 0;
    }
    
    public Label getInstance()
    {
        if(scoreL == null)
        {
           scoreL = new Label("" , 20 ); 
        }
        
        return scoreL;
    }
    
    public void setScore( World w ){
        //scoreL = new Label( " Score  " , 20 );
        
        w.addObject( getInstance() , 550 , 70 );
    }
    
    
    public int CheckObstracle(int type, int lane)
    {
        
        
         // lane 1  2 // // 1 = normal 2 = jump 3 = squat
         
         // type always stone so jump
         
        // System.out.println(" " + player.getLane() + " " + player.getState() );
         /*
         if ( lane == player.getLane() ){
             if ( player.getState() != 2 ) {
                 
                 score = 0;
            
                 //scoreL.setText("" + score );
         
                 return -1;
             }
             score = score + 20;
         }
         
         score = score + 5;
         
         scoreL.setText("" + score );
         
         */
         return 0;
    }
}

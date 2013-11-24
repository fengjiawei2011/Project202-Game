import greenfoot.*;
import java.awt.Color;
import java.util.*;

public class Character extends Actor implements ISubject
{
    Label instr;

    static int charX = 311;
    static int charY = 360;

    static int charJumpY = 250;
    static int charSquatY = 390;

    static int charLane1X = 200;
    static int charLane2X = 400;

    static int jumpCounterValue = 150;
    static int squatCounterValue = 5;

    int state = -1; // 0 = get the left 1 = get right 2 = get jump 3 = get squat down    

    int left = charX;
    int right = charX;
    int jump = charY;
    int squat = charY;

    int mid =0;

    int jumpCounter = 0;
    int squatCounter = 0;

    ICharacterState currentState = null;
    GameLogic gl = null ;
    
    //ArrayList<IObserver> observers = new ArrayList<IObserver>();
  
    
    public int getCurrentState_Int(){
        
        if ( currentState.getClass().getName().contains( "Jump" ) )
            return 1;
        else
            return 0;
    }

     public void attach(IObserver ob){
        //observers.add(ob);
     }

    public void detach(IObserver ob){
        //observers.remove(ob);
    }

    public void notifyObserver(){
        
            gl.update(this , "character");
    }

    public GameLogic getGameLogic(){
        return gl;
    }

    public void setState( ICharacterState newState ){
        currentState = newState;
        notifyObserver();
    }
    public void setLocation( int x, int y){
        super.setLocation(x,y);
    }

    public int getLane(){
        return getX() < charLane2X ? 1 : 2;
    }

    public int getState(){ // 1 = normal 2 = jump 3 = squat
        return jumpCounter > 0 ? 2 : 1;
    }

    public Character( GameLogic glc ) {        

        gl = glc;
        setImage("stand_edit.png");
        setLocation( 250, 250 ) ;
        getImage().scale( 1,1  );

    }
    
    public void stop(){
        
        currentState = new CharacterStateDead(this);
        
    }

    public void setChar(){
        instr = new Label( "   " , 50 );
        getWorld().addObject( instr , 300 , 100 );
        setLocation(charX, charY);
    }

    public void reset(){
        state = -1;
    }

    public void act() 
    {

        if ( currentState == null ){

            setChar();

            setState( new CharacterStateStop( this ) );

        }else {            
            currentState.gameRun( this );
            notifyObserver();
        }
        GameWorld world = (GameWorld)getWorld();
        UserData[] users = world.getTrackedUsers();  
        boolean flag = true;
        for (UserData user : users) {
            flag = false;

            if (user.getJoint( Joint.LEFT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {

                if (user.getJoint( Joint.RIGHT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {

                    if (user.getJoint( Joint.RIGHT_HAND).getX( ) < user.getJoint( Joint.LEFT_HAND).getX( ) ) {
                        setState( new CharacterStatePause( this ) ) ;
                    }
                }
            }                           
        }  

        if ( flag ){

            setState( new CharacterStateStop ( this ) );

        }
        
        

    }

}

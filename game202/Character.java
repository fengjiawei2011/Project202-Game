import greenfoot.*;
import java.awt.Color;

public class Character extends Actor
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
    

    
    public void setState( ICharacterState newState ){
        
        currentState = newState;
        
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
    
    public Character(int width, int height) {
        
        
        setImage("stand_edit.png");
        setLocation( 250, 250 ) ;
        getImage().scale( 70, 100  );
                       
    }
    
    public void setChar(){
        instr = new Label( "   " , 50 );
        getWorld().addObject( instr , 300 , 100 );
        setLocation(charX, charY);
    }
    
    public void reset(){
        state = -1;
    }

    public void stateLeft() {
        
        instr.setText(" Move left and Lift left hand to set threshhold of left ");
        
        GameWorld world = (GameWorld)getWorld();

        UserData[] users = world.getTrackedUsers();
        
        
        for (UserData user : users) {
            
               Joint torso = user.getJoint(Joint.TORSO);
               int a = torso.getX();
               setLocation( a , charY );
               
               left = left < a ? left : a;
                   
                if (user.getJoint( Joint.LEFT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                    
                     if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        setLocation(charX, charY);
                        state = 1;
                    }                        
                }
                
                int b = torso.getY();
                mid = mid > b ? mid : b;
                
        }
    
    }
    
    public void stateRight() {
            
            instr.setText(" Move right and Lift right hand to set threshhold of right ");
            
            
            GameWorld world = (GameWorld)getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                
                   Joint torso = user.getJoint(Joint.TORSO);
                   
                   int a = torso.getX();
                   
                   setLocation( a , charY );
                   
                   right = right > a ? right : a ;
                       
                    if (user.getJoint( Joint.RIGHT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                        
                         if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                            setLocation(charX, charY);
                            state = 2;
                        }
                    }
                    
                     int b = torso.getY();
                     
                     mid = mid > b ? mid : b;
                     
            }        
    }
    
    
    public void stateJump() {
            
            instr.setText(" raise both hands once you reach good jump to set jump ( highest will be set as threashhold ) ");
            
            GameWorld world = (GameWorld)getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                   Joint torso = user.getJoint(Joint.TORSO);
                   int b = torso.getY();
                   setLocation( charX , b );                   
                       
                  if (  b < mid - 3 ) {                        
                      jump = jump < b ? jump : b;
                   }
                   
                   if (user.getJoint( Joint.RIGHT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                        
                       if (user.getJoint( Joint.LEFT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                           setLocation(charX, charY);
                           state = 3;
                        }
                    }                    
            }        
            
    }
    
     public void stateSquat() {
            
            instr.setText(" squat and get hands down to set squat ( lowest will be set as threashhold ) ");
            
            GameWorld world = (GameWorld)getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                   Joint torso = user.getJoint(Joint.TORSO);
                   int b = torso.getY();
                   setLocation( charX , b );                   
                       
                  if (  b > mid + 3 ) {                        
                      squat = squat > b ? squat : b;
                   }
                   
                   if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        
                       if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                           instr.setText(" ");
                           state = 4;
                           setLocation( charLane1X , charY );
                           setState( new CharacterStateNormal( this ) ) ;
                        }
                        
                    } 
            }
    }
    
     public void stateStart() {
            
            //instr.setText(" put your hands down to start ");
            
            GameWorld world = (GameWorld)getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                   if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        
                       if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                           state = 0;
                        }
                    }
            }        
        
    }
    
    public void stateRun(){
        
         GameWorld world = (GameWorld)getWorld();
    
         UserData[] users = world.getTrackedUsers();
            
         for (UserData user : users) {
                   if (user.getJoint( Joint.RIGHT_HAND).getX( ) < user.getJoint( Joint.LEFT_HAND).getX( ) ) {
                       state = -1;
                    }
         }      
            
    }
    
    
       

    
    public void act() 
    {
        
        if ( currentState == null ){
            
            setChar();
                       
            setState( new CharacterStateConfigure( this ) );
            
            
        }else {            

            currentState.gameRun( this );
            
        }
        
       GameWorld world = (GameWorld)getWorld();

       UserData[] users = world.getTrackedUsers();  
       
       boolean flag = true;
       
       for (UserData user : users) {
           flag = false;
        }
       
       
       if ( flag ){
          
             System.out.println ( " character lost " );
             setState( new CharacterStateConfigure( this ) );
            
       }
            
    }

}

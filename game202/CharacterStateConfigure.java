/**
 * Write a description of class CharacterStateConfigure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterStateConfigure implements ICharacterState {
    
    
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
    
    Character ch = null;
    
    public CharacterStateConfigure ( Character chr )  {
        
        left  = chr.left;
        right = chr.right;
        jump  = chr.jump;
        squat = chr.squat;
        
        instr = chr.instr;
        ch = chr;
        
        chr.setImage("stand_edit.png");
        chr.getImage().scale( 70,100 );
        chr.setLocation( chr.getX() , charY ); 
        
        ch.getGameLogic().setGamePaused(false);
        
    }
    
    
    
    public void reset(){
        state = -1;
    }

    public void stateLeft() {
        
        instr.setText(" Move left and Lift left hand to set threshhold of left ");
        
        GameWorld world = (GameWorld)ch.getWorld();

        UserData[] users = world.getTrackedUsers();
        
        
        for (UserData user : users) {
            
               Joint torso = user.getJoint(Joint.TORSO);
               int a = torso.getX();
               ch.setLocation( a , charY );
               
               left = left < a ? left : a;
                   
                if (user.getJoint( Joint.LEFT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                    
                     if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        ch.setLocation(charX, charY);
                        state = 1;
                    }                        
                }
                
                int b = torso.getY();
                mid = mid > b ? mid : b;
                
        }
    
    }
    
    public void stateRight() {
            
            instr.setText(" Move right and Lift right hand to set threshhold of right ");
            
            
            GameWorld world = (GameWorld)ch.getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                
                   Joint torso = user.getJoint(Joint.TORSO);
                   
                   int a = torso.getX();
                   
                   ch.setLocation( a , charY );
                   
                   right = right > a ? right : a ;
                       
                    if (user.getJoint( Joint.RIGHT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                         if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                            ch.setLocation(charX, charY);
                            state = 2;
                        }
                    }
                    
                     int b = torso.getY();
                     
                     mid = mid > b ? mid : b;
                     
            }        
    }
    
    
    public void stateJump() {
            
            instr.setText(" raise both hands once you reach good jump to set jump ( highest will be set as threashhold ) ");
            
            GameWorld world = (GameWorld)ch.getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                   Joint torso = user.getJoint(Joint.TORSO);
                   int b = torso.getY();
                   ch.setLocation( charX , b );                   
                       
                  if (  b < mid - 3 ) {                        
                      jump = jump < b ? jump : b;
                   }
                   
                   if (user.getJoint( Joint.RIGHT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                        
                       if (user.getJoint( Joint.LEFT_HAND).getY( ) < user.getJoint(Joint.HEAD).getY ( ) ) {
                           ch.setLocation(charX, charY);
                           state = 3;
                        }
                    }                    
            }        
            
    }
    
     public void stateSquat() {
            
            instr.setText(" squat and get hands down to set squat ( lowest will be set as threashhold ) ");
            
            GameWorld world = (GameWorld)ch.getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                   Joint torso = user.getJoint(Joint.TORSO);
                   int b = torso.getY();
                   ch.setLocation( charX , b );                   
                       
                  if (  b > mid + 3 ) {                        
                      squat = squat > b ? squat : b;
                   }
                   
                   if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        
                       if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                           instr.setText(" ");
                           state = 4;
                           ch.setLocation( charLane1X , charY );
                           
                            ch.left  = left;
                            ch.right = right;
                            ch.jump  = jump;
                            ch.squat = squat;
                           
                           ch.getGameLogic().setActorCalibrated(true);
                           ch.setState( new CharacterStateNormal( ch ) ) ;
                        }
                        
                    } 
            }
    }
    
     public void stateStart() {
            
            //instr.setText(" put your hands down to start ");
            
            GameWorld world = (GameWorld)ch.getWorld();
    
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
         GameWorld world = (GameWorld)ch.getWorld();
    
            UserData[] users = world.getTrackedUsers();
            
            
            for (UserData user : users) {
                   if (user.getJoint( Joint.RIGHT_HAND).getX( ) < user.getJoint( Joint.LEFT_HAND).getX( ) ) {
                       state = -1;
                    }
            }      
            
    }
    

    public void gameRun( Character chr )  {
        
        switch ( state ){
                
                case -1:// get hands down
                    stateRun();
                    stateStart();
                    break;                
                case 0: // get left
                    stateRun();
                    stateLeft();
                    break;
                case 1:// get right
                    stateRun();
                    stateRight();
                    break;
                case 2:// get jump 
                    stateRun();
                    stateJump();
                    break;
                case 3:// get squat
                    stateRun();
                    stateSquat();
                    break;    
                case 4:
                    break;
            }
    }
}

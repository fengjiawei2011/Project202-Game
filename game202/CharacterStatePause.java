

public class CharacterStatePause implements ICharacterState {
    
    static int charX = 311;
    static int charY = 360;
    
    static int charJumpY = 250;
    static int charSquatY = 390;
    
    static int charLane1X = 200;
    static int charLane2X = 400;
    

    int left = charX;
    int right = charX;
    int jump = charY;
    int squat = charY;
    
    int mid =0;
    
    
    
    public CharacterStatePause( Character chr ){
        
        
       left  = chr.left;
       right = chr.right;
       jump  = chr.jump;
       squat = chr.squat;
                           
     
       chr.setImage("stand_edit.png");
       chr.getImage().scale( 70 , 100 );
       
       chr.getGameLogic().setGamePaused(true);
       
    
    }
    
    
   public void gameRun(  Character chr ){
                   
       GameWorld world = (GameWorld)chr.getWorld();

       UserData[] users = world.getTrackedUsers();   
       
       for (UserData user : users) {
                  
           if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        
               if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                           
                   if (user.getJoint( Joint.RIGHT_HAND).getX( ) < user.getJoint( Joint.LEFT_HAND).getX( ) ) {
                           chr.setState( new CharacterStateNormal( chr ) ) ;
                                  chr.getGameLogic().setGamePaused(false);
                    }
                }
            }                           
        }        
    }    
}



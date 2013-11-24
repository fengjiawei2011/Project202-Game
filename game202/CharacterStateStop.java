

public class CharacterStateStop implements ICharacterState {
    
    static int charX = 311;
    static int charY = 360;
    
    static int charJumpY = 250;
    static int charSquatY = 390;
    
    static int charLane1X = 200;
    static int charLane2X = 400;
    
    static int jumpCounterValue = 150;
    
    
    
    boolean up;    

    int left = charX;
    int right = charX;
    int jump = charY;
    int squat = charY;
    
    int mid =0;
    
    
    
    public CharacterStateStop( Character chr ){
                
       left  = chr.left;
       right = chr.right;
       jump  = chr.jump;
       squat = chr.squat;
                           
       chr.setImage("jump_edit.png");
       chr.getImage().scale( 1,1 );
      
    
    }
    
    
   public void gameRun(  Character chr ){
                   
       GameWorld world = (GameWorld)chr.getWorld();

       UserData[] users = world.getTrackedUsers();   
       
       for (UserData user : users) {
                  
           if (user.getJoint( Joint.LEFT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                        
               if (user.getJoint( Joint.RIGHT_HAND).getY( ) > user.getJoint(Joint.HEAD).getY ( ) ) {
                           
                   if (user.getJoint( Joint.RIGHT_HAND).getX( ) < user.getJoint( Joint.LEFT_HAND).getX( ) ) {
                           chr.setState( new CharacterStateConfigure( chr ) ) ;
                    }
                }
            }                           
        }        
    }    
}

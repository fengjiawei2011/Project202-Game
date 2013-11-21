

public class CharacterStatePause implements ICharacterState {
    
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
    
    
    int jumpCounter = 0;
    
    public CharacterStatePause( Character chr ){
        
        
       left  = chr.left;
       right = chr.right;
       jump  = chr.jump;
       squat = chr.squat;
                           
       jumpCounter = 0;
       chr.setImage("jump_edit.png");
       chr.getImage().scale( 100, 170);
       jumpCounter = jumpCounterValue;
       up = true;
    
    }
    
    
   public void gameRun(  Character chr ){
       
             
       GameWorld world = (GameWorld)chr.getWorld();

       UserData[] users = world.getTrackedUsers();   
       
       for (UserData user : users) {
                  
           Joint torso = user.getJoint(Joint.TORSO);
           
           
           Joint l = user.getJoint( Joint.LEFT_HAND ) ;
           Joint r = user.getJoint( Joint.RIGHT_HAND ) ;
           Joint ls = user.getJoint( Joint.LEFT_SHOULDER ) ;
           Joint rs = user.getJoint( Joint.RIGHT_SHOULDER );
           
           
           
          
           
           
           
           int a = torso.getX();
           
           int b = torso.getY();
                           
        }
        
    }   
    
}


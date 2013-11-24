

public class CharacterStateNormal implements ICharacterState {
    
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
    

    public CharacterStateNormal( Character chr )  {
        
        left  = chr.left;
        right = chr.right;
        jump  = chr.jump;
        squat = chr.squat;
                                
        chr.setImage("stand_edit.png");
        chr.getImage().scale( 70,100 );
        chr.setLocation( chr.getX() , charY ); 
        
    }
    
    public void gameRun( Character chr )  {
                     
       GameWorld world = (GameWorld)chr.getWorld();

       UserData[] users = world.getTrackedUsers();   
       
       for (UserData user : users) {
                  
           Joint torso = user.getJoint(Joint.TORSO);
           
           int a = torso.getX();
           
           int b = torso.getY();
           
           // turn character body and head 
           
           chr.setLocation( a , chr.getY() );
            
          
           /*
           if ( a > right ){
               
               chr.setLocation( charLane2X , chr.getY() );
               
           }else if ( a < left ) {
               
               chr.setLocation( charLane1X , chr.getY() );    
               
           }  */         
                       
           if ( b < jump ){                       
           
               chr.setState( new CharacterStateJump( chr ) ) ;
           
            }
            
        }
        
    }        
    
}



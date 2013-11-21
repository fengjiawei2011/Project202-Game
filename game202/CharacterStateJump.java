

public class CharacterStateJump implements ICharacterState {
    
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
    
    public CharacterStateJump( Character chr ){
        
        
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
       
        if ( up ) {
        
           if ( chr.getY() > charJumpY ){
                chr.setLocation( chr.getX() , chr.getY() - 1 ); 
            }else{
                up = false;
            }
            
        }else{
            
            if ( chr.getY() < charY ){
                chr.setLocation( chr.getX() , chr.getY() + 1 ); 
            }else{
                up = true;
                chr.setState( new CharacterStateNormal( chr ) );
            } 
            
        }
        
    }   
    
}

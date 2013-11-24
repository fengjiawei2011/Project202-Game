

public class CharacterStateDead implements ICharacterState {
    
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
    
    
    
    public CharacterStateDead( Character chr ){
                
       left  = chr.left;
       right = chr.right;
       jump  = chr.jump;
       squat = chr.squat;
                           
       chr.setImage("jump_edit.png");
       chr.getImage().scale( 1,1 );
      
    
    }
    
    
   public void gameRun(  Character chr ){
    }
   
}

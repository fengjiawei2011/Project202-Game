import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoadBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoadBlock extends Obstacles
{
    private int distance = 0;
    private int lane;
    
    public RoadBlock(){
        super(ObstacleType.ROADBLOCK);
        this.getImage().scale(65, 25);
    }
    
    /**
     * Act - do whatever the RoadBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkLane();
        
        if(this.getX()>360){
            moveRight();
        }
        else{
            moveLeft();
        }
        
        enlargeImage();
        
        if(this.getY() == 440){
                this.getImage().clear();
        }
        
        // Add your action code here.
     
         if(this.getY() == 360 ){ // 449
           // (this.getWorld()).removeObject(this);
            ((GameWorld)getWorld()).getGameLogic().CheckObstracle( 1, 1) ; // 1 == rock 1 == lane
            //this.setLocation( copyX ,  copyY );
        
        }
    }
    
     public void moveRight(){
        if(distance % 5 == 0 && getLane()==4){
            this.setLocation(this.getX()+4 , this.getY()+1);
        }else{
            this.setLocation(this.getX(), this.getY()+1);
        }
    }
    
     public void moveLeft(){
        if(distance % 5 == 0 && getLane()==1){
            this.setLocation(this.getX()-4 , this.getY()+1);
        }else{
            this.setLocation(this.getX(), this.getY()+1);
        }
    }
    
    public void checkLane(){
        if(this.getX()>=350 && this.getX()<=355){
            setLane(1);
        }else if(this.getX()>=356 && this.getX()<=360){
            setLane(2);
        }else if(this.getX()>=361 && this.getX()<=365){
            setLane(3);
        }else if(this.getX()>=366 && this.getX()<=370){
            setLane(4);
        }
    }
    
    public void enlargeImage(){
        if(distance % 17  == 0){
            GreenfootImage g = new GreenfootImage("roadblock.png");
            if(distance < 300){
                 if((this.getY()>180) && (this.getY()<= 250)){
                     g.scale(70,30);
                     this.setImage(g);
                 }else if(this.getY()>250  && (this.getY()<= 300)){
                     g.scale(100,40);
                     this.setImage(g);
                 }else if(this.getY()>300  && (this.getY()<= 360)){
                     g.scale(140,60);
                     this.setImage(g);
                 }
            }
        }
    }
    
    public void setLane(int lane){
        this.lane = lane;
    }
    
    public int getLane(){
        return this.lane;
    }
    
    /*public void moveRight(){
        distance ++ ;
        if(distance % 5 == 0 && this.getX()!=300){
            this.setLocation(this.getX()+1 , this.getY()+1);
        }else{
            this.setLocation(this.getX() , this.getY()+1);
        }
        
        if(distance % 17  == 0){
            if(distance < 150){
                 this.getImage().scale(this.getImage().getWidth() + 1,this.getImage().getHeight() + 1 );
            }
           
        }
    }
    
    public void moveLeft(){
        distance ++ ;
        if(distance % 5 == 0 && this.getX()!=300){
            this.setLocation(this.getX()-1 , this.getY()+1);
        }else{
            this.setLocation(this.getX() , this.getY()+1);
        }
        
        if(distance % 17  == 0){
            if(distance < 250){
                 this.getImage().scale(this.getImage().getWidth() + 1,this.getImage().getHeight() + 1 );
            }
           
        }
    }*/
}

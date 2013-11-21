import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Obstacles
{
    private int lane;
    private int distance = 0;
    private int testDistance = 0;
    
    public Coin(){
         super(ObstacleType.COIN);
         this.getImage().scale(15, 15);
    }
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        distance++;
        checkLane();
        
        if(this.getX()>360){
            moveRight();
        }else{
            moveLeft();
        }
        
        enlargeImage();
        
        if(this.getY() == 449){
            this.getImage().clear();
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
            GreenfootImage g = new GreenfootImage("Coin-001.png");
            if(distance < 300){
                 if((this.getY()>180) && (this.getY()<= 250)){
                     g.scale(20,20);
                     this.setImage(g);
                 }else if(this.getY()>250  && (this.getY()<= 300)){
                     g.scale(25,25);
                     this.setImage(g);
                 }else if(this.getY()>300  && (this.getY()<= 360)){
                     g.scale(30,30);
                     this.setImage(g);
                 }
            }
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
    
    public void setLane(int lane){
        this.lane = lane;
    }
    
    public int getLane(){
        return this.lane;
    }
}

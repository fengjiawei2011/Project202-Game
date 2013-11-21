import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Obstacles
{
    int distance = 0;
    int distance1 = 0;
    int testDist = 0;
    
    public Tree(){
        super(ObstacleType.TREE);
        this.getImage().scale(45, 60);
        this.setRotation(3);
    }

    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //this.move(1);
        distance ++ ;
        distance1 ++;
        testDist++;
        /*if(this.getX()>300){
        if(distance == 8){
        this.setLocation(this.getX()+1 , this.getY()+1);
        distance=0;
        }else{
        this.setLocation(this.getX()-1 , this.getY()+1);
        }
        }else if(this.getX()<300){
        if(distance == 8){
        this.setLocation(this.getX()-1 , this.getY()+1);
        distance=0;
        }else{
        this.setLocation(this.getX()+1 , this.getY()+1);
        }
        }*/
        /*if(testDist==20 && (this.getY() < 350)){
            testDist=0;
            this.getImage().scale(this.getImage().getWidth()+1,this.getImage().getHeight() + 1);
        }*/
        if(this.getX()>360){
            moveRight();
        }else{
            moveLeft();
        }
        
        enlargeImage();
        
        if(distance1 == 25 && this.getY()<250){
            // this.getImage().scale(this.getImage().getWidth()+1,this.getImage().getHeight() + 1 );
            distance1 = 0;
        }

        if(this.getY() == 375){
             this.getImage().clear();
        }
    }    
    
    public void enlargeImage(){
        if(distance % 17  == 0){
            GreenfootImage g = new GreenfootImage("pine_tree.png");
            if(distance < 300){
                 if((this.getY()>180) && (this.getY()<= 250)){
                     g.scale(50,85);
                     this.setImage(g);
                 }else if(this.getY()>250  && (this.getY()<= 300)){
                     g.scale(55,110);
                     this.setImage(g);
                 }else if(this.getY()>300  && (this.getY()<= 360)){
                     g.scale(60,135);
                     this.setImage(g);
                 }
            }
        }
    }

    public void moveRight(){
        distance ++ ;
        if(distance % 5 == 0 && this.getX()!=360){
            this.setLocation(this.getX()+7 , this.getY()+1);
        }else{
            this.setLocation(this.getX() , this.getY()+1);
        }
    }

    public void moveLeft(){
        distance ++ ;
        if(distance % 5 == 0 && this.getX()!=360){
            this.setLocation(this.getX()-7 , this.getY()+1);
        }else{
            this.setLocation(this.getX() , this.getY()+1);
        }
    }
}

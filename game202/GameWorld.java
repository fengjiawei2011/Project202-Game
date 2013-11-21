import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaintingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends KinectWorld
{
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 40;
    private long leftHandUp;
    private Label leftHandWarning;    
    private Character paulCharacter;    
    private Instructions instr;   
    private Thumbnail thmb;    
    private GameLogic game;
    private static GameWorld gameWorld = null;

    Rock rock = new Rock();
    Tree treeObj = new Tree();
    private int counter = 0;
    private int counterTree = 0;
    private int counterTest = 0;
    
    public static GameWorld getInstance()
    {
        if(gameWorld==null){
            gameWorld = new GameWorld();  
        }
        return gameWorld;
    }

    public GameLogic getGameLogic(){
        return game;
    }

    public Character getCharacter(){
        return  paulCharacter;
    }

    public GameWorld()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
        prepare();
        
        GreenfootImage g = new GreenfootImage("roadSides2-new.png");
        this.setBackground(g);

        final int width = getWidth();
        final int height = getHeight();

        paulCharacter = new Character(width, height-100);
        instr = new Instructions();
        thmb = new Thumbnail();
        game = new GameLogic(paulCharacter);

        addObject(new BackGround(), 360,240);
        addObject( paulCharacter , width/2, height);
        addObject( instr , width/2, height/2);
        addObject( thmb , width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        /*GreenfootImage g = new GreenfootImage("roadSides2.png");
        
        this.setBackground(g);*/
        
        /*
        Label instr = new Label("Use your right hand to paint, raise left hand to clear.", 20);
        addObject(instr, instr.getImage().getWidth() / 2, getBackground().getHeight() - (instr.getImage().getHeight() / 2));*/
    }

    public void started(){
        super.started();
        paulCharacter.setChar();
        game.setScore(this);
        System.out.println ( " setting character " );
    }

    public void act()
    {  
        super.act();
       
/*
        counter++;
        counterTree++;

        if(counter==200){
            counter = 0;
            if(((int)(Math.random()*10) % 3) == 0)
            {
                addObject(new Rock(), 352, 160);
                addObject(new Coin(), 360, 160);
                addObject(new Rock(), 368, 160);
            }else if(((int)(Math.random()*10) % 4) == 0){
                addObject(new Rock(), 352, 160);  
                addObject(new Coin(),355,160);
                addObject(new RoadBlock(),360,160);
                addObject(new Rock(), 367, 160);}
            else{
                addObject(new Coin(),352,160);
                addObject(new Rock(),358,160);
                addObject(new Coin(),365,160);}
        }

        if(counterTree==100){
            counterTree=0;
            //addObject(new Tree(), 555, 52);
            //addObject(new Tree(), 480, 120);
            addObject(new Tree(), 307, 160);
            addObject(new Tree(), 403, 160);

            //addObject(new Tree(), 80, 10);
            //addObject(new Tree(), 125, 60);
            //addObject(new Tree(), 80, 10);
            //addObject(new Tree(), 125, 60);
        }*//*else if(counterTree==200){
            counterTree=0;
            addObject(new Tree(), 555, 100);
            addObject(new Tree(), 480, 170);
            
            
            addObject(new Tree(), 80, 100);
            addObject(new Tree(), 125, 170);
        }*/

        counterTest++;

        if (!isConnected())
            return;

        UserData[] us = getTrackedUsers();
        getBackground().setColor(java.awt.Color.WHITE);
        getBackground().fill();

        boolean anyLeftHandUp = false;

        for (UserData u: us)
        {
            //Draws their stick figure:
            u.drawStickFigure(getBackground(), 60);

            anyLeftHandUp = anyLeftHandUp || (u.getJoint(Joint.LEFT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }

        // This is extra code used to warn the user if any of them is keeping their
        // left hand in the air, which effectively prevents any painting because
        // the brush will be cleared every frame:        
        if (anyLeftHandUp)
        {
            if (leftHandUp == -1)
            {
                leftHandUp = System.currentTimeMillis();
            }
            else
            {
                if (System.currentTimeMillis() - leftHandUp > 5000 && leftHandWarning == null)
                {
                    // leftHandWarning = new Label("Put your left hand down to stop clearing the screen.", 40);
                    //addObject(leftHandWarning, getWidth() / 2, getHeight() / 2);
                }
            }
        }
        else
        {
            leftHandUp = -1;
            if (leftHandWarning != null)
            {
                removeObject(leftHandWarning);
                leftHandWarning = null;
            }
        }

    }

    private void prepare()
    {        
       /*int roadCenterOne = 250;
        int roadCenterTwo = 370;

        RoadSides roadsides2 = new RoadSides();
        addObject(roadsides2, 315, 227);
        roadsides2.setLocation(313, 222);
       // road(311);

        addObject(rock, 350, 160);
        addObject(new Tree(), 310, 160);
        addObject(new Tree(), 400, 160);
       // addObject(treeObj, 500, 30);*/
    }

    public void road(int roadCenterX){
        int roadCenterGap  = 25;
        int length = 50;
        int roadCenterY = 0;
        RoadCenter roadcenter,roadcenter1,roadcenter2,roadcenter3,roadcenter4,roadcenter5;

        if(roadCenterX == 250){
            roadcenter = new RoadCenter1();
            roadcenter1 = new RoadCenter1();
            roadcenter2 = new RoadCenter1();
            roadcenter3 = new RoadCenter1();
            roadcenter4 = new RoadCenter1();
            roadcenter5 = new RoadCenter1();
        }else if(roadCenterX == 370){
            roadcenter = new RoadCenter2();
            roadcenter1 = new RoadCenter2();
            roadcenter2 = new RoadCenter2();
            roadcenter3 = new RoadCenter2();
            roadcenter4 = new RoadCenter2();
            roadcenter5 = new RoadCenter2();
        }else{
            roadcenter = new RoadCenter();
            roadcenter1 = new RoadCenter();
            roadcenter2 = new RoadCenter();
            roadcenter3 = new RoadCenter();
            roadcenter4 = new RoadCenter();
            roadcenter5 = new RoadCenter();
        }

        addObject(roadcenter, 315, 107);
        roadcenter.setLocation(roadCenterX, roadCenterY);

        addObject(roadcenter1, 315, 107);
        roadcenter1.setLocation(roadCenterX,roadcenter.getY()+roadCenterGap+length );

        addObject(roadcenter2, 315, 107);
        roadcenter2.setLocation(roadCenterX,roadcenter1.getY()+roadCenterGap+length );

        addObject(roadcenter3, 315, 107);
        roadcenter3.setLocation(roadCenterX,roadcenter2.getY()+roadCenterGap+length );

        addObject(roadcenter4, 315, 107);
        roadcenter4.setLocation(roadCenterX,roadcenter3.getY()+roadCenterGap+length );  

        addObject(roadcenter5, 315, 107);
        roadcenter5.setLocation(roadCenterX,roadcenter4.getY()+roadCenterGap+length );
    }
}

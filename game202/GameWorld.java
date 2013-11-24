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
    private BackGround backGround;
    private static GameWorld gameWorld = null;

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
        
        setBackground("first_screen.png");
        final int width = getWidth();
        final int height = getHeight();

        
        instr = new Instructions();
        thmb = new Thumbnail();
       // backGround = BackGround.getInstance();
       
       
        game = new GameLogic();
        
        paulCharacter = game.getCharacter();        
        
        if ( null == paulCharacter ){
            System.out.println("character is null");
        }
        
        addObject( paulCharacter  , width/2, height);
        
        backGround = game.getBackGround();
        addObject(backGround, 360,240);

        addObject( instr , width/2, height/2);
        addObject( thmb , width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        setPaintOrder(paulCharacter.getClass());
        
    }


    public void act()
    {  
        super.act();

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

}

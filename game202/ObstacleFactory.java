import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstacleFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleFactory extends Actor
{
    /**
     * Act - do whatever the ObstacleFactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }

    public static Obstacles buildObstacle(ObstacleType type) {
        Obstacles obstacle = null;
        switch (type) {
            case ROCK:
            obstacle = new Rock();
            break;

            case ROADBLOCK:
            obstacle = new RoadBlock();
            break;

            /* case OVERHEADBLOCK:
            obstacle = new LuxuryCar();
            break;*/

            case COIN:
            obstacle = new Coin();
            break;

            case TREE:
            obstacle = new Tree();
            break;

            case OVERHEAD:
            obstacle = new OverHead();
            break;
            
            default:
            break;
        }
        return obstacle;
    }
}

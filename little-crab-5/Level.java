import greenfoot.*;
import java.util.*;

/**
 * This class defines the common parent of all the level classes.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level  
{
    // instance variables - replace the example below with your own
    private int _stage;
    private CrabWorld _world;
    final private List worms = new ArrayList();
    final private List lobsters = new ArrayList();
    private Crab player;

    /**
     * Constructor for objects of class Level
     */
    public Level(CrabWorld world)
    {
        _world = world;
    }
    
    public Level(CrabWorld world, int stage, int numberOfWorms, int numberOfLobsters){
        this(world);
        for(int i = 0;i < numberOfWorms;i++){
            spawnWorm();
        }
        for(int i = 0;i < numberOfLobsters;i++){
            spawnLobster();
        }
        spawnPlayer();
        countDown();
        
        _stage = stage;
        
        System.out.println("starting level " + _stage);
    }

    /**
     * This function retruns how many worms are in the world
     */
    public final int getWormAmount(){
        return worms.size();
    }      
    
    /**
     * This function returns in which stage of the game you are, in other world the number of the level.
     */
    public final int getStage(){
        return _stage;
    }
    
    protected final void spawnWorm(){
        worms.add(new Worm());
        _world.addObject((Worm)worms.get(worms.size()-1), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
    }
    
    protected final void spawnLobster(){
        lobsters.add(new Lobster());
        _world.addObject((Lobster)lobsters.get(lobsters.size()-1), Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
        ((Lobster)lobsters.get(lobsters.size()-1)).canmove(false);
    }
    
    protected final void spawnPlayer(){
        player = new Crab();
        _world.addObject(player, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        player.canmove(false);
    }

    protected final void countDown(){ 
        for(int i = 5;i > 0; i--){
            System.out.println("" + i);
            _world.showText("" + i, 300, 300);
            Greenfoot.delay(20);
            _world.showText(" ", 300, 300);
        }

        _world.showText(" ", 300, 300);    
        player.canmove(true);
        for(int i = 0; i < lobsters.size();i++){
            Lobster x = (Lobster) lobsters.get(i);
            if(x != null) x.canmove(true);
        }
    }

    static public Level load(int stageNumber, CrabWorld world){
        switch(stageNumber){
            case(1):
                return new Level(world,1,5,1);
            case(2):
                return new Level(world,2,7,1);
            case(3):
                return new Level(world,3,7,2);
            case(4):
                return new Level(world,4,10,2);
            case(5):
                return new Level(world,5,10,3);
            default:
                return null;   
        }
        
    }
}

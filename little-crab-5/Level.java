import greenfoot.*;

/**
 * This class defines the common parent of all the level classes.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level  
{
    // instance variables - replace the example below with your own
    protected int stage;
    private int numberOfWorms;
    private int numberOfLobsters;
    private CrabWorld _world;
    private Worm[] worms;
    private Lobster[] lobsters;
    private Crab player;

    /**
     * Constructor for objects of class Level
     */
    public Level(CrabWorld world)
    {
        _world = world;
    }

    /**
     * This function retruns how many worms are in the world
     */
    public int getWormAmount(){
        return numberOfWorms;
    }      
    
    /**
     * This function returns in which stage of the game you are, in other world the number of the level.
     */
    public int getStage(){
        return stage;
    }
    
    protected void spawnWorm(){
        numberOfWorms++;
        Worm[] _worms = new Worm[numberOfWorms];
        for(int i = 0; i < numberOfWorms-1;i++){
            _worms[i] = worms[i];
        }
        _worms[numberOfWorms-1] = new Worm();
        _world.addObject(_worms[numberOfWorms-1], Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        worms = _worms;
    }
    
    protected void spawnLobster(){
        numberOfLobsters++;
        Lobster[] _lobsters = new Lobster[numberOfWorms];
        for(int i = 0; i < numberOfLobsters-1;i++){
            _lobsters[i] = lobsters[i];
        }
        _lobsters[numberOfLobsters-1] = new Lobster();
        _world.addObject(_lobsters[numberOfLobsters-1], Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
        lobsters = _lobsters;
        lobsters[numberOfLobsters-1].canmove(false);
    }
    
    protected void spawnPlayer(){
        player = new Crab();
        _world.addObject(player, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        player.canmove(false);
    }

    protected void countDown(){ 
        for(int i = 5;i > 0; i--){
            System.out.println("" + i);
            _world.showText("" + i, 300, 300);
            Greenfoot.delay(20);
            _world.showText(" ", 300, 300);
        }

        _world.showText(" ", 300, 300);    
        player.canmove(true);
        for(Lobster x: lobsters){
            if(x != null) x.canmove(true);
        }
    }

    static public Level load(int stageNumber, CrabWorld world){
        switch(stageNumber){
            case(1):
                return new Level_1(world);
            case(2):
                return new Level_2(world);
            case(3):
                return new Level_3(world);
            case(4):
                return new Level_4(world);
            case(5):
                return new Level_5(world);
            default:
                return null;   
        }
    }
}

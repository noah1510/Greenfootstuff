/**
 * The fifth stage/level the player has to pass.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level_5 extends Level 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Level_1
     */
    public Level_5(CrabWorld world)
    {
        super(world);
        for(int i = 0;i < 10;i++){
            spawnWorm();
        }
        stage = 5;
        spawnLobster();
        spawnLobster();
        spawnLobster();
        spawnPlayer();
        countDown();
        
        System.out.println("starting level 5");
    }

    
}

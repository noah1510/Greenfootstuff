/**
 * The third stage/level the player has to pass.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level_3 extends Level 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Level_1
     */
    public Level_3(CrabWorld world)
    {
        super(world);
        for(int i = 0;i < 7;i++){
            spawnWorm();
        }
        stage = 3;
        spawnLobster();
        spawnLobster();
        spawnPlayer();
        countDown();
        
        System.out.println("starting level 3");
    }

    
}

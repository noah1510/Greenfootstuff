/**
 * The second stage/level the player has to pass.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level_2 extends Level 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Level_1
     */
    public Level_2(CrabWorld world)
    {
        super(world);
        for(int i = 0;i < 7;i++){
            spawnWorm();
        }
        stage = 2;
        spawnLobster();
        spawnPlayer();
        countDown();
        
        System.out.println("starting level 2");
    }

    
}

/**
 * The fourth stage/level the player has to pass.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level_4 extends Level 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Level_1
     */
    public Level_4(CrabWorld world)
    {
        super(world);
        for(int i = 0;i < 10;i++){
            spawnWorm();
        }
        stage = 4;
        spawnLobster();
        spawnLobster();
        spawnPlayer();
        countDown();
        
        System.out.println("starting level 4");
    }

    
}

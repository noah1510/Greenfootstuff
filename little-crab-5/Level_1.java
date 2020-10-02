/**
 * The first stage/level the player has to pass.
 * 
 * @author NoaSakurajin
 * @version 1
 */
public class Level_1 extends Level 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Level_1
     */
    public Level_1(CrabWorld world)
    {
        super(world);
        for(int i = 0;i < 5;i++){
            spawnWorm();
        }
        stage = 1;
        spawnLobster();
        spawnPlayer();
        
        System.out.println("starting level 1");
    }

    
}

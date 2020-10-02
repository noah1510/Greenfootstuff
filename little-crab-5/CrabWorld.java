import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

/**
 * The CrabWorld is the place where crabs and other creatures live. 
 * It creates the initial population.
 */
public class CrabWorld extends World
{
    private int level = 0;
    private boolean allowedtomove;
    private Level currentLevel;
    
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(600, 600, 1);
        nextLevel();
    }
    
    public final void nextLevel(){
        level++;
        if(level == 6){
            System.out.println("Spiel abgeschlossen");
            showText("!!!Du hast gewonnen!!!",300,300);
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.delay(50);
            reset();
            return;
        }
        Leveldestroy();
        currentLevel = Level.load(level,this);
        allowedtomove = true;
    }
    
    public final int getWormCount(){
        return currentLevel.getWormAmount();
    }
    
    public final void stop(){
        if(allowedtomove){
            java.util.List lobster = getObjects(Lobster.class);
            java.util.List crab = getObjects(Crab.class);
            for(int i = lobster.size() - 1;i >= 0;i--){
                ((Lobster)lobster.get(i)).canmove(false);
            }
            for(int i = crab.size() - 1;i >= 0;i--){
                ((Crab)crab.get(i)).canmove(false);
            }
        }
    }
    
    public final void start(){
        if(allowedtomove){
            java.util.List lobster = getObjects(Lobster.class);
            java.util.List crab = getObjects(Crab.class);
            for(int i = lobster.size() - 1;i >= 0;i--){
                ((Lobster)lobster.get(i)).canmove(true);
            }
            for(int i = crab.size() - 1;i >= 0;i--){
                ((Crab)crab.get(i)).canmove(true);
            }
        }
    }
    
    private final void Leveldestroy(){
        System.out.println("clearing level" + (level - 1) );
        removeObjects(getObjects(Actor.class));
        currentLevel = null;
        System.gc();
    }

    public final void reset(){
        System.out.println("starting reset");
        Leveldestroy();  
        showText("",300,300);
        level = 0;
        nextLevel();
        System.out.println("rest completed");
    }
}
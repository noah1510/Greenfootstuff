import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

/**
 * The CrabWorld is the place where crabs and other creatures live. 
 * It creates the initial population.
 */
public class CrabWorld extends World
{
    public int level = 1;
    private boolean allowedtomove;
    
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(600, 600, 1);
        prepare();
        
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    public void prepare()
    {
        switch(level){
            case(1):
                Level1();   
                break;
            case(2):
                Level2();
                break;
            case(3):
                Level3();
                break;
            case(4):
                Level4();
                break;
            case(5):
                Level5();
                break;
            case(6):
                System.out.println("Spiel abgeschlossen");
                showText("!!!Du hast gewonnen!!!",300,300);
                Greenfoot.playSound("fanfare.wav");
                Greenfoot.delay(50);
                reset();
                break;
            default:
                reset();
                break;
        }
    }
    
    private void Level1(){
        System.out.println("starting level 1");
        
        Crab crab = new Crab();
        addObject(crab, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm2 = new Worm();
        addObject(worm2, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm3 = new Worm();
        addObject(worm3, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm4 = new Worm();
        addObject(worm4, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm5 = new Worm();
        addObject(worm5, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        
        Lobster lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
             
        allowedtomove = true;
        
        crab.canmove(false);
        lobster.canmove(false);

    }
    
    public void stop(){
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
    
    public void start(){
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
    
    private void Leveldestroy(){
        System.out.println("clearing level" + (level - 1) );
        removeObjects(getObjects(Actor.class));
    }
    
    private void Level2(){
        Leveldestroy();
        
        System.out.println("starting level 2");
        
        Crab crab = new Crab();
        addObject(crab, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm2 = new Worm();
        addObject(worm2, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm3 = new Worm();
        addObject(worm3, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm4 = new Worm();
        addObject(worm4, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm5 = new Worm();
        addObject(worm5, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm6 = new Worm();
        addObject(worm6, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm7 = new Worm();
        addObject(worm7, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        
        Lobster lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
        
        allowedtomove = false;
        
        crab.canmove(false);
        lobster.canmove(false);
        for(int i = 5;i > 0; i--){
            System.out.println("" + i);
            showText("" + i, 300, 300);
            Greenfoot.delay(20);
            showText(" ", 300, 300);
        }
        showText(" ", 300, 300);
        
        allowedtomove = true;
        
        crab.canmove(true);
        lobster.canmove(true);
    }
    
    private void Level3(){
        Leveldestroy();
        
        System.out.println("starting level 3");
        
        Crab crab = new Crab();
        addObject(crab, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm2 = new Worm();
        addObject(worm2, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm3 = new Worm();
        addObject(worm3, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm4 = new Worm();
        addObject(worm4, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm5 = new Worm();
        addObject(worm5, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm6 = new Worm();
        addObject(worm6, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm7 = new Worm();
        addObject(worm7, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        
        Lobster lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
        Lobster lobster2 = new Lobster();
        addObject(lobster2, Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(100)+300);
        
        allowedtomove = false;
        
        crab.canmove(false);
        lobster.canmove(false);
        lobster2.canmove(false);
        for(int i = 5;i > 0; i--){
            System.out.println("" + i);
            showText("" + i, 300, 300);
            Greenfoot.delay(20);
            showText(" ", 300, 300);
        }
        showText(" ", 300, 300);
        
        allowedtomove = true;
        
        crab.canmove(true);
        lobster.canmove(true);
        lobster2.canmove(true);
    }
    
    private void Level4(){
        Leveldestroy();
        
        System.out.println("starting level 4");
        
        Crab crab = new Crab();
        addObject(crab, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm2 = new Worm();
        addObject(worm2, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm3 = new Worm();
        addObject(worm3, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm4 = new Worm();
        addObject(worm4, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm5 = new Worm();
        addObject(worm5, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm6 = new Worm();
        addObject(worm6, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm7 = new Worm();
        addObject(worm7, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm8 = new Worm();
        addObject(worm8, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm9 = new Worm();
        addObject(worm9, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm10 = new Worm();
        addObject(worm10, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        
        Lobster lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
        Lobster lobster2 = new Lobster();
        addObject(lobster2, Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(100)+300);
        
        allowedtomove = false;
        
        crab.canmove(false);
        lobster.canmove(false);
        lobster2.canmove(false);
        for(int i = 5;i > 0; i--){
            System.out.println("" + i);
            showText("" + i, 300, 300);
            Greenfoot.delay(20);
            showText(" ", 300, 300);
        }
        showText(" ", 300, 300);
        
        allowedtomove = false;
        
        crab.canmove(true);
        lobster.canmove(true);
        lobster2.canmove(true);
    }
    
     private void Level5(){
        Leveldestroy();
         
        System.out.println("starting level 5");
        
        Crab crab = new Crab();
        addObject(crab, Greenfoot.getRandomNumber(100)+100, Greenfoot.getRandomNumber(100)+100);
        
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm2 = new Worm();
        addObject(worm2, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm3 = new Worm();
        addObject(worm3, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm4 = new Worm();
        addObject(worm4, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm5 = new Worm();
        addObject(worm5, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm6 = new Worm();
        addObject(worm6, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm7 = new Worm();
        addObject(worm7, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm8 = new Worm();
        addObject(worm8, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm9 = new Worm();
        addObject(worm9, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        Worm worm10 = new Worm();
        addObject(worm10, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        
        Lobster lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100)+300);
        Lobster lobster2 = new Lobster();
        addObject(lobster2, Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(100)+300);
        Lobster lobster3 = new Lobster();
        addObject(lobster3, Greenfoot.getRandomNumber(100)+300, Greenfoot.getRandomNumber(100));
        
        allowedtomove = false;
        
        crab.canmove(false);
        lobster.canmove(false);
        lobster2.canmove(false);
        lobster3.canmove(false);
        for(int i = 5;i > 0; i--){
            System.out.println("" + i);
            showText("" + i, 300, 300);
            Greenfoot.delay(20);
            showText(" ", 300, 300);
        }
        showText(" ", 300, 300);
        
        allowedtomove = true;
        
        crab.canmove(true);
        lobster.canmove(true);
        lobster2.canmove(true);
        lobster3.canmove(true);
    }
    
    public void reset(){
        System.out.println("starting reset");
        Leveldestroy();  
        showText("",300,300);
        level = 1;
        prepare();
        System.out.println("rest completed");
    }
}
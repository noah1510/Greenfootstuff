import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage
import java.util.*;
/**
 * The CrabWorld is the place where crabs and other creatures live. 
 * It creates the initial population.
 */
public class CrabWorld extends World
{
    private GreenfootImage background;
    public Vector players;
    public Vector powerups;
    public Lobster lobster;
    public int playernumber = 2;
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(600, 600, 1);
        background = new GreenfootImage("sand.jpg");
        players = new Vector();
        powerups = new Vector();
        setBackground(background);
        prepare();
        
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    public void prepare()
    {
        for (int i = 1;i <= playernumber;i++){
            players.add(new Crab(i));
            addObject(((Crab)players.get(i-1)), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        }
        
        lobster = new Lobster(playernumber);
        addObject(lobster, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(100)+500);
        
        ateworm();
        
    }
    
    public void gameover(){
        reset();
        pause();
    }
    
    public void pause(){
        for (int i = 0;i < playernumber;i++){
            ((Crab)players.get(i)).canmove(false);
        }
        lobster.canmove(false);
    }
    
    public void restart(){
        for (int i = 0;i < playernumber;i++){
            ((Crab)players.get(i)).canmove(true);
        }
        lobster.canmove(true);
    }
    
    public void ateworm(){
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        
        String score = new String();
        score = "";
        for(int i = 1;i <= playernumber;i++){
            score += ("P " + i + ":" + ((Crab)players.get(i-1)).getworms() + "\n");
        }
        showText(score,25,15 + ((int) (playernumber * playernumber * 1.75f)));
        
    }
    
    public void spawnpowerup(){
        int temp = Greenfoot.getRandomNumber(6);
        powerups.add(new PowerUp(temp));
        addObject(((PowerUp)powerups.lastElement()), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
    }
    
    public void reset(){
        removeObjects(getObjects(Actor.class));
        players.clear();
        powerups.clear();
        prepare();
        pause();
    }
    
    public void slowothers(int player){
        for (int i = 0; i < playernumber;i++){
            if((i+1)!= player){
                ((Crab)players.get(i)).slow();
            }
        }
    }
    
    public void boostothers(int player){
        for (int i = 0; i < playernumber;i++){
            if((i+1)!= player){
                ((Crab)players.get(i)).boost();
            }
        }
    }
    
    
}
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
    private boolean paused = false;
    
    //defines the number of players
    static final int playernumber = 2;
    
    //defines the controls of for each player from player number 1 to player number n (n = controls_player.length)
    static final String[][] controls_player = {
        {"a","d"},
        {"left","right"},
        {"4","6"},
        {"u","o"}
    };
    
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
        reset();
        
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
        
        lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(100)+500);
        
        ateworm();
        
    }
    
    public void gameover(){
        updateScore();
        pause();
    }
    
    public void pause(){
        if(!paused){
            for (int i = 0;i < playernumber;i++){
                ((Crab)players.get(i)).canmove(false);
            }
            lobster.canmove(false);
            paused = true;
        }
    }
    
    public void restart(){
        if(paused){
            for (int i = 0;i < playernumber;i++){
                ((Crab)players.get(i)).canmove(true);
            }
            lobster.canmove(true);
            paused = false;
        }
    }
    
    public void ateworm(){
        Worm worm = new Worm();
        addObject(worm, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        updateScore();  
    }
    
    public void updateScore(){
        boolean won = false;
        int winner = 0;
        int alive = 0;
        for(int i = 1;i <= playernumber;i++){
            Crab player = (Crab)players.get(i-1);
            showText("P " + i + ":" + player.getworms(),45,10 + 25*i);
            if(player.getalive()){
                alive++;
                if(alive == 1 && !won){
                    winner = i;
                }
            }
            
            if(player.getworms() == 20){
                winner = i;
                won = true;
            }
            
        }
        
        if(won || alive == 1){
            
            showText("Player " + winner + " won!",300,300);
            Greenfoot.delay(20);
            showText("",300,300);
            reset();
        }
        
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
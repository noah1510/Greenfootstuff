import greenfoot.*;

/**
 * Worm. A sand worm. Very yummy. Especially crabs really like it.
 */
public class Worm extends Actor{
    private final GreenfootImage image1 = new GreenfootImage("worm1.png");
    private final GreenfootImage image2 = new GreenfootImage("worm1_1.png");
    private int counter;
    
    public Worm(){
        setImage(image1);
        counter = 0;
    }
    
    public void act(){
        counter++;
        switchImage();
    }

    private void switchImage(){

        if (getImage() == image1) {
            if(counter == 15){
                setImage(image2);
                counter = 0;
            }
        }
        else{
            if(counter == 15){
                setImage(image1);
                counter = 0;
            }
        }
    }
}
package Aliens;

import Speed.SpeedStrategy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Alien {

    protected int  height, width, points, xStart, yStart, xIncrease, yIncrease;
    protected double layoutX, layoutY, speed;
    protected ImageView alienAvatar;
    public static int alienCounter = 0;
    public static int alienRow = 0;
    SpeedStrategy speedStrategy;

    public Alien() {
        height = 40;
        width = 40;
        xStart = 20;
        yStart = 50;
        xIncrease = 60;
        yIncrease = 60;
        layoutX = layoutXInitializer();
        layoutY = layoutYInitializer();
        alienAvatar = createAlienAvatar();
        alienCounter++;
        alienCounterCheck();
         
    }
    
    public void setSpeedStrategy(SpeedStrategy st){
        this.speedStrategy = st;
        useSpeedStrategy ();
    }
    
    public void useSpeedStrategy (){
        speed = speedStrategy.movementSpeed();
    }
    
    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public int layoutXInitializer () {
        return xStart + xIncrease * alienCounter;
    }
    public int layoutYInitializer () {
        return yStart + yIncrease * alienRow;
    }

    public void alienCounterCheck() {
        if (alienCounter >= 10) {
            alienCounter = 0;
            alienRow++;
        }
    }

    public ImageView createAlienAvatar() {
        ImageView a = new ImageView(new Image(getClass().getResourceAsStream("alien.png")));
        a.setLayoutX(layoutX);
        a.setLayoutY(layoutY);
        a.setFitHeight(height);
        a.setFitWidth(width);
        return a;
    }
    
    public ImageView getAlienAvatar() {
        return alienAvatar;
    }
    
     public void updateAlienAvatar() {
        alienAvatar.setLayoutX(layoutX);
        alienAvatar.setLayoutY(layoutY);
    }   
}

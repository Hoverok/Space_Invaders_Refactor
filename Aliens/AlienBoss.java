package Aliens;

import Speed.SpeedLevelZero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AlienBoss extends Alien {

    public AlienBoss() {
        super();
        points = 170;
        speedStrategy = new SpeedLevelZero();
        speed = speedStrategy.movementSpeed();
    }

    public ImageView createAlienAvatar() {
        ImageView a = new ImageView(new Image(getClass().getResourceAsStream("../images/alienBoss.png")));
        a.setLayoutX(layoutX);
        a.setLayoutY(layoutY);
        a.setFitHeight(height);
        a.setFitWidth(width);
        return a;
    }
    
    

}

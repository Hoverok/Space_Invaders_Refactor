package Movement;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import Aliens.Alien;
import GameManagers.DefeatManager;
import Player.Player;

public class AlienMover {

    Alien alien;
    Player player;
    private double movementCounter, speed;
    private char movementDirection;

    public AlienMover() {
        movementCounter = 0;
        speed = 0;
        movementDirection = 'r';
    }

    public void movement(ArrayList<Alien> aliens, DefeatManager defeatManager, AnimationTimer timer) {
        if (!aliens.isEmpty()) {
            Alien firstAlien = aliens.get(0);

            speed = firstAlien.getSpeed();
            speed = setDirectionValue(speed);

            if (movementCounter >= 270) {
                movementDirection = 'l';
                for (int i = 0; i < aliens.size(); i++) {
                    alien = aliens.get(i);
                    descendAlienY(alien, defeatManager, timer);
                }
            } 
            if (movementCounter < 0) {
                movementDirection = 'r';
                for (int i = 0; i < aliens.size(); i++) {
                    alien = aliens.get(i);
                    descendAlienY(alien, defeatManager, timer);
                }
            }
            for (int i = 0; i < aliens.size(); i++) {
                alien = aliens.get(i);
                moveAlienX(alien, speed);
            }
            movementCounter += speed;
        }
    }

    public double setDirectionValue(double speed) {
        if (movementDirection == 'l' && speed > 0) {
            speed *= -1;
            return speed;
        } else {
            return speed;
        }
    }

    public void descendAlienY(Alien alien, DefeatManager defeatManager, AnimationTimer timer) {
        double currentLayoutY = alien.getLayoutY();
        alien.setLayoutY(currentLayoutY + 10);
        alien.updateAlienAvatar();
        defeatManager.checkAlienReachPlayer(alien, timer);

    }

    public void moveAlienX(Alien alien, double speed) {
        double currentLayoutX = alien.getLayoutX();
        alien.setLayoutX(currentLayoutX + speed);
        alien.updateAlienAvatar();
    }

    public char getMovementDirection() {
        return movementDirection;
    }

    public void setMovementDirection(char movementDirection) {
        this.movementDirection = movementDirection;
    }
    
}
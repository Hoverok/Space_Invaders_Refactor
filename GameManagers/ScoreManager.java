package GameManagers;

import Aliens.Alien;
import Speed.SpeedLevelOne;
import Speed.SpeedLevelTwo;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreManager {

    private int numScore;
    private int scoreLevelOne, scoreLevelTwo;
    boolean speedFlagOne, speedFlagTwo;
    Alien alien;
    Text score;
    Pane root;
    double layoutX, layoutY;

    public ScoreManager(Pane root) {
        numScore = 0;
        score = new Text("SCORE " + numScore);
        layoutX = 10;
        layoutY = 30;
        //speedLevel = 1;
        speedFlagOne = false;
        speedFlagOne = false;
        scoreLevelOne = 800;
        scoreLevelTwo = 1500;
        score.setLayoutX(layoutX);
        score.setLayoutY(layoutY);
        score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        score.setFill(Color.WHITE);
        this.root = root;
        root.getChildren().add(score);
    }

    public int getNumScore() {
        return numScore;
    }

    public void setNumScore(int numScore) {
        this.numScore = numScore;

    }

    public void addNumScore(int numScore, ArrayList<Alien> aliens) {
        this.numScore += numScore;
        if (!speedFlagOne && this.numScore > scoreLevelOne) {;
            updateSpeedLevelOne(aliens);
        }
        if (!speedFlagTwo && this.numScore > scoreLevelTwo) {
            updateSpeedLevelTwo(aliens);
        }
    }

    public void updateSpeedLevelOne(ArrayList<Alien> aliens) {
        for (int i = 0; i < aliens.size(); i++) {
            alien = aliens.get(i);
            alien.setSpeedStrategy(new SpeedLevelOne());
        }
        speedFlagOne = true;
    }

    public void updateSpeedLevelTwo(ArrayList<Alien> aliens) {
        for (int i = 0; i < aliens.size(); i++) {
            alien = aliens.get(i);
            alien.setSpeedStrategy(new SpeedLevelTwo());
        }
        speedFlagTwo = true;

    }

    public void updateScoreText() {
        score.setText("SCORE " + String.valueOf(numScore));
    }

}

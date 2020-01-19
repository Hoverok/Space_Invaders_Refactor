package GameManagers;

import Aliens.Alien;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VictoryManager {

    Text victoryText;
    Pane root;
    double layoutX, layoutY;
    ArrayList<Alien> aliens;
    public VictoryManager(Pane root) {
        layoutX = 300;
        layoutY = 350;
        this.root = root;
    }

    public void victoryConditionCheck(ArrayList<Alien> aliens, AnimationTimer timer) {
        if (aliens.isEmpty()) {
            victory(timer);
        }
    }

    public void victory(AnimationTimer timer) {
        victoryText = new Text();
        victoryText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
        victoryText.setX(210);
        victoryText.setY(350);
        victoryText.setFill(Color.WHITE);
        victoryText.setText("VICTORY");
        root.getChildren().add(victoryText);
        timer.stop();
    }
}

package GameManagers;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LivesManager {

    int numLives;
    Text lives;
    Pane root;
    double layoutX, layoutY;
    public LivesManager(Pane root) {
        numLives = 3;
        lives = new Text("LIVES " + numLives);
        layoutX = 800;
        layoutY = 30;
        lives.setLayoutX(layoutX);
        lives.setLayoutY(layoutY);
        lives.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lives.setFill(Color.WHITE);
        this.root = root;
        root.getChildren().add(lives);
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public void decrementNumLive() {
        this.numLives --;
    }

    public void updateScoreText() {
        lives.setText("LIVES " + String.valueOf(numLives));
    }
}

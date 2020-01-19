package GameManagers;

import Aliens.Alien;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Player.Player;

public class DefeatManager {

    Text defeatText;
    Pane root;
    Player player;
    double layoutX, layoutY, playerLayoutY, alienLayoutY, layoutYAdjustment;

    public DefeatManager(Pane root, Player player) {
        layoutX = 300;
        layoutY = 350;
        this.root = root;
        this.player = player;
        playerLayoutY = player.getLayoutY();
        layoutYAdjustment = 30;
    }
    
    public void checkAlive(int livesRemaining, AnimationTimer timer) {
        if (livesRemaining <= 0) {
            defeat(timer);
        }
    }
    
    public void checkAlienReachPlayer(Alien alien, AnimationTimer timer){
        alienLayoutY = alien.getLayoutY();
        if (alienLayoutY >= playerLayoutY - layoutYAdjustment)
        {
            defeat(timer);
        }
    }
    
    public void defeat(AnimationTimer timer) {
        defeatText = new Text();
        defeatText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
        defeatText.setX(130);
        defeatText.setY(350);
        defeatText.setFill(Color.RED);
        defeatText.setText("GAME OVER");
        root.getChildren().add(defeatText);
        timer.stop();
    }
}

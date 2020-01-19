package Player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {

    double layoutX, layoutY, height, width;
    private ImageView playerAvatar;
    Pane root;

    public Player(Pane root) {
        layoutX = 425;
        layoutY = 650;
        height = 40;
        width = 40;
        this.root = root;
        playerAvatar = createPlayerAvatar();

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

    public ImageView createPlayerAvatar() {
        ImageView p = new ImageView(new Image(getClass().getResourceAsStream("../images/player.png")));
        p.setLayoutX(layoutX);
        p.setLayoutY(layoutY);
        p.setFitHeight(height);
        p.setFitWidth(width);
        root.getChildren().add(p);
        return p;
    }

    public void updatePlayerAvatar() {
        playerAvatar.setLayoutX(layoutX);
        playerAvatar.setLayoutY(layoutY);
    }

    public ImageView getPlayerAvatar() {
        return playerAvatar;
    }

}

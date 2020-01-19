package Movement;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import Bullets.Bullet;
import Bullets.PlayerBulletCreator;

public class PlayerBulletMover {

    private ArrayList<Bullet> pBullets;
    private double currentBulletLayoutY;
    private double newBulletLayoutY;
    private int bulletMovementSpeed;
    Bullet bullet;

    public PlayerBulletMover(PlayerBulletCreator pBulletCreator) {
        pBullets = pBulletCreator.getpBullets();
        bulletMovementSpeed = 5;
    }

    public void movePlayerBullets(Pane root) {
        if (!pBullets.isEmpty()) {
            for (int i = 0; i < pBullets.size(); i++) {
                bullet = pBullets.get(i);
                currentBulletLayoutY = bullet.getLayoutY();
                newBulletLayoutY = currentBulletLayoutY - bulletMovementSpeed;
                bullet.setLayoutY(newBulletLayoutY);
                removeOutOfField(root);
                bullet.updateBulletAvatar();
            }
        }
    }

    public void removeOutOfField(Pane root) {
        if (newBulletLayoutY <= 0) {
            root.getChildren().remove(bullet.getBulletAvatar());
            pBullets.remove(bullet);
        }
    }

    public int getBulletMovementSpeed() {
        return bulletMovementSpeed;
    }

    public void setBulletMovementSpeed(int bulletMovementSpeed) {
        this.bulletMovementSpeed = bulletMovementSpeed;
    }
    
}

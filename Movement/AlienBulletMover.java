package Movement;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import Bullets.AlienBulletCreator;
import Bullets.Bullet;

public class AlienBulletMover {

    private ArrayList<Bullet> aBullets;
    private double currentBulletLayoutY;
    private double newBulletLayoutY;
    int bulletMovementSpeed;
    Bullet bullet;
    

    public AlienBulletMover(AlienBulletCreator aBulletCreator) {
        aBullets = aBulletCreator.getaBullets();
        bulletMovementSpeed = 5;
    }

    public void moveAlienBullets(Pane root) {
        if (!aBullets.isEmpty()) {
            for (int i = 0; i < aBullets.size(); i++) {
                bullet = aBullets.get(i);
                currentBulletLayoutY = bullet.getLayoutY();
                newBulletLayoutY = currentBulletLayoutY + bulletMovementSpeed;
                bullet.setLayoutY(newBulletLayoutY);
                removeOutOfField(root);
                bullet.updateBulletAvatar();
            }
        }
    }

    public void removeOutOfField(Pane root) {
        if (newBulletLayoutY >=700) {
            root.getChildren().remove(bullet.getBulletAvatar());
            aBullets.remove(bullet);
        }
    }
}

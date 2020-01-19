package Collision;

import Collision.*;
import space_invaders_refactor.*;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import Bullets.AlienBulletCreator;
import Bullets.Bullet;
import GameManagers.DefeatManager;
import GameManagers.LivesManager;
import Player.Player;

public class AlienBulletCollisionChecker {

    private ArrayList<Bullet> aBullets;
    int playerLives;
    Bullet bullet;
    Player player;

    public AlienBulletCollisionChecker(AlienBulletCreator aBulletCreator, Player player) {
        aBullets = aBulletCreator.getaBullets();
        this.player = player;
    }

    public void checkAlienBullets(Pane root, LivesManager livesManager, DefeatManager defeatManager, AnimationTimer timer) {
        for (int i = 0; i < aBullets.size(); i++) {
            bullet = aBullets.get(i);
            if (checkHitBox(player, bullet)) {
                livesManager.decrementNumLive();
                livesManager.updateScoreText();
                playerLives = livesManager.getNumLives();
                defeatManager.checkAlive(playerLives, timer);
                root.getChildren().remove(bullet.getBulletAvatar());
                aBullets.remove(i);
                player.setLayoutX(425);
                player.updatePlayerAvatar();

            }
        }
    }

    public boolean checkHitBox(Player player, Bullet bullet) {
        if (((bullet.getLayoutX() > player.getLayoutX())
                && ((bullet.getLayoutX() < player.getLayoutX() + 40))
                && ((bullet.getLayoutY() > player.getLayoutY())
                && ((bullet.getLayoutY() < player.getLayoutY() + 40))))) {
            return true;
        } else {
            return false;
        }
    }
}

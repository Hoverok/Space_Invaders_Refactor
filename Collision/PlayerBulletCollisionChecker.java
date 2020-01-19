package Collision;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import Aliens.Alien;
import Aliens.AlienCreator;
import Bullets.Bullet;
import Bullets.PlayerBulletCreator;
import GameManagers.ScoreManager;
import GameManagers.VictoryManager;

public class PlayerBulletCollisionChecker {

    private ArrayList<Bullet> pBullets;
    private ArrayList<Alien> aliens;
    private ArrayList<Integer> killedAliensIndexes;
    private ArrayList<Integer> hitBulletsIndexes;
    Bullet bullet;
    Alien alien;
    int alienPoints;

    public PlayerBulletCollisionChecker(PlayerBulletCreator pBulletCreator, AlienCreator alienCreator) {
        pBullets = pBulletCreator.getpBullets();
        aliens = alienCreator.getAliens();
        killedAliensIndexes = new ArrayList();
        hitBulletsIndexes = new ArrayList();
    }

    public void checkPlayerBullets(Pane root, ScoreManager scoreManager, VictoryManager victoryManager, AnimationTimer timer) {
        for (int i = 0; i < pBullets.size(); i++) {
            for (int j = 0; j < aliens.size(); j++) {
                bullet = pBullets.get(i);
                alien = aliens.get(j);
                if (checkHitBox(alien, bullet)) {
                    hitBulletsIndexes.add(i);
                    killedAliensIndexes.add(j);
                    alienPoints = alien.getPoints();
                    scoreManager.addNumScore(alienPoints, aliens);
                    scoreManager.updateScoreText();
                }
            }
        }
        deadAlienRemoval(root,victoryManager, timer);
        hitBulletRemoval(root);

    }

    public boolean checkHitBox(Alien alien, Bullet bullet) {
        if (((bullet.getLayoutX() > alien.getLayoutX())
                && ((bullet.getLayoutX() < alien.getLayoutX() + 40))
                && ((bullet.getLayoutY() > alien.getLayoutY())
                && ((bullet.getLayoutY() < alien.getLayoutY() + 40))))) {
            return true;
        } else {
            return false;
        }
    }

    public void deadAlienRemoval(Pane root, VictoryManager victoryManager, AnimationTimer timer) {
        for (int i = 0; i < killedAliensIndexes.size(); i++) {
            int index = killedAliensIndexes.get(i);
            alien = aliens.get(index);
            root.getChildren().remove(alien.getAlienAvatar());
            aliens.remove(alien);
            killedAliensIndexes.clear();
            victoryManager.victoryConditionCheck(aliens, timer);
        }
    }

    public void hitBulletRemoval(Pane root) {
        for (int i = 0; i < hitBulletsIndexes.size(); i++) {
            int index = hitBulletsIndexes.get(i);
            bullet = pBullets.get(index);
            root.getChildren().remove(bullet.getBulletAvatar());
            pBullets.remove(bullet);
            hitBulletsIndexes.clear();
        }
    }

}

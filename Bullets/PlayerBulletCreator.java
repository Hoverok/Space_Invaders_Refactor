package Bullets;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import Player.Player;

public class PlayerBulletCreator {

    private double initialBulletX;
    private double initialBulletY;
    private double lastPlayerBulletTime;
    double bulletCooldown;
    private ArrayList<Bullet> pBullets = new ArrayList();
    Pane root;

    public PlayerBulletCreator() {
        lastPlayerBulletTime = 0;
        bulletCooldown = 250;
    }

    ;
    
    public PlayerBulletCreator(Pane root) {
        initialBulletY = 650;
        lastPlayerBulletTime = 0;
        bulletCooldown = 250;
        this.root = root;

    }

    public ArrayList<Bullet> getpBullets() {
        return pBullets;
    }

    public void addPlayerBullet(Player player) {
        if (canFire()) {
            initialBulletX = player.getLayoutX() + 20;
            Bullet bullet = new Bullet(initialBulletX, initialBulletY);
            pBullets.add(bullet);
            Circle c = bullet.getBulletAvatar();
            root.getChildren().add(c);
            lastPlayerBulletTime = System.currentTimeMillis();
        }
    }

    public boolean canFire() {
        double currentTime = System.currentTimeMillis();
        if (currentTime - bulletCooldown > lastPlayerBulletTime) {
            return true;
        } else {
            return false;
        }
    }

    public double getLastPlayerBulletTime() {
        return lastPlayerBulletTime;
    }

    public void setLastPlayerBulletTime(double lastPlayerBulletTime) {
        this.lastPlayerBulletTime = lastPlayerBulletTime;
    }

    public double getBulletCooldown() {
        return bulletCooldown;
    }

    public void setBulletCooldown(double bulletCooldown) {
        this.bulletCooldown = bulletCooldown;
    }
    
    
}

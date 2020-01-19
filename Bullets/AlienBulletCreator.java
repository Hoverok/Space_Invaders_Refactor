package Bullets;

import Aliens.Alien;
import Aliens.AlienCreator;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import Bullets.Bullet;

public class AlienBulletCreator {

    private double initialBulletX;
    private double initialBulletY;
    private int randomAlienIndex;
    private ArrayList<Bullet> aBullets = new ArrayList();
    private ArrayList<Alien> aliens;
    Pane root;

    public AlienBulletCreator(Pane root, AlienCreator alienCreator) {
        this.root = root;
        this.aliens = alienCreator.getAliens();
    }

    public ArrayList<Bullet> getaBullets() {
        return aBullets;
    }

    public void addAlienBullet() {
        Alien alien;
        randomAlienIndex = getRandomNumber(0, aliens.size());
        alien = getAlienById(randomAlienIndex);
        initialBulletX = alien.getLayoutX() + 20;
        initialBulletY = alien.getLayoutY() + 20;
        Bullet bullet = new Bullet(initialBulletX, initialBulletY);

        aBullets.add(bullet);
        Circle c = bullet.getBulletAvatar();
        root.getChildren().add(c);
    }

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * ((max - min))) + min;
    }

    public Alien getAlienById(int randomAlienIndex) {
        Alien alien = aliens.get(randomAlienIndex);
        return alien;
    }
}

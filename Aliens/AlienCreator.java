package Aliens;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class AlienCreator {

    private int numberOfAlienBosses;
    private int numberOfAlienGrunts;
    private ArrayList<Alien> aliens = new ArrayList();
    Pane root;

    public AlienCreator(Pane root) {
        numberOfAlienBosses = 10;
        numberOfAlienGrunts = 20;
        this.root = root;
        createAliens();
    }

    public ArrayList<Alien> getAliens() {
        return aliens;
    }

    public void createAliens() {
        for (int i = 0; i < numberOfAlienBosses; i++) {
            Alien alienBoss = new AlienBoss();
            aliens.add(alienBoss);
            root.getChildren().add((Node) alienBoss.getAlienAvatar());
        }
        for (int i = 0; i < numberOfAlienGrunts; i++) {
            Alien alienGrunt = new AlienGrunt();
            aliens.add(alienGrunt);
            root.getChildren().add((Node) alienGrunt.getAlienAvatar());
        }
    }

}

package space_invaders_refactor;

import Player.Player;
import GameManagers.ScoreManager;
import GameManagers.VictoryManager;
import GameManagers.LivesManager;
import GameManagers.DefeatManager;
import Bullets.AlienBulletCreator;
import Bullets.PlayerBulletCreator;
import Aliens.AlienCreator;
import Collision.AlienBulletCollisionChecker;
import Collision.PlayerBulletCollisionChecker;
import Movement.PlayerBulletMover;
import Movement.AlienMover;
import Movement.PlayerMovement;
import Movement.AlienBulletMover;
import javafx.animation.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameApplication extends Application {

    Pane root;
    ScoreManager scoreManager;
    LivesManager livesManager;
    Player player;
    AlienCreator alienCreator;
    ImageView playerAvatar;
    PlayerMovement playerMovement;
    AlienMover alienMovement;
    PlayerBulletCreator playerBulletCreator;
    PlayerBulletMover playerBulletMover;
    AlienBulletCreator alienBulletCreator;
    AlienBulletMover alienBulletMover;
    PlayerBulletCollisionChecker playerBulletCollisionChecker;
    AlienBulletCollisionChecker alienBulletCollisionChecker;
    VictoryManager victoryManager;
    DefeatManager defeatManager;
    AnimationTimer timer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Pane();
        objectInitializer();
        Scene gameField = sceneSetter();
        timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                gameState();
            }
        };
        timer.start();
        Timeline alienFire = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {
            if (!alienCreator.getAliens().isEmpty()) {
                alienFireBullet();
            }
        }));
        alienFire.setCycleCount(Animation.INDEFINITE);
        alienFire.play();
        gameField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                playerMovement.movePlayerLeft(player);
            }
            if (e.getCode() == KeyCode.D) {
                playerMovement.movePlayerRight(player);
            }
            if (e.getCode() == KeyCode.SPACE) {
                playerFireBullet();
            }
        });
        primaryStage.setScene(gameField);
        primaryStage.setTitle("SPACE INVADERS");
        primaryStage.show();
    }

    public void gameState() {
        moveAliens();
        playerMoveBullets();
        alienMoveBullets();
        playerBulletCheck();
        alienBulletCheck();
    }

    public void objectInitializer() {
        scoreManager = new ScoreManager(root);
        livesManager = new LivesManager(root);
        player = new Player(root);
        alienCreator = new AlienCreator(root);
        playerMovement = new PlayerMovement();
        alienMovement = new AlienMover();
        playerBulletCreator = new PlayerBulletCreator(root);
        playerBulletMover = new PlayerBulletMover(playerBulletCreator);
        alienBulletCreator = new AlienBulletCreator(root, alienCreator);
        alienBulletMover = new AlienBulletMover(alienBulletCreator);
        playerBulletCollisionChecker = new PlayerBulletCollisionChecker(playerBulletCreator, alienCreator);
        alienBulletCollisionChecker = new AlienBulletCollisionChecker(alienBulletCreator, player);
        victoryManager = new VictoryManager(root);
        defeatManager = new DefeatManager(root,player);
    }

    public Scene sceneSetter() {
        int sceneWidth = 900;
        int sceneHeight = 700;
        Scene gameField = new Scene(root, sceneWidth, sceneHeight);
        gameField.setFill(Color.BLACK);
        return gameField;
    }

    public void moveAliens() {
        alienMovement.movement(alienCreator.getAliens(), defeatManager, timer);
    }

    public void playerFireBullet() {
        playerBulletCreator.addPlayerBullet(player);
    }

    public void playerMoveBullets() {
        playerBulletMover.movePlayerBullets(root);
    }

    public void alienFireBullet() {
        alienBulletCreator.addAlienBullet();
    }

    public void alienMoveBullets() {
        alienBulletMover.moveAlienBullets(root);
    }

    public void playerBulletCheck() {
        playerBulletCollisionChecker.checkPlayerBullets(root, scoreManager, victoryManager, timer);
    }

    public void alienBulletCheck() {
        alienBulletCollisionChecker.checkAlienBullets(root, livesManager,defeatManager,timer);
    }
}

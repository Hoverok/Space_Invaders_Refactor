package Bullets;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet {

    private double layoutX, layoutY;
    private Circle bulletAvatar;

    public Bullet(double x, double y) {
        layoutX = x;
        layoutY = y;
        bulletAvatar = createBulletAvatar();
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

    public Circle createBulletAvatar() {
        Circle bullet = new Circle();
        bullet.setFill(Color.RED);
        bullet.setLayoutX(layoutX);
        bullet.setLayoutY(layoutY);
        bullet.setRadius(3);
        return bullet;
    }

    public void updateBulletAvatar() {
        bulletAvatar.setLayoutX(layoutX);
        bulletAvatar.setLayoutY(layoutY);
    }

    public Circle getBulletAvatar() {
        return bulletAvatar;
    }
}

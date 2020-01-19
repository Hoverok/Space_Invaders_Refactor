package Movement;

import Player.Player;

public class PlayerMovement {

    double stageXStart, stageXEnd, playerMoveLength;

    public PlayerMovement() {
        stageXStart = 0;
        stageXEnd = 860;
        playerMoveLength = 10;
    }

    //Player player;
    public void movePlayerLeft(Player player) {
        double currentLayoutX = player.getLayoutX();
        double newLayoutX = currentLayoutX - playerMoveLength;
        if (newLayoutX >= stageXStart) {
            player.setLayoutX(currentLayoutX - playerMoveLength);
            player.updatePlayerAvatar();
        }
    }

    public void movePlayerRight(Player player) {
        double currentLayoutX = player.getLayoutX();
        double newLayoutX = currentLayoutX + playerMoveLength;
        if (newLayoutX <= stageXEnd) {
            player.setLayoutX(currentLayoutX + playerMoveLength);
            player.updatePlayerAvatar();
        }
    }
}

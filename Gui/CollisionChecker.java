package Gui;

import Entity.Entity;

public class CollisionChecker {
    
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {

        int entityLeftPlayerX = entity.playerX + entity.solidArea.x;
        int entityRightPlayerX = entity.playerX + entity.solidArea.x + entity.solidArea.width;
        int entityTopPlayerY = entity.playerY + entity.solidArea.y;
        int entityBottomPlayerY = entity.playerY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftPlayerX/gamePanel.TILE_SIZE;
        int entityRightCol = entityRightPlayerX/gamePanel.TILE_SIZE;
        int entityTopRow = entityTopPlayerY/gamePanel.TILE_SIZE;
        int entityBottomRow = entityBottomPlayerY/gamePanel.TILE_SIZE;

        int tile1, tile2;
        
        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopPlayerY - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }
    }
}

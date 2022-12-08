package Gui;

import Gui.Entity.Entity;

public class CollisionChecker {
    
    GamePanel gamePanel;

    /**
     * Constructor for CollisionChecker class.
     * 
     * @param gamePanel the area that displays the farm, crops, and player.
     */
    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * Checks the player collisions with solid tiles. It gets the player's X and Y
     * while drawing the small box inside the player, the small box is then used for the collision
     * computations.
     * 
     * @param entity a movable entity in the gamePanel
     */
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
                tile2 = gamePanel.tileM.mapTileNumber[entityRightCol][entityTopRow];
                if(gamePanel.tileM.tile[tile1].collision == true || gamePanel.tileM.tile[tile2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomPlayerY - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                tile2 = gamePanel.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gamePanel.tileM.tile[tile1].collision == true || gamePanel.tileM.tile[tile2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftPlayerX - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tile2 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                if(gamePanel.tileM.tile[tile1].collision == true || gamePanel.tileM.tile[tile2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightPlayerX - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileM.mapTileNumber[entityRightCol][entityTopRow];
                tile2 = gamePanel.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gamePanel.tileM.tile[tile1].collision == true || gamePanel.tileM.tile[tile2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
}

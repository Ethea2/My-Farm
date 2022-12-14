package Gui.Entity;

import Gui.GamePanel;
import Gui.KeyHandler;
import Gui.Entity.Entity;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GuiPlayer extends Entity{
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    /**
     * Constructor for the GuiPlayer class.
     * 
     * @param gamePanel the main game panel that displays the farm and player.
     * @param keyHandler manages the users keyboard input for movement.
     */
    public GuiPlayer(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }
    
    /**
     * Sets the default values for the player's coordinates, speed, and direction
     * upon the start of the game.
     */
    public void setDefaultValues() {
        playerX = 100;
        playerY = 100;
        speed = 4;
        direction = "down";
    }

    /**
     * Loads the player's image files.
     */
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_up4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_down3.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_down3.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_down4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_left3.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_left3.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_left4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_right3.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_right3.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("../../resources/farmer/farmer_right4.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    /**
     * Updates the player's position and appearance based on
     * the user's movement input.
     */
    public void update() {
        actualX = (this.playerX + this.solidArea.x)/gamePanel.TILE_SIZE;
        actualY = (this.playerY + this.solidArea.y + this.solidArea.height)/gamePanel.TILE_SIZE;
        //System.out.println(String.format("Farmer Location: %d\t%d", actualX, actualY));
        if(keyHandler.upPressed) {
            direction = "up";
        }
        if(keyHandler.downPressed) {
            direction = "down";
        }
        if(keyHandler.leftPressed) {
            direction = "left";
        }
        if(keyHandler.rightPressed) {
            direction = "right";
        }
        if(!keyHandler.pressed && (!keyHandler.leftPressed && !keyHandler.rightPressed && !keyHandler.upPressed && !keyHandler.downPressed)) {
            direction = "standing";
        }

        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);

        if(collisionOn == false) {
            if(direction == "up") {
                this.playerY -= this.speed;
            }
            if(direction == "down") {
                this.playerY += this.speed;
            }
            if(direction == "left") {
                this.playerX -= this.speed;
            }
            if(direction == "right") {
                this.playerX += this.speed;
            }
        }

        spriteCounter++;
        if(spriteCounter > 6) {
            if(spriteNumber == 1) {
                spriteNumber = 2;
            }
            else if(spriteNumber == 2) {
                spriteNumber = 3;
            }
            else if(spriteNumber == 3) {
                spriteNumber = 4;
            }
            else if(spriteNumber == 4) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }

    
    /** 
     * Displays the farmer on the screen depending on his movement and direction.
     * 
     * @param g2 graphics object to be used in the drawing of components.
     */
    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);

        // g2.fillRect(this.x, this.y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNumber == 1) {
                    image = up1;
                }
                if(spriteNumber == 2)  {
                    image = up2;
                }
                if(spriteNumber == 3){
                    image = up3;
                }
                if(spriteNumber == 4){
                    image = up4;
                }
                break;
            case "down":
                if(spriteNumber == 1) {
                    image = down1;
                }
                if(spriteNumber == 2)  {
                    image = down2;
                }
                if(spriteNumber == 3){
                    image = down3;
                }
                if(spriteNumber == 4){
                    image = down4;
                }
                break;
            case "left":
                if(spriteNumber == 1) {
                    image = left1;
                }
                if(spriteNumber == 2)  {
                    image = left2;
                }
                if(spriteNumber == 3){
                    image = left3;
                }
                if(spriteNumber == 4){
                    image = left4;
                }
                break;
            case "right":
                if(spriteNumber == 1) {
                    image = right1;
                }
                if(spriteNumber == 2)  {
                    image = right2;
                }
                if(spriteNumber == 3){
                    image = right3;
                }
                if(spriteNumber == 4){
                    image = right4;
                }
                break;
            case "standing":
                if(spriteNumber == 1) {
                    image = down1;
                }
                if(spriteNumber == 2)  {
                    image = down2;
                }
                if(spriteNumber == 3){
                    image = down3;
                }
                if(spriteNumber == 4){
                    image = down4;
                }
                break;
        }

        g2.drawImage(image, this.playerX, this.playerY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
    }
}

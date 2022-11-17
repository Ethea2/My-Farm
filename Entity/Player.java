package Entity;

import Gui.GamePanel;
import Gui.KeyHandler;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends Entity{
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_up4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_down3.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_down3.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_down4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_left3.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_left3.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_left4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_right3.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_right3.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("../resources/farmer/farmer_right4.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public void update() {
        if(keyHandler.upPressed == true) {
            direction = "up";
            this.y -= this.speed;
        }
        if(keyHandler.downPressed) {
            direction = "down";
            this.y += this.speed;
        }
        if(keyHandler.leftPressed) {
            direction = "left";
            this.x -= this.speed;
        }
        if(keyHandler.rightPressed) {
            direction = "right";
            this.x += this.speed;
        }

        if(keyHandler.pressed) {
            spriteCounter++;
            if(spriteCounter > 5) {
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
        else {
            spriteNumber = 1;
        }
    }

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
        }

        g2.drawImage(image, this.x, this.y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
    }
}

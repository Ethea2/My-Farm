package Gui.Entity;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

/**
 * Parent class for movable entities in the game panel.
 */
public class Entity {
    public int playerX, playerY;
    public int actualX, actualY;
    public int speed;

    public BufferedImage up1, up2, up3, up4, down1, down2, down3, down4, left1, left2, left3, left4, right1, right2, right3, right4;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}
package Gui;

import java.awt.image.BufferedImage;

import javax.swing.Icon;

import java.awt.Component;
import java.awt.Graphics;

public class ButtonIcon implements Icon {
    public BufferedImage image;
    public SidePanel sp;

    /**
     * Constructor for the ButtonIcon class.
     * 
     * @param sp the SidePanel for the gui.
     */
    public ButtonIcon(SidePanel sp) {
        this.sp = sp;
    }

    
    /** 
     * Paints images inside the icon of the button.
     * 
     * @param c the image component.
     * @param g the graphics object.
     * @param x the x coordinate of the image.
     * @param y the y coordinate of the image.
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawImage(image, x, y, c);
    }

    
    /** 
     * A getter function for the Icon Width.
     * 
     * @return int the width of the Icon.
     */
    @Override
    public int getIconWidth() {
        return sp.TILE_SIZE;
    }

    
    /** 
     * A getter function for the Icon's height.
     * 
     * @return int the height of the Icon.
     */
    @Override
    public int getIconHeight() {
        return sp.TILE_SIZE;
    }
}

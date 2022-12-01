package Gui;

import java.awt.image.BufferedImage;

import javax.swing.Icon;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ButtonIcon implements Icon {
    public BufferedImage image;
    public SidePanel sp;

    public ButtonIcon(SidePanel sp) {
        this.sp = sp;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawImage(image, x, y, c);
    }

    @Override
    public int getIconWidth() {
        // TODO Auto-generated method stub
        return sp.TILE_SIZE;
    }

    @Override
    public int getIconHeight() {
        // TODO Auto-generated method stub
        return sp.TILE_SIZE;
    }
}

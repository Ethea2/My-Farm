package Gui;

import java.awt.event.*;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean cTyped;
    public boolean pressed = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTyped(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_C) {
            cTyped = true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        pressed = true;
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        pressed = false;
    }
    
}

package Gui;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {
    GamePanel gamePanel;
    SidePanel sidePanel;
    /*
     * Constructor for the Window class. It also initializes all the window requirements for the JFrame.
     */
    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("ISAGANI'S FARM~");
        this.setLayout(new BorderLayout());

        gamePanel = new GamePanel(this);
        sidePanel = new SidePanel(gamePanel);
        this.add(gamePanel);
        this.add(sidePanel, BorderLayout.EAST);
        
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.playMusic();
        gamePanel.startGameThread();
    }

    public void restartGame() {
        this.remove(gamePanel);
        this.remove(sidePanel);

        gamePanel.stopMusic();

        gamePanel = new GamePanel(this);
        sidePanel = new SidePanel(gamePanel);
        

        this.add(gamePanel);
        this.add(sidePanel, BorderLayout.EAST);
        
        this.pack();


        gamePanel.playMusic();
        gamePanel.startGameThread();
    }
}

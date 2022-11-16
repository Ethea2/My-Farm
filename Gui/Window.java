package Gui;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("My Farm");

        GamePanel gamePanel = new  GamePanel();
        this.add(gamePanel);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.startGameThread();
    }
}

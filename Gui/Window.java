package Gui;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("My Farm");
        this.setLayout(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        this.add(new SidePanel(gamePanel), BorderLayout.EAST);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.startGameThread();
    }
}

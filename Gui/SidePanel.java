package Gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import Player.Tile;

import java.awt.*;
import java.awt.event.*;

public class SidePanel extends JPanel implements ActionListener {
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //48x48

    public final int MAX_SCREEN_COLUMN = 3;
    public final int MAX_SCREEN_ROW = 16;
    public final int SCREEN_WIDTH = MAX_SCREEN_COLUMN * TILE_SIZE;
    public final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;

    GamePanel gamePanel;
    JButton getTile;

    public SidePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(new GridLayout(16, 1));
        this.setBackground(new Color(0x854a01));
        this.setDoubleBuffered(true);
        this.setFocusable(false);
        getTile = new JButton();
        getTile.addActionListener(this);
        this.add(getTile);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getTile) {
            getTile();
        }


        EventQueue.invokeLater(new Runnable() {
            @Override
              public void run() {
                  gamePanel.grabFocus();
                  gamePanel.requestFocus();
              }
         });
    }

    public void getTile() {
        Tile tempTile[][] = gamePanel.farm.getTile();
        Tile tile = null;
        int playerX = gamePanel.player.actualX;
        int playerY = gamePanel.player.actualY;
        for(int i = 0; i < gamePanel.farm.TILE_ROW; i++) {
            for(int j = 0; j < gamePanel.farm.TILE_COL; j++) {
                if(tempTile[i][j].coordinateX == playerX && tempTile[i][j].coordinateY == playerY){
                    tile = gamePanel.farm.getTile()[i][j];
                    break;
                }
            }
        }

        if(tile != null)
            System.out.println(String.format("I am in tile: %d %d", tile.coordinateX, tile.coordinateY));
        else
            System.out.println("Not in a tile");
    }
}

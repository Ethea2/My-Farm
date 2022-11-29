package Gui;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Player.Tile;
import Crop.Flowers.*;
import Crop.RootCrops.Carrot;
import Crop.RootCrops.Potato;
import Crop.RootCrops.Turnip;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class SidePanel extends JPanel implements ActionListener {
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //48x48

    public final int MAX_SCREEN_COLUMN = 3;
    public final int MAX_SCREEN_ROW = 11;
    public final int SCREEN_WIDTH = MAX_SCREEN_COLUMN * TILE_SIZE;
    public final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;

    GamePanel gamePanel;
    JButton pickaxeButton, plowButton, advanceDayButton, buyRoseButton, waterCanButton, shovelButton, fertilizerButton,
    sunflowerButton, tulipButton, carrotButton, potatoButton, turnipButton;
    ButtonIcon buttonImages[];

    public SidePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(0x854a01));
        this.setDoubleBuffered(true);
        this.setFocusable(false);
        buttonImages = new ButtonIcon[10];
        loadImages();

        pickaxeButton = new JButton(buttonImages[0]);
        pickaxeButton.addActionListener(this);
        pickaxeButton.setBounds(0, 1*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        plowButton = new JButton();
        plowButton.addActionListener(this);
        plowButton.setText("Plow");

        advanceDayButton = new JButton();
        advanceDayButton.addActionListener(this);
        advanceDayButton.setText("Advance Day");

        buyRoseButton = new JButton();
        buyRoseButton.addActionListener(this);
        buyRoseButton.setText("Rose");

        waterCanButton = new JButton();
        waterCanButton.addActionListener(this);
        waterCanButton.setText("Water Tile");

        shovelButton = new JButton();
        shovelButton.addActionListener(this);
        shovelButton.setText("Shovel");

        fertilizerButton = new JButton();
        fertilizerButton.addActionListener(this);
        fertilizerButton.setText("Fertilize");
        
        sunflowerButton = new JButton();
        sunflowerButton.addActionListener(this);
        sunflowerButton.setText("Sunflower");

        tulipButton = new JButton();
        tulipButton.addActionListener(this);
        tulipButton.setText("Tulip");

        carrotButton = new JButton();
        carrotButton.addActionListener(this);
        carrotButton.setText("Carrot");

        potatoButton = new JButton();
        potatoButton.addActionListener(this);
        potatoButton.setText("Potato");

        turnipButton = new JButton();
        turnipButton.addActionListener(this);
        turnipButton.setText("Turnip");


        this.add(pickaxeButton);
        this.add(plowButton);
        this.add(advanceDayButton);
        this.add(waterCanButton);
        this.add(shovelButton);
        this.add(fertilizerButton);
        this.add(buyRoseButton);
        this.add(sunflowerButton);
        this.add(tulipButton);
        this.add(carrotButton);
        this.add(potatoButton);
        this.add(turnipButton);
    }

    public void loadImages() {
        try {
            buttonImages[0] = new ButtonIcon(this);
            buttonImages[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/tools/pickaxe.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pickaxeButton) {
            pickaxe();
        }
        else if(e.getSource() == plowButton) {
            plow();
        }
        else if(e.getSource() == advanceDayButton) {
            advanceDay();
        }
        else if(e.getSource() == buyRoseButton) {
            buyRose();
        }
        else if(e.getSource() == waterCanButton) {
            water();
        }
        else if(e.getSource() == shovelButton) {
            shovel();
        }
        else if(e.getSource() == fertilizerButton) {
            fertilize();
        }
        else if(e.getSource() == tulipButton) {
            buyTulip();
        }
        else if(e.getSource() == sunflowerButton) {
            buySunflower();
        }
        else if(e.getSource() == turnipButton) {
            buyTurnip();
        }
        else if(e.getSource() == potatoButton) {
            buyPotato();
        }
        else if(e.getSource() == carrotButton) {
            buyCarrot();
        }


        EventQueue.invokeLater(new Runnable() {
            @Override
              public void run() {
                  gamePanel.grabFocus();
                  gamePanel.requestFocus();
              }
         });
    }

    public Tile getTile() {
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
        return tile;
    }

    public void pickaxe() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(2).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());;
    }
    public void plow() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(4).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());;
    }
    public void water() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(1).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());;
    }
    public void shovel() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(0).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());;
    }
    public void fertilize() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(3).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());;
    }

    public void advanceDay() {
        gamePanel.farm.advanceDay();
    }

    public void buyRose() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Rose(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buySunflower() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Sunflower(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buyTulip() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Tulip(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buyCarrot() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Carrot(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buyPotato() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Potato(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buyTurnip() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Turnip(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
}

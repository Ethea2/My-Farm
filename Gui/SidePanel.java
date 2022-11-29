package Gui;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Player.Tile;
import Player.Player;
import Crop.Flowers.*;
import Crop.FruitTrees.*;
import Crop.RootCrops.*;
import Gui.TextAreaOutputStream;

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
    JButton pickaxeButton, plowButton, advanceDayButton, harvestButton, RoseButton, waterCanButton, shovelButton, fertilizerButton,
    sunflowerButton, tulipButton, carrotButton, potatoButton, turnipButton, mangoButton, appleButton, registerButton;
    ButtonIcon buttonImages[];

    public SidePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(0x854a01));
        this.setDoubleBuffered(true);
        this.setFocusable(false);
        buttonImages = new ButtonIcon[20];
        loadImages();

        //TOOLS
        plowButton = new JButton(buttonImages[0]);
        plowButton.addActionListener(this);
        plowButton.setBounds(0*TILE_SIZE, 1*TILE_SIZE, TILE_SIZE, TILE_SIZE);
 
        pickaxeButton = new JButton(buttonImages[1]);
        pickaxeButton.addActionListener(this);
        pickaxeButton.setBounds(0*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        shovelButton = new JButton(buttonImages[2]);
        shovelButton.addActionListener(this);
        shovelButton.setBounds(0*TILE_SIZE, 3*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        waterCanButton = new JButton(buttonImages[3]);
        waterCanButton.addActionListener(this);
        waterCanButton.setBounds(0*TILE_SIZE, 4*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        fertilizerButton = new JButton(buttonImages[4]);
        fertilizerButton.addActionListener(this);
        fertilizerButton.setBounds(0*TILE_SIZE, 5*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        //ACTIONS
        advanceDayButton = new JButton(buttonImages[5]);
        advanceDayButton.addActionListener(this);
        advanceDayButton.setBounds(0*TILE_SIZE, 6*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        harvestButton = new JButton(buttonImages[6]);
        harvestButton.addActionListener(this);
        harvestButton.setBounds(0*TILE_SIZE, 7*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        //BUY SEEDS
        turnipButton = new JButton(buttonImages[7]);
        turnipButton.addActionListener(this);
        turnipButton.setBounds(1*TILE_SIZE, 4*TILE_SIZE, TILE_SIZE, TILE_SIZE);
        
        carrotButton = new JButton(buttonImages[8]);
        carrotButton.addActionListener(this);
        carrotButton.setBounds(2*TILE_SIZE, 4*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        potatoButton = new JButton(buttonImages[9]);
        potatoButton.addActionListener(this);
        potatoButton.setBounds(1*TILE_SIZE, 5*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        RoseButton = new JButton(buttonImages[10]);
        RoseButton.addActionListener(this);
        RoseButton.setBounds(2*TILE_SIZE, 5*TILE_SIZE, TILE_SIZE, TILE_SIZE);
        
        tulipButton = new JButton(buttonImages[11]);
        tulipButton.addActionListener(this);
        tulipButton.setBounds(1*TILE_SIZE, 6*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        sunflowerButton = new JButton(buttonImages[12]);
        sunflowerButton.addActionListener(this);
        sunflowerButton.setBounds(2*TILE_SIZE, 6*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        mangoButton = new JButton(buttonImages[13]);
        mangoButton.addActionListener(this);
        mangoButton.setBounds(1*TILE_SIZE, 7*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        appleButton = new JButton(buttonImages[14]);
        appleButton.addActionListener(this);
        appleButton.setBounds(2*TILE_SIZE, 7*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        registerButton = new JButton(buttonImages[15]);
        registerButton.addActionListener(this);
        registerButton.setBounds(TILE_SIZE, 8*TILE_SIZE, 3*TILE_SIZE, TILE_SIZE);

        this.add(pickaxeButton);
        this.add(plowButton);
        this.add(advanceDayButton);
        this.add(harvestButton);
        this.add(waterCanButton);
        this.add(shovelButton);
        this.add(fertilizerButton);
        this.add(RoseButton);
        this.add(sunflowerButton);
        this.add(tulipButton);
        this.add(carrotButton);
        this.add(potatoButton);
        this.add(turnipButton);
        this.add(mangoButton);
        this.add(appleButton);
        this.add(registerButton);
    }

    public void loadImages() {
        try {
            //TOOLS
            buttonImages[0] = new ButtonIcon(this);
            buttonImages[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/plow.png"));

            buttonImages[1] = new ButtonIcon(this);
            buttonImages[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/pickaxe.png"));

            buttonImages[2] = new ButtonIcon(this);
            buttonImages[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/shovel.png"));

            buttonImages[3] = new ButtonIcon(this);
            buttonImages[3].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/wateringcan.png"));

            buttonImages[4] = new ButtonIcon(this);
            buttonImages[4].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/fertilizer.png"));

            //ACTIONS
            buttonImages[5] = new ButtonIcon(this);
            buttonImages[5].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/advance.png"));
        
            buttonImages[6] = new ButtonIcon(this);
            buttonImages[6].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/harvest.png"));

            //BUY SEEDS
            buttonImages[7] = new ButtonIcon(this);
            buttonImages[7].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_turnip.png"));

            buttonImages[8] = new ButtonIcon(this);
            buttonImages[8].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_carrot.png"));

            buttonImages[9] = new ButtonIcon(this);
            buttonImages[9].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_potato.png"));

            buttonImages[10] = new ButtonIcon(this);
            buttonImages[10].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_rose.png"));

            buttonImages[11] = new ButtonIcon(this);
            buttonImages[11].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_tulip.png"));

            buttonImages[12] = new ButtonIcon(this);
            buttonImages[12].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_sunflower.png"));

            buttonImages[13] = new ButtonIcon(this);
            buttonImages[13].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_mango.png"));

            buttonImages[14] = new ButtonIcon(this);
            buttonImages[14].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/gui_apple.png"));

            //REGISTER
            buttonImages[15] = new ButtonIcon(this);
            buttonImages[15].image = ImageIO.read(getClass().getResourceAsStream("/resources/gui/register.png"));
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
        else if(e.getSource() == harvestButton) {
            harvest();
        }
        else if(e.getSource() == RoseButton) {
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
        else if(e.getSource() == mangoButton) {
            buyMango();
        }
        else if(e.getSource() == appleButton) {
            buyApple();
        }
        /*
        else if(e.getSource() == registerButton) {
            register();
        }
        */


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

    //TOOLS
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

    //ACTIONS
    public void advanceDay() {
        gamePanel.farm.advanceDay();
    }
    public void harvest() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().harvestTile(getTile(), gamePanel.farm.getCurrentDay());
    }

    //BUY SEEDS
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
    public void buyMango() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Mango(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buyApple() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Apple(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }

    //REGISTER
    /*
    public void Register() {
        if(getTile() != null)
        gamePanel.farm.getPlayer().register(ABORT););
    }
    */
}

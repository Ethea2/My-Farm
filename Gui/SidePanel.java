package Gui;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Player.Tile;
import Player.Player;
import Crop.Flowers.*;
import Crop.FruitTrees.*;
import Crop.RootCrops.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class SidePanel extends JPanel implements ActionListener {
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //48x48

    public final int MAX_SCREEN_COLUMN = 3;
    public final int MAX_SCREEN_ROW = 11;
    public final int SCREEN_WIDTH = MAX_SCREEN_COLUMN * TILE_SIZE;
    public final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;
    
    public final int SPACE = 5;
    public final float COIN_FONT_SIZE = 18f;
    public final float INFO_FONT_SIZE = 14f;
    public final float TYPE_FONT_SIZE = 12f;

    private final DecimalFormat df1 = new DecimalFormat("0.0");
    private final DecimalFormat df2 = new DecimalFormat("0.00");

    GamePanel gamePanel;
    JButton pickaxeButton, plowButton, advanceDayButton, harvestButton, RoseButton, waterCanButton, shovelButton, fertilizerButton,
    sunflowerButton, tulipButton, carrotButton, potatoButton, turnipButton, mangoButton, appleButton, registerButton;
    JLabel coinsBackground, dayBackground, expBackground, lvlBackground, farmerTypeBackground, logBackground;
    JLabel coinsText, dayText, expText, typeText, lvlText;
    ButtonIcon buttonImages[];
    BufferedImage registerImage, coinsBG, dayBG, expBG, lvlBG, logBG;
    Font font;
    Mango tMango;
    Tile tTile;

    public SidePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(0x854a01));
        this.setDoubleBuffered(true);
        this.setFocusable(false);
        buttonImages = new ButtonIcon[20];
        loadImages();
        loadFont();

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

        registerButton = new JButton(new ImageIcon(registerImage));
        registerButton.addActionListener(this);
        registerButton.setBounds(0, 8*TILE_SIZE, 3*TILE_SIZE, TILE_SIZE);

        //INFO
        coinsText = new JLabel();
        //double coins = Math.round((gamePanel.farm.getPlayer().getObjectcoins())*100)/100;
        double coins = gamePanel.farm.getPlayer().getObjectcoins();
        coinsText.setText(String.format("%s", df2.format(coins)));
        coinsText.setBounds(1*TILE_SIZE + SPACE, 0, 3*TILE_SIZE, TILE_SIZE);
        coinsText.setFont(font.deriveFont(Font.BOLD, COIN_FONT_SIZE));

        coinsBackground = new JLabel(new ImageIcon(coinsBG));
        coinsBackground.setBounds(0, 0, 3*TILE_SIZE, TILE_SIZE);

        dayText = new JLabel();
        dayText.setText(String.format("%s", gamePanel.farm.getCurrentDay()));
        dayText.setBounds(2*TILE_SIZE + SPACE, 1*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE);
        dayText.setFont(font.deriveFont(Font.BOLD, INFO_FONT_SIZE));

        dayBackground = new JLabel(new ImageIcon(dayBG));
        dayBackground.setBounds(1*TILE_SIZE, 1*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE);
        
        lvlText = new JLabel();
        lvlText.setText(String.format("%s", gamePanel.farm.getPlayer().getLevel()));
        lvlText.setBounds(2*TILE_SIZE + SPACE, 2*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE);
        lvlText.setFont(font.deriveFont(Font.BOLD, INFO_FONT_SIZE));

        lvlBackground = new JLabel(new ImageIcon(lvlBG));
        lvlBackground.setBounds(1*TILE_SIZE, 2*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE);

        expText = new JLabel();
        expText.setText(String.format("%s", df1.format(gamePanel.farm.getPlayer().getExperience())));
        expText.setBounds(2*TILE_SIZE + SPACE, 3*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE);
        expText.setFont(font.deriveFont(Font.BOLD, INFO_FONT_SIZE));

        typeText = new JLabel();
        typeText.setText(String.format("%s", gamePanel.farm.getPlayer().getFarmerType().getFarmerType()));
        typeText.setBounds(2*SPACE, 9*TILE_SIZE, 3*TILE_SIZE, TILE_SIZE);
        typeText.setFont(font.deriveFont(Font.BOLD, TYPE_FONT_SIZE));

        expBackground = new JLabel(new ImageIcon(expBG));
        expBackground.setBounds(1*TILE_SIZE, 3*TILE_SIZE, 2*TILE_SIZE, TILE_SIZE);
        
        logBackground = new JLabel(new ImageIcon(logBG));
        logBackground.setBounds(0, 9*TILE_SIZE, 3*TILE_SIZE, TILE_SIZE);

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
        this.add(coinsText);
        this.add(coinsBackground);
        this.add(dayText);
        this.add(dayBackground);
        this.add(lvlText);
        this.add(lvlBackground);
        this.add(expText);
        this.add(typeText);
        this.add(expBackground);
        this.add(logBackground);
    }

    public void loadFont() {
        try {
            InputStream is = getClass().getResourceAsStream("/resources/font/NineteenNinetyThree-L1Ay.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

            registerImage = ImageIO.read(getClass().getResourceAsStream("/resources/gui/register.png"));
            coinsBG = ImageIO.read(getClass().getResourceAsStream("/resources/gui/coins.png"));
            dayBG = ImageIO.read(getClass().getResourceAsStream("/resources/gui/day.png"));
            lvlBG = ImageIO.read(getClass().getResourceAsStream("/resources/gui/lvl.png"));
            expBG = ImageIO.read(getClass().getResourceAsStream("/resources/gui/exp.png"));
            logBG = ImageIO.read(getClass().getResourceAsStream("/resources/gui/log.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pickaxeButton) {
            pickaxe();
            updateText();
        }
        else if(e.getSource() == plowButton) {
            plow();
            updateText();
        }
        else if(e.getSource() == advanceDayButton) {
            advanceDay();
            updateText();
        }
        else if(e.getSource() == harvestButton) {
            harvest();
            updateText();
        }
        else if(e.getSource() == RoseButton) {
            buyRose();
            updateText();
        }
        else if(e.getSource() == waterCanButton) {
            water();
            updateText();
        }
        else if(e.getSource() == shovelButton) {
            shovel();
            updateText();
        }
        else if(e.getSource() == fertilizerButton) {
            fertilize();
            updateText();
        }
        else if(e.getSource() == tulipButton) {
            buyTulip();
            updateText();
        }
        else if(e.getSource() == sunflowerButton) {
            buySunflower();
            updateText();
        }
        else if(e.getSource() == turnipButton) {
            buyTurnip();
            updateText();
        }
        else if(e.getSource() == potatoButton) {
            buyPotato();
            updateText();
        }
        else if(e.getSource() == carrotButton) {
            buyCarrot();
            updateText();
        }
        else if(e.getSource() == mangoButton) {
            buyMango();
            updateText();
        }
        else if(e.getSource() == appleButton) {
            buyApple();
            updateText();
        }
        else if(e.getSource() == registerButton) {
            register();
            updateText();
        }


        EventQueue.invokeLater(new Runnable() {
            @Override
              public void run() {
                  gamePanel.grabFocus();
                  gamePanel.requestFocus();
              }
         });
    }

    public void updateText() {
        coinsText.setText(String.format("%s", gamePanel.farm.getPlayer().getObjectcoins()));
        dayText.setText(String.format("%s", gamePanel.farm.getCurrentDay()));
        lvlText.setText(String.format("%s", gamePanel.farm.getPlayer().getLevel()));
        expText.setText(String.format("%s", gamePanel.farm.getPlayer().getExperience()));
        typeText.setText(String.format("%s", gamePanel.farm.getPlayer().getFarmerType().getFarmerType()));
        //showFarmerType();
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
            gamePanel.farm.getPlayer().getTool(2).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());
    }
    public void plow() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(4).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());
    }
    public void water() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(1).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());
    }
    public void shovel() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(0).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());
    }
    public void fertilize() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().getTool(3).useTool(getTile(), gamePanel.farm.getPlayer(), gamePanel.farm.getCurrentDay());
    }

    //ACTIONS
    public void advanceDay() {
        gamePanel.farm.advanceDay();
        if(gamePanel.farm.checkGameOver()) {
            String[] options = {"Yes", "No"};
            int response = JOptionPane.showOptionDialog(null, "You lose...\nDo you want to play again?", "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if(response == 0) {
                gamePanel.restartGame();
            }
            else {
                System.exit(1);
            }
        }
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
        if(getTile() != null )
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Mango(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }
    public void buyApple() {
        if(getTile() != null)
            gamePanel.farm.getPlayer().buySeed(getTile(), gamePanel.farm.getCurrentDay(), new Apple(gamePanel.farm.getCurrentDay()), gamePanel.farm);
    }

    //REGISTER
    public void register() {
        gamePanel.farm.getPlayer().register();
    }
}

package Gui;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Gui.Entity.GuiPlayer;
import Player.MyFarm;

public class GamePanel extends JPanel implements Runnable {
    // pixel computations
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48

    public final int MAX_SCREEN_COLUMN = 16;
    public final int MAX_SCREEN_ROW = 11;
    public final int SCREEN_WIDTH = MAX_SCREEN_COLUMN * TILE_SIZE;
    public final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;

    public final int SOIL_TILES_ROW = 5;
    public final int SOIL_TILES_COLUMN = 10;

    int FPS = 60;

    // initialization of gui classes
    public MyFarm farm = new MyFarm();
    TileManager tileM = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Sound sound = new Sound();
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public GuiPlayer player = new GuiPlayer(this, keyHandler);
    Window window;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel(Window window) {
        this.window = window;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    /**
     * Initializes the gamethread for the game.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * The function that triggers the game loop. It also computes for the FPS
     * of the game making it smoother looking.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Updates the player position and animations.
     */
    public void update() {
        player.update();
        if(keyHandler.cTyped && (farm.getTile()[player.actualX][player.actualY] != null)){
            farm.getTile()[player.actualX][player.actualY].printTileInfo(farm.getCurrentDay());
        }
    }

    
    /** 
     * Paints all the images in the screen.
     * 
     * @param g graphics object to be used in the drawing of components.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        for (int i = 0; i < SOIL_TILES_ROW; i++) {
            for (int j = 0; j < SOIL_TILES_COLUMN; j++) {
                farm.getTile()[i][j].draw(g2, this);
            }
        }

        player.draw(g2);

        g2.dispose();
    }

    /**
     * Plays the music for the game and loops it.
     */
    public void playMusic() {
        sound.setFile();
        sound.play();
        sound.loop();
    }

    /**
     * Stops the music.
     */
    public void stopMusic() {
        sound.stop();
    }
    
    /**
     * Restarts the game and reopens the frame. Resets the stats and stops the music.
     */
    public void restartGame() {
        farm.gameReset();
        window.restartGame();
    }
}

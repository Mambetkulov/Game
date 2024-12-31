import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 30;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    int fps = 60;

    TileManager tileM = new TileManager(this);
    Keyb key = new Keyb();
    Sound sound = new Sound();

    CollisionChecker cChecker = new CollisionChecker(this);
    AssetSetter aSetter = new AssetSetter(this);
    Thread threadGame;
    Player player = new Player(this, key);
    public SuperObject[] obj = new SuperObject[10];


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setObject();

        playMusic(0);


    }

    public void startGameThread() {
        threadGame = new Thread(this);
        threadGame.start();
    }

    @Override
    public void run() {

        double interval = (double) 1000000000 / fps;
        double nextdrawTime = System.nanoTime() + interval;

        while (threadGame != null) {
            update();
            repaint();
            try {
                double remainTime = nextdrawTime - System.nanoTime();
                remainTime = remainTime / 1000000;
                if (remainTime < 0) {
                    remainTime = 0;
                }
                Thread.sleep((long) remainTime);
                nextdrawTime += interval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        player.draw(g2);

        g2.dispose();
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSe(int i) {
        sound.setFile(i);
        sound.play();
    }
}

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public  final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int maxMap = 10;
    public int currentMap = 0;


    int fps = 60;

    TileManager tileM = new TileManager(this);
    Keyb key = new Keyb(this);
    Sound music = new Sound();
    Sound sf = new Sound();

    CollisionChecker cChecker = new CollisionChecker(this);
    AssetSetter aSetter = new AssetSetter(this);
    UI ui = new UI(this);
    Thread threadGame;
    Player player = new Player(this,key);
    public SuperObject obj[] =  new SuperObject[10];

    public int gameState;
    public final int titleState =0;
    public final int playState = 1;
    public final int pauseState = 2;

    public static GameClient socketClient;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);

    }

    public void setupGame(){
        aSetter.setObject();
        playMusic(2);
        gameState = titleState;




    }

    public void startGameThread ( ){
        threadGame = new Thread(this);
        threadGame.start();
        if(JOptionPane.showConfirmDialog(this,"do you want to run the server") == 0){
            GameServer socketServer = new GameServer(this);
           socketServer.start();
        }
        socketClient = new GameClient(this,"localhost");
        socketClient.start();

    }

    @Override
    public void run() {

        double interval = (double) 1000000000 /fps;
        double nextdrawTime = System.nanoTime() + interval;


        while(threadGame != null){



            update();

            repaint();


            try {
                double remainTime = nextdrawTime - System.nanoTime();
                remainTime = remainTime/1000000;
                if(remainTime<0){
                    remainTime = 0;
                }
                Thread.sleep((long) remainTime);
                nextdrawTime += interval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void update (){
        if(gameState == playState){
            player.update();
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        long drawStart = 0;
        if(key.checkDrawTime ){
            drawStart = System.nanoTime();
        }

        if(gameState == titleState){
         ui.draw(g2);
        }else{
            tileM.draw(g2);

            for(int i = 0; i<obj.length ; i++){
                if(obj[i] != null){
                    obj[i].draw(g2,this);
                }
            }

            player.draw(g2);

            ui.draw(g2);

        }



        if(key.checkDrawTime){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.WHITE);
            g2.drawString("Draw time: " + passed,10,400);
            System.out.println("Draw time : " + passed);
        }



        g2.dispose();
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSe(int i){
        sf.setFile(i);
        sf.play();
    }
}

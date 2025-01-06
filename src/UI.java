import java.awt.*;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40,arial_80B;


    public boolean messageOn = false;
    public String message = " ";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Comic Sans MS",Font.PLAIN,40);
        arial_80B = new Font("Comic Sans MS",Font.BOLD,80);


    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
    this.g2 = g2;
    g2.setFont(arial_40);
    g2.setColor(Color.WHITE);

    if(gp.gameState == gp.titleState){
        drawTitleScreen();
    }

    if(gp.gameState == gp.playState){

    }if(gp.gameState == gp.pauseState){
          drawPauseScreen();
        }

    }

    public void drawTitleScreen(){
        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
   g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
   String text = "Hero";
   int x = getXforCenter(text);
   int y = gp.tileSize*3;

   g2.setColor(Color.black);
   g2.drawString(text,x+5,y+5);

   g2.setColor(Color.WHITE);
   g2.drawString(text ,x,y);

   x = gp.screenWidth/2 - (gp.tileSize*2)/2;
   y += gp.tileSize * 2;
   g2.drawImage(gp.player.down1 , x,y,gp.tileSize * 2 ,gp.tileSize * 2,null);

   // menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));

        text = "NEW GAME";
        x = getXforCenter(text);
        y += gp.tileSize* 3;

        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.WHITE);
        g2.drawString(text,x ,y);
        if(commandNum == 0){

            g2.drawString(">", x - gp.tileSize,y);

        }

        text = "LOAD GAME";
        x = getXforCenter(text);
        y += gp.tileSize;

        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.WHITE);
        g2.drawString(text,x ,y);
        if(commandNum == 1){
            g2.drawString(">", x - gp.tileSize,y);
        }

        text = "QUIT";
        x = getXforCenter(text);
        y += gp.tileSize;

        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.WHITE);
        g2.drawString(text,x ,y);

        if(commandNum == 2){

            g2.drawString(">", x - gp.tileSize,y);

        }
    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXforCenter(text);

        int y = gp.screenHeight/2;

        g2.drawString(text,x,y);
    }

    public int getXforCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
         int x = gp.screenWidth /2 - length/2;
        return x;
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40,arial_80B;

    BufferedImage heart_full,heart_half,heart_blank;
    public boolean messageOn = false;
    public String message = " ";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;
    public String currentDialogue = "";


    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Comic Sans MS",Font.PLAIN,40);
        arial_80B = new Font("Comic Sans MS",Font.BOLD,80);

        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image3;
        heart_half = heart.image2;
        heart_blank = heart.image;

    }



    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
    this.g2 = g2;
    g2.setFont(arial_40);
    g2.setColor(Color.WHITE);



        //play state
    if(gp.gameState == gp.titleState){
        drawTitleScreen();
    }

    if(gp.gameState == gp.playState){
        drawPlayerLife();

    }if(gp.gameState == gp.pauseState){
          drawPauseScreen();
        }
     // dialogue state
    if(gp.gameState == gp.dialogueState){
        drawDialogueScreen();
    }

    }

    public void drawPlayerLife(){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        while (i < gp.player.maxLife/2){
            g2.drawImage(heart_blank,x,y,null);
            i ++;
            x += gp.tileSize;
        }
  // reset
         x = gp.tileSize/2;
         y = gp.tileSize/2;
         i = 0;

         while(i < gp.player.life){
             g2.drawImage(heart_half,x,y,null);
             i ++;
             if(i < gp.player.life){
                 g2.drawImage(heart_full,x,y,null);
             }
             i++;
             x += gp.tileSize;
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

    public void drawDialogueScreen(){

        //window
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize*4;

        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")){
            g2.drawString(line,x,y);
            y += 40;
        }

    }

    public void drawSubWindow(int x,int y,int width,int height){


        Color c = new Color(0,0,0,220);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);

    }

    public int getXforCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
         int x = gp.screenWidth /2 - length/2;
        return x;
    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    Keyb keyh;

    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    int haskey = 0;

    public Player(GamePanel gp, Keyb keyh){
        super(gp);

        this.gp = gp;
        this.keyh = keyh;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8,16,32,32);
        solidAreaDefaultX = solidArea.x;
        SolidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 5;
        direction = "up";
        // player status
        maxLife = 6;
        life = maxLife;
    }

    public void getPlayerImage(){

        up1 = setup("/spriteRes/char11");
        up2 = setup("/spriteRes/char9");
        down1 = setup("/spriteRes/char12");
        down2 = setup("/spriteRes/char2");
        left1 = setup("/spriteRes/char4");
        left2 = setup("/spriteRes/char3");
        right1 = setup("/spriteRes/char7");
        right2 = setup("/spriteRes/char6");
    }



    public void update(){
        if(keyh.upPressed || keyh.downPressed || keyh.leftPressed || keyh.rightPressed){
            if(keyh.upPressed){
                direction = "up";
            }else if (keyh.downPressed){
                direction = "down";
            }else if (keyh.leftPressed){
                direction = "left";
            }else if (keyh.rightPressed){
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            //check npc collision
            int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
            interactNPC(npcIndex);

            int objIndex =  gp.cChecker.checkObject(this,true);
            pickObject(objIndex);
            if(!collisionOn){
                switch(direction){
                    case "up" : {
                        worldY -= speed;
                        break;
                    } case "down":{
                        worldY += speed;
                        break;
                    } case "left" :{
                        worldX -= speed;
                        break;
                    } case "right" :{
                        worldX += speed;
                        break;
                    }
                }
            }
            spriteCounter ++;
            if(spriteCounter > 12){
                if(spriteNum ==1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }


    }
    public void pickObject(int index){
        if(index != 999){
            String objectName = gp.obj[index].name;

            switch (objectName){
                case "key":{
                    gp.playSe(1);
                    haskey ++;
                    gp.obj[index] = null;
                    break;
                }
                case "Door":{
                    if(haskey > 0){
                        gp.obj[index] = null;
                        haskey--;
                    }
                    break;
                }
                case "chest", "tent","axe":{
                    gp.playSe(1);
                    gp.obj[index] = null;
                    break;
                }
            }
        }
    }

    public void  interactNPC(int i){
        if(i != 999){
            if(gp.key.enterPressed == true){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.key.enterPressed = false;
    }


    public void draw (Graphics2D g2){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right" :
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image,screenX,screenY,null);
    }
}

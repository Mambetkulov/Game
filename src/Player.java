import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    Keyb keyh;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, Keyb keyh){
        this.gp = gp;
        this.keyh = keyh;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/rogier4.gif"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/cowboyshoot.gif"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left.gif"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyh.upPressed == true || keyh.downPressed == true
                || keyh.leftPressed == true|| keyh.rightPressed == true){
            if(keyh.upPressed){
                direction = "up";
                worldY -= speed;

            }else if (keyh.downPressed){
                direction = "down";
                worldY += speed;
            }else if (keyh.leftPressed){
                direction = "left";
                worldX -= speed;
            }else if (keyh.rightPressed){
                direction = "right";
                worldX += speed;
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

    public void draw (Graphics2D g2){
//      g2.setColor(Color.GREEN);
//      g2.fillRect(x,y,gp.tileSize,gp.tileSize);
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
                if(spriteNum == 2){
                    image = right2;
                }
                break;

        }

        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }

}

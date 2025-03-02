import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyb  implements KeyListener {
    GamePanel gp;
    boolean isTrue = false;
    public boolean upPressed , downPressed,leftPressed , rightPressed , enterPressed;
    boolean  checkDrawTime = false;

    public Keyb (GamePanel gp){
        this.gp = gp;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(gp.gameState == gp.playState){
            //title state
            if(gp.gameState == gp.titleState){
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum --;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
                }

                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.ui.commandNum == 0){
                        gp.stopMusic();
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }
                    if(gp.ui.commandNum == 1){
                        // later
                    }
                    if(gp.ui.commandNum == 2){
                        System.exit(0);
                    }
                }
            }
            //strelka
            if (code == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }

            //knopka
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P){
                gp.gameState = gp.pauseState;

            }
            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;

            }


            // debug
            if(code == KeyEvent.VK_T){
                if(!checkDrawTime){
                    checkDrawTime = true;
                }else if(checkDrawTime ){
                    checkDrawTime = false;
                }
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.stopMusic();
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
            if(gp.ui.commandNum == 1){
                // later
            }
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }
        }
         else if(gp.gameState == gp.pauseState){
              if(code == KeyEvent.VK_P){
                  gp.gameState = gp.playState;

              }
          }
         else if(gp.gameState == gp.dialogueState){
             if(code == KeyEvent.VK_ENTER){
                 gp.gameState = gp.playState;
             }
          }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        //strelka
        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        //knopka
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

    }
}

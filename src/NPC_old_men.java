import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_old_men  extends Entity{

    public NPC_old_men(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 1;

    }

    public void getPlayerImage(){
        try{

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char11.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char9.png")));

            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char12.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char2.png")));

            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char4.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char3.png")));

            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char7.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/spriteRes/char6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

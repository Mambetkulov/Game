import javax.imageio.ImageIO;
import java.io.IOException;

public class Tent extends SuperObject{

    public Tent(GamePanel gp){
        name = "tent";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objres/tent.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

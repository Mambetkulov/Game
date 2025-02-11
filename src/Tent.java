import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Tent extends SuperObject{

    public Tent(GamePanel gp){
        name = "tent";
        try{

            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/tent.png")));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

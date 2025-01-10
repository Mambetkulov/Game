import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Axe  extends SuperObject{

    public Axe(GamePanel gp){
        name = "axe";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/axe.png")));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

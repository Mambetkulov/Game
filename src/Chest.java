import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Chest extends  SuperObject{

    public Chest(GamePanel gp){
        name = "chest";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/chest.png")));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

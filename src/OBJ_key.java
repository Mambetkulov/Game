import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;


public class OBJ_key extends SuperObject{

    public OBJ_key(GamePanel gp){
        name = "key";

        try{

            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/key.png")));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            System.out.println(" ");
        }
    }
}

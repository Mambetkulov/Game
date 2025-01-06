import javax.imageio.ImageIO;
import java.io.IOException;


public class OBJ_key extends SuperObject{

    public OBJ_key(GamePanel gp){
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objres/key.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            System.out.println(" ");
        }
    }
}

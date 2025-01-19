import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Heart extends SuperObject{

    public OBJ_Heart(GamePanel gp){
        name = "Heart";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/heart_blank.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/heart_half.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/heart_full.png")));
            image = uTool.scaleImage(image,gp.tileSize,gp.tileSize);
            image2 = uTool.scaleImage(image2,gp.tileSize,gp.tileSize);
            image3 = uTool.scaleImage(image3,gp.tileSize,gp.tileSize);
        } catch (IOException e) {
            System.out.println(" " + e.getMessage());
        }
    }
}

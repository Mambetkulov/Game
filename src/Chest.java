import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends  SuperObject{

    public Chest(){
        name = "chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objres/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

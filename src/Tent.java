import javax.imageio.ImageIO;
import java.io.IOException;

public class Tent extends SuperObject{

    public Tent(){
        name = "Tent";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objres/tent.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

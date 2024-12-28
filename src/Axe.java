import javax.imageio.ImageIO;
import java.io.IOException;

public class Axe  extends SuperObject{

    public Axe(){
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objres/axe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

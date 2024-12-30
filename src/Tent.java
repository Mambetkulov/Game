import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Tent extends SuperObject{

    public Tent(){
        name = "tent";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/tent.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

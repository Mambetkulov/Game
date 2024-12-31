import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Axe  extends SuperObject{

    public Axe(){
        name = "axe";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/axe.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

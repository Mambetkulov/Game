import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_key extends SuperObject{

    public OBJ_key(){
        name = "key";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objres/key.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

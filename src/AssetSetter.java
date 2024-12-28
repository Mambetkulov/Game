public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 21 * gp.tileSize;
        gp.obj[0].worldY = 23 * gp.tileSize;


    }
}

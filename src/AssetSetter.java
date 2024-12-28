public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 30 * gp.tileSize;
        gp.obj[0].worldY = 37 * gp.tileSize;

        gp.obj[1] = new Axe();
        gp.obj[1].worldX = 33 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        gp.obj[2] = new Chest();
        gp.obj[2].worldX = 35 * gp.tileSize;
        gp.obj[2].worldY = 27 * gp.tileSize;

        gp.obj[3] = new Tent();
        gp.obj[3].worldX = 30* gp.tileSize;
        gp.obj[3].worldY = 28 * gp.tileSize;


    }
}

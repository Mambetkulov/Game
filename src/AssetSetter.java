public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 21 * gp.tileSize;
        gp.obj[0].worldY = 23 * gp.tileSize;

        gp.obj[1] = new Chest();
        gp.obj[1].worldX = 12 * gp.tileSize;
        gp.obj[1].worldY = 34 * gp.tileSize;

        gp.obj[2] = new Tent();
        gp.obj[2].worldX = 23 * gp.tileSize;
        gp.obj[2].worldY = 23 * gp.tileSize;

        gp.obj[3] = new Axe();
        gp.obj[3].worldX = 21 * gp.tileSize;
        gp.obj[3].worldY = 9 * gp.tileSize;

    }
}

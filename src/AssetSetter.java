public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_key(gp);
        gp.obj[0].worldX = 21 * gp.tileSize;
        gp.obj[0].worldY = 23 * gp.tileSize;

        gp.obj[1] = new Chest(gp);
        gp.obj[1].worldX = 12 * gp.tileSize;
        gp.obj[1].worldY = 34 * gp.tileSize;

        gp.obj[2] = new Tent(gp);
        gp.obj[2].worldX = 23 * gp.tileSize;
        gp.obj[2].worldY = 23 * gp.tileSize;

        gp.obj[3] = new Axe(gp);
        gp.obj[3].worldX = 21 * gp.tileSize;
        gp.obj[3].worldY = 9 * gp.tileSize;

    }

    public void setNPC(){
        gp.npc[0] = new NPC_old_men(gp);
        gp.npc[0].worldX = gp.tileSize * 24;
        gp.npc[0].worldY = gp.tileSize * 21;
    }
}

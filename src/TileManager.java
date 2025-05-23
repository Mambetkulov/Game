import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp ;
    Tile[] tile;
    int[][][] mapTileNum;


    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile [45];
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01.txt",0);
        loadMap("/maps/interior01.txt",1);
    }



    public void getTileImage () {


        setup(0, "grass", false);
        setup(1, "stone", true);
        setup(2, "water", true);
        setup(3, "flowers", false);
        setup(4, "tree", true);
        setup(5, "road", false);
        setup(40,"stone",true);
        setup(41,"tree",true);
        setup(42,"033",false);
        setup(43,"034",false);
        setup(44,"035",true);


    }
    public void setup(int index , String imageName,boolean collision){
        UtilityTool uTool = new UtilityTool();
        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/" + imageName + ".png")));
            tile[index].image = uTool.scaleImage(tile[index].image,gp.tileSize,gp.tileSize);
            tile[index].collision =  collision;

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap (String filePath,int map){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println(" ");
        }
    }
    public void draw(Graphics2D g2) {
        int wordlCol = 0;
        int worldRow = 0;
        while (wordlCol < gp.maxScreenCol && worldRow < gp.maxScreenRow) {
            g2.drawImage(tile[0].image, gp.maxScreenCol, gp.maxScreenRow, gp.tileSize, gp.tileSize, null);
            wordlCol++;
            wordlCol += gp.tileSize;
            while (wordlCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
                int tileNum = mapTileNum[gp.currentMap][wordlCol][worldRow];
                int worldX = wordlCol * gp.tileSize;
                int worldY = worldRow * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;

                if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                        worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                        worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
                    g2.drawImage(tile[tileNum].image, screenX, screenY,  null);
                wordlCol++;
                if (wordlCol == gp.maxWorldCol) {
                    wordlCol = 0;

                    worldRow++;
                }
            }
        }
    }
}





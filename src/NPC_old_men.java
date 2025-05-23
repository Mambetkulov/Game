import java.util.Random;

public class NPC_old_men  extends Entity{

    public NPC_old_men(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 1;
        getImage();
        setDialougue();

    }

    public void getImage(){

        up1 = setup("/npc/oldman_up_1");
        up2 = setup("/npc/oldman_up_2");
        down1 = setup("/npc/oldman_down_1");
        down2 = setup("/npc/oldman_down_2");
        left1 = setup("/npc/oldman_left_1");
        left2 = setup("/npc/oldman_left_2");
        right1 = setup("/npc/oldman_right_1");
        right2 = setup("/npc/oldman_right_2");
    }

    public void setDialougue(){
        dialogues[0] = "hello bro";
        dialogues[1] = "jigit janagy juktardu oltyr";
        dialogues[2] = "andan kiyn vampirdi oltyr";
        dialogues[3] = "andan son podvalga tush";


    }

    public void setAction(){

        actionLockCounter ++;
        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100) + 1; // pick up number from 1 to 100

            if(i<= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    public void speak(){
        // do the character specific stuff
       super.speak();
    }


}

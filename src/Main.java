import javax.swing.*;

public class Main {
    static JFrame window;

    public static void main(String[] args) {


        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("First Game");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setupGame();

        gamePanel.startGameThread();


    }
}
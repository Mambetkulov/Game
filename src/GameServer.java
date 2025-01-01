import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class GameServer extends Thread {


    private DatagramSocket socket;
    private GamePanel game ;

    public GameServer(GamePanel game ){
        this.game = game;
        try {
            this.socket = new DatagramSocket(1331);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }


    public void run() {
        while (true){
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message = new String(packet.getData());
            System.out.println("SERVER > " + message);
            if(message.equalsIgnoreCase("ping")){
                sendData("pong".getBytes(StandardCharsets.UTF_8),packet.getAddress(),packet.getPort());
            }

        }
    }

    public void sendData (byte[] data ,InetAddress ipAddress,int port ){
        DatagramPacket packet = new DatagramPacket(data , data.length,ipAddress,1331);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

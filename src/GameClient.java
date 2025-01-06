import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public class GameClient extends Thread {

    private InetAddress ipAddress;
    private DatagramSocket socket;
    private GamePanel game ;

    public GameClient(GamePanel game , String ipAddress){
        this.game = game;
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        }catch (UnknownHostException r){
            r.printStackTrace();
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
            System.out.println("SERVER > " + new String(packet.getData()) );
        }
    }

    public void sendData (byte[] data){
        DatagramPacket packet = new DatagramPacket(data , data.length,ipAddress,1331);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

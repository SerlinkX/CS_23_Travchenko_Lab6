import java.net.*;

public class UDPEchoServer {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);

            System.out.println("UDP Echo Server started...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String message = new String(request.getData(), 0, request.getLength());
                System.out.println("Received from client: " + message);

                InetAddress clientAddress = request.getAddress();
                int clientPort = request.getPort();

                DatagramPacket response = new DatagramPacket(request.getData(), request.getLength(), clientAddress, clientPort);
                socket.send(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
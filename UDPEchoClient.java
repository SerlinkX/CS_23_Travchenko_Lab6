import java.net.*;

public class UDPEchoClient {
    private static final String SERVER_IP = "server_ip_address"; // Замініть це на IP-адресу сервера
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
            DatagramSocket socket = new DatagramSocket();

            byte[] buffer = "Hello, server!".getBytes();

            DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverAddress, SERVER_PORT);
            socket.send(request);
            System.out.println("Sent message to server: Hello, server!");

            byte[] responseBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(response);

            String receivedMessage = new String(response.getData(), 0, response.getLength());
            System.out.println("Received from server: " + receivedMessage);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
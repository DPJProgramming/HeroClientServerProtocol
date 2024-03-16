import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 A server that executes the Simple Headquarters Access Protocol.
 */
public class HeroServer
{
    public static void main(String[] args) throws IOException
    {
        final int HEADQUARTERS_LENGTH = 10;
        Headquarters headquarters = new Headquarters(HEADQUARTERS_LENGTH);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for clients to connect...");

        while (true)
        {
            Socket s = server.accept();
            System.out.println("Client connected.");
            HeroService service = new HeroService(s, headquarters);
            Thread t = new Thread(service);
            t.start();
        }
    }
}
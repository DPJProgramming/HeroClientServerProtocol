import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 Executes Simple Headquarters Access Protocol commands
 from a socket.
 */
public class HeroService implements Runnable
{
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Headquarters headquarters;

    /**
     Constructs a service object that processes commands
     from a socket for a headquarters.
     @param aSocket the socket
     @param aHeadquarters the headquarters
     */
    public HeroService(Socket aSocket, Headquarters aHeadquarters)
    {
        s = aSocket;
        headquarters = aHeadquarters;
    }

    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     Executes all commands until the QUIT command or the
     end of input.
     */
    public void doService() throws IOException
    {
        while (true)
        {
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }
        }
    }

    /**
     Executes a single command.
     @param command the command to execute
     */
    public void executeCommand(String command)
    {
        int id = in.nextInt();
        int id2 = in.nextInt();

        if (command.equals("heal"))
        {
            int amount = in.nextInt();
            headquarters.heal(id, amount);
        }
        else if (command.equals("damage"))
        {
            int amount = in.nextInt();
            headquarters.damage(id, amount);
        }
        else if (command.equals("fight"))
        {
            headquarters.fight(id, id2);
        }
//        else if (!command.equals("BALANCE"))
//        {
//            out.println("Invalid command");
//            out.flush();
//            return;
//        }
        //out.println(id + " " + headquarters.getHp(id));
        out.flush();
    }
}
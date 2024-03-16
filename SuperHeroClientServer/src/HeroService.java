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

        if (command.equalsIgnoreCase("heal"))
        {
            int amount = in.nextInt();
            SuperHero hero = headquarters.getHero(id);
            out.println(hero.name + " has " + hero.getHp() + " hp left, " +
                        "but after healing " + amount + " points, " + hero.name + " has " + headquarters.heal(id, amount));
        }
        else if (command.equalsIgnoreCase("damage"))
        {
            int amount = in.nextInt();
            SuperHero hero = headquarters.getHero(id);
            headquarters.damage(id, amount);
            out.println("A villain has attacked " + hero.name + " for " + amount + " damage! " +
                    hero.name + " only has " + headquarters.getHp(id) + " hp left out of " + hero.maxHp);
        }
        else if (command.equalsIgnoreCase("gethp"))
        {
            SuperHero hero = headquarters.getHero(id);
            out.println(hero.name + "'s hp is currently " + headquarters.getHp(id) + " out of " + hero.maxHp);
        }
        else if (command.equalsIgnoreCase("fight"))
        {
            int id2 = in.nextInt();
            SuperHero hero = headquarters.getHero(id);
            SuperHero hero2 = headquarters.getHero(id2);
            headquarters.fight(id, id2);
            out.println(hero.name + " attacks " + hero2.name + ". " +
                    hero.name + " has " + headquarters.getStamina(id) + " stamina left out of " + hero.maxStamina + ", and " +
                    hero2.name + " has " + headquarters.getHp(id2) + " hp left out of " + hero2.maxHp);
        }
        else{
            out.println("Invalid command");
        }
        out.flush();
    }
}
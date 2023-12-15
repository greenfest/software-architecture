import java.util.Collection;
import java.util.Random;

public class Customer{
    private String login;
    private String password;

    private static int counter;

    private final int id;

    private Collection<Ticket> tickets;

    public Customer(String login, String password){
        this.login = login;
        this.password = password;
        this.id = ++counter;
    }

    public Customer()
    {
        this.id = ++counter;
        this.login = generateLogin();
        this.password = generatePassword(6);
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    private String generateLogin(){
        return String.format("user_%d", this.id);
    }

    private String generatePassword(int length){
        Random rand = new Random();
        String retValue = "";
        for (int index = 0; index < length; index++) {
            retValue = String.format("%s%s", retValue, Integer.toString(rand.nextInt(10)));
        }
        return retValue;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
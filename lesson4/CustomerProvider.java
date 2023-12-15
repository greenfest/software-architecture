import java.util.Collection;

public class CustomerProvider{

    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }


    public boolean checkCustomer(String login, String password){
        Collection <Customer> customers = database.getCustomers();
        for (Customer customer : customers) {
            if (customer.getLogin().equals(login) && customer.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(String login, String password){
        Customer retValue = new Customer();
        Collection <Customer> customers = database.getCustomers();

        for (Customer customer : customers) {
            if (customer.getLogin().equals(login) && customer.getPassword().equals(password)){
                return customer;
            }
        }
        return retValue;
    }


}
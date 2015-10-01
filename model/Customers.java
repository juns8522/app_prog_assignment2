package model;

import java.util.*;

public class Customers extends Viewable
{   private LinkedList<Customer> customers = new LinkedList<Customer>();
    
    public Customers()
    {   add(1, "Homer", "doh");
        add(2, "Marge", "mmm");
        add(3, "Bart", "huh");
        add(4, "Lisa", "oh");  }
        
    private void add(int id, String userName, String password)
    {   customers.add(new Customer(id, userName, password));   }
    
    public Customer customer(int id)
    {   for (Customer customer: customers)
            if (customer.has(id))
                return customer;
        return null;    }
    
    public void download(int id, Song song)
    {   customer(id).add(song);
        update();   }
}

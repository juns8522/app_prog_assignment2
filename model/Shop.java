package model;

public class Shop
{   private Customers customers = new Customers();
    private Songs songs = new Songs();
    
    public Customers customers()
    {   return customers;   }
    
    public Songs songs()
    {   return songs;   }
}

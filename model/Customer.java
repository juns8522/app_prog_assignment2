package model;

import java.text.*;
import java.util.*;

public class Customer
{   private int id;
    private String name;
    private Password password;
    private double cash = 100.00;
    private final double charge = 0.10;
    private LinkedList<Song> bought = new LinkedList<Song>();

    public Customer(int id, String name, String password)
    {   this.id = id;
        this.name = name;
        this.password = new Password(password);  }
    
    public boolean has(int id)
    {   return this.id == id;   }
        
    public boolean hasPassword(String word)
    {   return password.matches(word); }
    
    public void add(Song song)
    {   bought.add(song);
        cash -= charge; }
        
    public String name()
    {   return name;    }
    
    public String cash()
    {   return formatted(cash);    }
        
    public LinkedList<Song> songs()
    {   return bought;  }
    
    private String formatted(double value)
    {   DecimalFormat fourD = new DecimalFormat("#0.00");
        return fourD.format(value); }
}

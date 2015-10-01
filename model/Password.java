package model;

public class Password
{   private String password;
        
    public Password(String password)
    {   this.password = password;    }
        
    public boolean matches(String word)
    {   return word.equals(password);  }
}

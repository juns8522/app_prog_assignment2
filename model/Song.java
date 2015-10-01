package model;

import java.util.*;

public class Song
{   private String name;
    private String artist;
    
    public Song(String name, String artist)
    {   this.name = name;
        this.artist = artist;   }
        
    public String name()
    {   return name;    }
    
    public String artist()
    {   return artist;    }
}

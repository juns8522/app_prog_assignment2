package model;

import java.util.*;

public class Songs
{   private LinkedList<Song> songs = new LinkedList<Song>();
    
    public Songs()
    {   add("Lonely Boy", "The Black Keys");
        add("Lonely Girl", "The Blue Keys");
        add("Lonely Snoop Dog", "The Black Keyes");
        add("Hey Hey Hey", "Laurent Wery");
        add("Paradise", "Coldplay");
        add("Nirvana", "Coldplay");
        add("Young & Free", "The Snoop Snap");
        add("Wild & Free", "S& Dog");
        add("Pumped Up Kicks", "Foster The People");  }
        
    private void add(String title, String artist)
    {   songs.add(new Song(title, artist));    }
        
    public Song get(int i)
    {   return songs.get(i);    }
    
    public LinkedList<Song> songs()
    {   return songs;   }
}

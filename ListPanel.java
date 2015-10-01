import model.*;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ListPanel extends JPanel
{   private DefaultListModel model = new DefaultListModel();
    private JList list = new JList(model);
    private LinkedList<Song> songs;
    
    public ListPanel()
    {   setup();
        build();    }
        
    private void setup()
    {   setBorder(BorderFactory.createLineBorder(Color.blue));  }
   
    private void build()
    {   Box box = Box.createHorizontalBox();
        box.setPreferredSize(new Dimension(200,60));
        box.add(scroll());
        add(box);   }
    
    private JScrollPane scroll() 
    {   return new JScrollPane(list);   }
    
    public void clear()
    {   model.clear();  }
    
    public void showSong(Customer customer)
    {   songs = customer.songs(); 
        clear();
        for(int i = 0; i< songs.size(); i++)
            model.addElement(songs.get(i).name());  }
            
    public void addSong(Customer customer)
    {   songs = customer.songs(); 
        if(songs.size() > model.getSize())
            model.addElement(songs.getLast().name()); }
}

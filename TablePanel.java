import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TablePanel extends JPanel
{   private TableModel model;
    private JTable table;
    private LeftPanel leftPanel;
    private Songs songs;
   
    public TablePanel(Songs songs, LeftPanel leftPanel)
    {   this.leftPanel = leftPanel;
        this.songs = songs;
        setup();
        build();    }
        
    private void setup()
    {   model = new TableModel();
        table = new JTable(model); 
        table.getSelectionModel().addListSelectionListener(new RowListener());
        table.setBorder(BorderFactory.createLineBorder(Color.blue));
        TableColumnModel model = table.getColumnModel();
        TableColumn column = model.getColumn(0);
        column.setPreferredWidth(120);
        column = model.getColumn(1);
        column.setPreferredWidth(120);    }
    
    private void build()
    {   Box box = Box.createVerticalBox();
        box.add(table.getTableHeader());
        box.add(table); 
        add(box);   }
        
private class TableModel extends AbstractTableModel
{   private String[] headers = {"Name", "Artist"};
    private int ROWS = songs.songs().size();
    private int COLS = 2;
    private Song[] data = new Song[ROWS];
    
    public TableModel()
    {   int i = 0;
        for(Song song: songs.songs())   
            data[i++] = song;   }
    
    public String getColumnName(int col)
    {   return headers[col];    }
    
    public int getRowCount()
    {   return ROWS;    }
    
    public int getColumnCount()
    {   return COLS;    }
    
    public Object getValueAt(int row, int col)
    {   Song song = data[row];
        switch(col)
        {   case 0: return song.name();
            default: return song.artist();    } 
    }
}

private class RowListener implements ListSelectionListener
{   public void valueChanged(ListSelectionEvent e)
    {   if(e.getValueIsAdjusting())
            return;
        int index = table.getSelectionModel().getLeadSelectionIndex();
        Song song = songs.get(index);
        leftPanel.loginPanel().download(song);  }
}
}

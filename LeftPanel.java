import model.*;

import java.awt.*;
import javax.swing.*;

public class LeftPanel extends JPanel
{   private Customers customers;
    private LoginPanel loginPanel;
        
    public LeftPanel(Customers customers)
    {   this.customers = customers;
        setup();
        build();    }

    private void setup()
    {   setBorder(BorderFactory.createLineBorder(Color.blue));  }
        
    private void build()
    {   ListPanel listPanel = new ListPanel();
        loginPanel = new LoginPanel(customers, listPanel);
        Box box = Box.createVerticalBox();
        box.add(loginPanel);
        box.add(box.createVerticalStrut(10));
        box.add(listPanel);
        add(box);   }
    
    public LoginPanel loginPanel()
    {   return loginPanel;  }
}        

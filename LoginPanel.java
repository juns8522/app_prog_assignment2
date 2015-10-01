import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel implements View
{   private Customers customers;
    private ListPanel listPanel;
    private JTextField id = new JTextField(14);
    private JTextField password = new JTextField(11);
    private JTextField status = new JTextField(15);
    private int inputId;
    private Customer customer;
    
    public LoginPanel(Customers customers, ListPanel listPanel)
    {   this.customers = customers;
        this.listPanel = listPanel;
        customers.attach(this);
        setup();
        build();    }
        
    private void setup()
    {   setBorder(BorderFactory.createLineBorder(Color.blue));  }
    
    private void build()
    {   Box box = Box.createVerticalBox();
        box.add(id());
        box.add(box.createVerticalStrut(10));
        box.add(password());
        box.add(box.createVerticalStrut(10));
        box.add(button());
        box.add(box.createVerticalStrut(10));
        box.add(status);
        add(box);   }
    
    private Box id()
    {   Box box = Box.createHorizontalBox();
        box.add(new JLabel("Id"));
        box.add(box.createHorizontalStrut(5));
        box.add(id);
        return box; }
        
    private Box password()
    {   Box box = Box.createHorizontalBox();
        box.add(new JLabel("Password"));
        box.add(box.createHorizontalStrut(5));
        box.add(password);
        return box; }
        
    private JButton button()
    {   JButton button = new JButton("Find");
        button.addActionListener(new Listener());
        return button;  }
    
    private void warn()
    {   status.setText("Try again");
        status.setForeground(Color.red);  
        listPanel.clear();  }
    
    private void clear()
    {   id.setText("");
        password.setText(""); 
        status.setForeground(Color.black);    }
    
    public void download(Song song)
    {   customers.download(inputId, song);    }
        
    public void update()
    {   status.setText(customer.name() + " has $ " + customer.cash() + " left");
        listPanel.addSong(customer);
        clear();    }
    
private class Listener implements ActionListener
{   public void actionPerformed(ActionEvent e)
    {   inputId = Integer.parseInt(id.getText());
        String inputPassword = password.getText();
        customer = customers.customer(inputId);
        
        if(customer == null || !customer.hasPassword(inputPassword))
            warn(); 
        else
        {   listPanel.showSong(customer);
            update();   }
    }
}
}

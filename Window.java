import model.*;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame
{   private Shop shop;
    public Window(Shop shop)
    {   this.shop = shop;
        setup();
        build();
        pack();
        setVisible(true);   }

    private void setup()
    {   setLocation(0, 500);  }
        
    private void build()
    {   add(new Panel());   }
    
private class Panel extends JPanel
{   public Panel()
    {   setup();
        build();    }

    private void setup()
    {   setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setLayout(new GridLayout(1, 2));    }
        
    private void build()
    {   LeftPanel leftPanel = new LeftPanel(shop.customers());
        Box box = Box.createHorizontalBox();
        box.add(leftPanel);
        box.add(box.createHorizontalStrut(5));
        box.add(new TablePanel(shop.songs(), leftPanel));
        add(box);   }
}
}


package MyDbms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import MyDbms.SQLConnection;

public class StartWindow extends JFrame implements ActionListener
{
    JFrame f1;
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;

    public StartWindow()
    {
        Font myFont=new Font("Arial",Font.BOLD,20);
    
        l1= new JLabel("Select Your option");
        b1 = new JButton("Select");
        b2 = new JButton("Insert");
        b3 = new JButton("Update");
        b4 = new JButton("Delete");
        b5 = new JButton("Joins");
        b6 = new JButton("Other Queries");
        
       
  
        l1.setFont(myFont);
        b1.setFont(myFont);
        b2.setFont(myFont);
        b3.setFont(myFont);
        b4.setFont(myFont);
        b5.setFont(myFont);
        b6.setFont(myFont);

        add(l1); 
      
        add(b1); //button to call select
        add(b2); //button to call insert 
        add(b3); //button to call update
        add(b4); //button to call delete
        add(b5); //button to call joins
        add(b6); //button to call other queries
       
            
        b1.addActionListener(this); //ActionListnener is an interface to call select class
        b2.addActionListener(this); //call insert
        b3.addActionListener(this); //call update
        b4.addActionListener(this); //call delete
        b5.addActionListener(this); //call joins
        b6.addActionListener(this);// call other queries
          
        setLayout(new GridLayout(5,5)); //to get multiple outputs on single window
        setVisible(true);
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops code exe while closing the frame window
    }
    
    public static void main(String args[])
    {   StartWindow d =new StartWindow();
        d.setTitle("Blood Bank Management System");
        d.setVisible(true);
        d.getContentPane().setBackground(Color.CYAN);
    } 

    
    public void actionPerformed(ActionEvent e)
    {
        String g=e.getActionCommand(); //to know which button
        
        if(g.equals("Select"))
        {
            Select s = new Select();
            s.setSize(new Dimension(1500,800));
            s.getContentPane().setBackground(Color.cyan);
            s.setTitle("Insertion: Select Your Attributes to display");
            s.setVisible(true);           
            s.show();
           
        }
        
        if(g.equals("Insert"))
        {
            Insert i = new Insert();
            i.setSize(new Dimension(1950,800));
            i.getContentPane().setBackground(Color.cyan);
            i.setTitle("Insertion");
            i.setVisible(true);           
            i.show();
        }
        
         if(g.equals("Update"))
        {
            Update u = new Update();
            u.setSize(new Dimension(1950,800));
           u.getContentPane().setBackground(Color.cyan);
            u.setTitle("Updation");
            u.setVisible(true);           
            u.show();
        }
       
          if(g.equals("Delete"))
        {
            Delete d1 = new Delete();
            d1.setSize(new Dimension(540,900));
            d1.getContentPane().setBackground(Color.cyan);
            d1.setTitle("Deletion");
            d1.setVisible(true);           
            d1.show();
        }
          
        if(g.equals("Joins"))
        {
            Joins j1 = new Joins();
            j1.setSize(new Dimension(1240,800));
            j1.getContentPane().setBackground(Color.cyan);
            j1.setTitle("Joins");
            j1.setVisible(true);           
            j1.show();
        }
        
        if(g.equals("Other Queries"))
        {
            OtherQueries o1 = new  OtherQueries();
            o1.setSize(new Dimension(1240,800));
            o1.getContentPane().setBackground(Color.cyan);
            o1.setTitle("Other Queries");
            o1.setVisible(true);           
            o1.show();
        }
    }
 }

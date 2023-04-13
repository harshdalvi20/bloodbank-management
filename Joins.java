
package MyDbms;
import MyDbms.SQLConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   
import java.awt.event.*;  
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Joins extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JFrame f1,f2,f3,f4;
    JButton b1,b2,b3,b4;
    JCheckBox c1,c2,c3,c4,c5;
    JCheckBox c6,c7,c8,c9,c10;
    JCheckBox c11,c12,c13,c14;
    Statement st=null;
    Connection c=null;
    ResultSet rs;
    String tables[]={"Donor and BloodBank","Hospital and BloodBank"};        
    JComboBox cb1,cb2;   
    public Joins()
    {
        Font myFont=new Font("Arial",Font.BOLD,22);
        l1= new JLabel("Cross Join");
        l2= new JLabel("Equi Join over did or hid");
        l4= new JLabel("Table: Hospital ");
        l3= new JLabel("Table: BLOOD BANK");
        
        b1 = new JButton("GO1");
        b2 = new JButton("GO2");
        b3 = new JButton("GO3");
        
        l1.setFont(myFont);
        l2.setFont(myFont);
        l3.setFont(myFont);
        l4.setFont(myFont);
        b1.setFont(myFont);
        b2.setFont(myFont);
        b3.setFont(myFont);

        
        cb1 =new JComboBox(tables); 
        cb2 =new JComboBox(tables);
        add(l1);
        add(cb1);
        add(b1);
        add(l2);
        add(cb2);
        add(b2);
        
        b1.addActionListener(this); //button click action event for cross join
        b2.addActionListener(this); //button click action event for equi join
        
        setLayout(new FlowLayout()); 
 
       
    }


    public void actionPerformed(ActionEvent e)
    {
        String g=e.getActionCommand();
        String query=null;
        try{  //dont edit this try block
            SQLConnection Sm = new SQLConnection();    
            c = Sm.getConn();     
            st= c.createStatement(); 
           }catch(Exception y){System.out.println(y);};
           
       if(g.equals("GO1"))
       {
           if( (cb1.getSelectedItem()).equals("Donor and BloodBank") )          
               query= "select * from donor cross join bloodbank";  
           else
               query= "select * from hospital cross join bloodbank";
           System.out.println(query);
                
           try
            {      
               rs= st.executeQuery(query); //ResultSet used to store multiple data (used as a storage medium)         
               Font myFont=new Font("Arial",Font.PLAIN,16);
               JTable jTable1=new JTable();
               jTable1.setFont(myFont);
               jTable1.setModel (DbUtils.resultSetToTableModel(rs)); 
               f1 = new JFrame();
               JScrollPane pg = new JScrollPane(jTable1);
               pg.setFont(myFont);
               f1.add(pg);
               f1.setSize(600,400);
               f1.setTitle("Cross Join");
               f1.setVisible(true);

               st.close();
               c.close();        
            } catch(Exception x){ System.out.println(x); }    
       }
       
       if(g.equals("GO2"))
       {
           if( (cb2.getSelectedItem()).equals("Donor and BloodBank") )          
              query= "select * from donor,bloodbank where donor.did=bloodbank.did"; 
           else
               query= "select * from hospital,bloodbank where hospital.hid=bloodbank.hid";  
           System.out.println(query);
                
           try
            {      
               rs= st.executeQuery(query); //ResultSet used to store multiple data (used as a storage medium)         
               Font myFont=new Font("Arial",Font.PLAIN,16);
               JTable jTable1=new JTable();
               jTable1.setFont(myFont);
               jTable1.setModel (DbUtils.resultSetToTableModel(rs)); 
               f1 = new JFrame();
               JScrollPane pg = new JScrollPane(jTable1);
               pg.setFont(myFont);
               f1.add(pg);
               f1.setSize(600,400);
               f1.setTitle("Equi Join");
               f1.setVisible(true);

               st.close();
               c.close();        
            } catch(Exception x){ System.out.println(x); } 
       }
     }
         
  }


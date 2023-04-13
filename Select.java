package MyDbms;
import MyDbms.SQLConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   
import java.awt.event.*;  
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Select  extends JFrame  implements ActionListener 
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
   
    public Select()
    {
       
        Font myFont=new Font("Arial",Font.BOLD,22);
        l1= new JLabel("");
        l2= new JLabel("Table: DONOR");
        l4= new JLabel("Table: Hospital ");
        l3= new JLabel("Table: BLOOD BANK");
        
        b1 = new JButton("GO1");
        b2 = new JButton("GO2");
        b3=new JButton("GO3");
        
        l1.setFont(myFont);
        l2.setFont(myFont);
        l3.setFont(myFont);
        l4.setFont(myFont);
        b1.setFont(myFont);
        b2.setFont(myFont);
        b3.setFont(myFont);
        
     
        //table donor buttons
        c1=new JCheckBox("did");  
        c2=new JCheckBox("name");  
        c3=new JCheckBox("age");
        c4=new JCheckBox("adress");
        c5=new JCheckBox("phno");
        
        //table Hospital
        c11=new JCheckBox("Hid");
        c12=new JCheckBox("Name");
        c13=new JCheckBox("Address");
        c14=new JCheckBox("Phno");
        
        //table Blood Bank Buttons  
        c10= new JCheckBox("did");
        c6=new JCheckBox("Blood group");  
        c7=new JCheckBox("Quantity");
        c8=new JCheckBox("Cost");
        c9 = new JCheckBox("Hid");   
        c1.setFont(myFont);
        c2.setFont(myFont);
        c3.setFont(myFont);
        c4.setFont(myFont);
        c5.setFont(myFont);
        c6.setFont(myFont);
        c7.setFont(myFont);
        c8.setFont(myFont);
        c9.setFont(myFont);
        c10.setFont(myFont);
        c11.setFont(myFont);
        c12.setFont(myFont);
        c13.setFont(myFont);
        c14.setFont(myFont);

            
        
        
        
        
        
        add(l2);
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(b1);
        
        add(l4);
        add(c11);
        add(c12);
        add(c13);
        add(c14);
        add(b2);
        
        add(l1);
        
        add(l3);
        add(c10);
        add(c6);
        add(c7);
        add(c8);
        add(c9);
        add(b3);
        
        
        
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
       
   
        setLayout(new GridLayout(3,9));   
    }
    
   
   public void actionPerformed (ActionEvent e) 
    {
                String g=e.getActionCommand();
                String did=null,name=null,age=null,address=null,phno=null;
                String bloodgroup=null,quantity=null,cost=null,hid=null;
                
                String query=null;
                int i;

                try{ 
                        SQLConnection Sm = new SQLConnection();    
                        c = Sm.getConn();     
                        st= c.createStatement(); 
                   }catch(Exception y){System.out.println(y);};

                if(g.equals("GO1"))
             {
                    if(c1.isSelected())
                  {    
                      did="did";
                  }    
                  if(c2.isSelected())
                  {
                     name= "name";
                  }
                   if(c3.isSelected())
                  {
                     age= "age";
                  }
                    if(c4.isSelected())
                  {
                     address= "address";
                  }
                     if(c5.isSelected())
                  {
                     phno= "phno";
                  }

                  query="select "+did+","+name+","+age+","+address+","+phno+" from donor;"; 
         
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
                       f1.setTitle("DONOR");
                       f1.setVisible(true);
                       
                       st.close();
                       c.close();        

                } catch(Exception x){ System.out.println(x); }                  
            }
                
            
            
            if(g.equals("GO2"))
            {
                if(c11.isSelected())
                {
                    hid="Hid";
                }
                if(c12.isSelected())
                {
                    name="name";
                }
                if(c13.isSelected())
                {
                    address="Address";
                }
                if(c14.isSelected())
                {
                    phno="Phno";
                }
                
                query= "select  "+hid+" , "+name+" , "+address+" ,"+phno+"  from Hospital;  ";
                
                try {
                    rs=st.executeQuery(query);
                    Font myFont=new Font("Arial",Font.PLAIN,20);
                    JTable jTable1=new JTable();
                    jTable1.setFont(myFont);
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    f3=new JFrame();
                    JScrollPane pg=new JScrollPane(jTable1);
                    pg.setFont(myFont);
                    f3.add(pg);
                    f3.setSize(600,500);
                    f3.setTitle("HOSPITAL");
                    f3.setVisible(true);
                    st.close();
                    c.close();
                    
                } catch (Exception x) { System.out.println(x);
                
                }
                
            }
            
            if(g.equals("GO3"))
            {
                 if(c10.isSelected())
                  {    
                      did="did";
                  }    
                  if(c6.isSelected())
                  {
                    bloodgroup="bloodgroup";
                  }
                   if(c7.isSelected())
                  {
                     quantity="quantity";
                  }
                    if(c8.isSelected())
                  {
                     cost="cost";
                  }
                     if(c9.isSelected())
                  {
                     hid="hid";
                  }

                  query="select "+did+","+bloodgroup+","+quantity+","+cost+","+hid+" from BloodBank;"; 
         
                  try
                    {      
                       rs= st.executeQuery(query); //ResultSet used to store multiple data (used as a storage medium)         
                       Font myFont=new Font("Arial",Font.PLAIN,16);
                       JTable jTable1=new JTable();
                       jTable1.setFont(myFont);
                       jTable1.setModel (DbUtils.resultSetToTableModel(rs)); 
                       f2 = new JFrame();
                       JScrollPane pg = new JScrollPane(jTable1);
                       pg.setFont(myFont);
                       f2.add(pg);
                       f2.setSize(600,400);
                       f2.setTitle("BLOOD BANK");
                       f2.setVisible(true);
                       
                       st.close();
                       c.close();        

                } catch(Exception x){ System.out.println(x); }             
            }
    }
     
}

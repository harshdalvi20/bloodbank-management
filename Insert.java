
package MyDbms;
import MyDbms.SQLConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Insert  extends JFrame  implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6;
    JLabel l7,l8,l9,l10,l11,l12;
    JLabel l13,l14,l15,l16,l17;
    JFrame f2;
    JTextArea t1,t2,t3,t4,t5;
    JTextArea t6,t7,t8,t9,t10;
    JTextArea t11,t12,t13,t14;
    JButton b1,b2,b3;
    Statement st=null;
    Connection c=null;
    ResultSet rs;
    JFrame f1;
    private Component jTable1;
    
    public Insert() 
    {
        Font myFont=new Font("Arial",Font.BOLD,20);
        
        l1= new JLabel("Table: DONOR");
        l2= new JLabel("did");
        l3= new JLabel("name");
        l4= new JLabel("age");
        l5= new JLabel("address");
        l6= new JLabel("phno");
        
        l13=new JLabel("Table:Hospital");
        l14=new JLabel("Hid");
        l15=new JLabel("Name");
        l16=new JLabel("Address");
        l17=new JLabel("phno");
        
        
        l7=new JLabel("Table:Blood Bank");
        l8=new JLabel("Did");
        l9=new JLabel("Blood Group");
        l10=new JLabel("Quantity");
        l11=new JLabel("Cost");
        l12=new JLabel("Hid");
        
        
        
        t1= new JTextArea(6,15); 
        t2= new JTextArea(6,15); 
        t3= new JTextArea(6,15); 
        t4= new JTextArea(6,15); 
        t5= new JTextArea(6,15);  
        
        t11= new JTextArea(6,20); 
        t12= new JTextArea(6,20); 
        t13= new JTextArea(6,20); 
        t14= new JTextArea(6,20);
        
           
        t6= new JTextArea(6,15); 
        t7= new JTextArea(6,15); 
        t8= new JTextArea(6,15); 
        t9= new JTextArea(6,15); 
        t10= new JTextArea(6,15);
        
        
        b1 = new JButton("Insert1");
        b3= new JButton("Insert2");
        b2= new JButton("Insert3");
        
        l1.setFont(myFont);
        l2.setFont(myFont);
        l3.setFont(myFont);
        l4.setFont(myFont);
        l5.setFont(myFont);
        l6.setFont(myFont);
        
        l7.setFont(myFont);
        l8.setFont(myFont);
        l9.setFont(myFont);
        l10.setFont(myFont);
        l11.setFont(myFont);
        l12.setFont(myFont);
        
        l13.setFont(myFont);
        l14.setFont(myFont);
        l15.setFont(myFont);
        l16.setFont(myFont);
        l17.setFont(myFont);
        
        
        t1.setFont(myFont); 
        t2.setFont(myFont); 
        t3.setFont(myFont);
        t4.setFont(myFont);
        t5.setFont(myFont);   
        b1.setFont(myFont);
        
        t6.setFont(myFont);
        t7.setFont(myFont);
        t8.setFont(myFont);
        t9.setFont(myFont);
        t10.setFont(myFont);
        b2.setFont(myFont);
        
        t11.setFont(myFont);
        t12.setFont(myFont);
        t13.setFont(myFont);
        t14.setFont(myFont);
        b3.setFont(myFont);
        
        
        add(l1); //table donor
        add(l2); //did label
        add(t1); // did input
        add(l3); //name
        add(t2); //name
        add(l4); //age
        add(t3); //age
        add(l5); //address
        add(t4); //address
        add(l6); //phno
        add(t5); //phno 
        add(b1);//button
        
        add(l13);//table hospital
        add(l14);
        add(t11);
        add(l15);
        add(t12);
        add(l16);
        add(t13);
        add(l17);
        add(t14);
        add(b3);//insert3
        
 
        add(l7);//table blood bank
        
        add(l8);
        add(t6);
        add(l9);
        add(t7);
        add(l10);
        add(t8);
        add(l11);
        add(t9);
        add(l12);
        add(t10);
        add(b2);//insert2
        
        

             
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
            
        setSize(1000,800);
        setLayout(new FlowLayout());   
              
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
                String g=e.getActionCommand();
                String did=null,name=null,age=null,address=null,phno=null;
                String bloodgroup=null,quantity=null,cost=null,hid=null;
                int count;
                
                
                
                
                String query=null;
               try{ 
                        SQLConnection Sm = new SQLConnection();    
                        c = Sm.getConn();     
                        st= c.createStatement(); 
                   }catch(Exception y){System.out.println(y);};
                
                    if(g.equals("Insert1"))
             {
                     did=(t1.getText());
                     name=(t2.getText());
                      age=(t3.getText());
                     address=(t4.getText());
                      phno=(t5.getText());
                      
                     query="insert into donor values('"+did+"','"+name+"',"+age+",'"+address+"',"+phno+")" ;
                     
                        try
                    {      
                       count= st.executeUpdate(query); //ResultSet used to store multiple data (used as a storage medium)         
                       Font myFont=new Font("Arial",Font.PLAIN,16);
                     
                        System.out.println(+count+" rows affected ");
                       st.close();
                       c.close();        

                         } catch(Exception x){ System.out.println(x); }
                   }
                    
                    if(g.equals("Insert2"))
                    {
                        hid=(t11.getText());
                        name=(t12.getText());
                        address=(t13.getText());
                        phno=(t14.getText());
                        
                        query="insert into hospital values (' "+hid+" ',' "+name+" ',' "+address+" ', "+phno+"  )";
                        
                        try {
                            
                            count=st.executeUpdate(query);
                            
                             Font myFont=new Font("Arial",Font.PLAIN,16);
                     
                    
                        System.out.println(+count+" rows affected ");
                       st.close();
                       c.close();        
                            
                        } catch (Exception x) { System.out.println(x);
                        }
                    }
                    
                    if(g.equals("Insert3"))
                    {
                        did=(t6.getText());
                        bloodgroup=(t7.getText());
                        quantity=(t8.getText());
                        cost=(t9.getText());
                        hid=(t10.getText());
                        
                        query = "insert into bloodbank values ('"+did+"','"+bloodgroup+"',  "+quantity+"  , "+cost+"  , '"+hid+"'  )" ;
                        
                        try {
                            count= st.executeUpdate(query); //ResultSet used to store multiple data (used as a storage medium)         
                            Font myFont=new Font("Arial",Font.PLAIN,16);
                    
                               System.out.println(+count+" rows affected ");
                           st.close();
                           c.close();        
                        } catch (Exception x) {System.out.println(x);
                        }
                    }
              
        }

   

}
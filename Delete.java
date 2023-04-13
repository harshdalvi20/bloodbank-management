package MyDbms;
import MyDbms.SQLConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   
import java.sql.*;
import javax.swing.*;

public class Delete extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextArea t1,t2,t3;
    JButton b1,b2,b3,b4; //1 for each four tables
    JRadioButton r1,r2,r3,r4,r5;  
     //Giving Radio button group because only 1 radio button needs to be selected only so make a group
    JRadioButton r6,r7,r8,r9,r10,r11,r12,r13,r14;
       
    Statement st=null; //dont edit this 3 lines
    Connection c=null;
    ResultSet rs;
    
    public Delete()
    {
        Font myFont=new Font("Arial",Font.BOLD,20);
        
        l1= new JLabel("Table: DONOR");
        l2= new JLabel("Select the attribute whose record is to be deleted");
        l3= new JLabel("type the attribute value");
        t1= new JTextArea(10,20);
        r1=new JRadioButton("did"); //declaring the radio buttons for donor table
        r2=new JRadioButton("name"); 
        r3=new JRadioButton("age"); 
        r4=new JRadioButton("address"); 
        r5=new JRadioButton("phno"); 
        b1 = new JButton("GO1"); //button for donor table
        
        l4= new JLabel("Table: BLOOD BANK");
        l5= new JLabel("Select the attribute whose record is to be deleted");
        l6= new JLabel("type the attribute value");
        t2= new JTextArea(10,20);
        r6=new JRadioButton("did"); //declaring the radio buttons for blood bank table
        r7=new JRadioButton("Blood group"); 
        r8=new JRadioButton("Quantity"); 
        r9=new JRadioButton("Cost"); 
        r10=new JRadioButton("Hid");
        b2 = new JButton("GO2"); //button for blood bank table
        
        l7= new JLabel("Table: HOSPITAL");
        l8= new JLabel("Select the attribute whose record is to be deleted");
        l9= new JLabel("type the attribute value");
        t3= new JTextArea(10,20);
        r11=new JRadioButton("Hid"); //declaring the radio buttons for hospital table
        r12=new JRadioButton("name"); 
        r13=new JRadioButton("adress"); 
        r14=new JRadioButton("phno"); 
        b3 = new JButton("GO3"); //button for hospital table
        
        l1.setFont(myFont);  //setting fonts to the radio buttons
        l2.setFont(myFont);
        l3.setFont(myFont);
        r1.setFont(myFont);
        r2.setFont(myFont);
        r3.setFont(myFont);
        r4.setFont(myFont);
        r5.setFont(myFont);
        l4.setFont(myFont);  //setting fonts to the radio buttons
        l5.setFont(myFont);
        l6.setFont(myFont);
        r6.setFont(myFont);
        r7.setFont(myFont);
        r8.setFont(myFont);
        r9.setFont(myFont);
        r10.setFont(myFont);
        l7.setFont(myFont);  //setting fonts to the radio buttons
        l8.setFont(myFont);
        l9.setFont(myFont);
        r11.setFont(myFont);
        r12.setFont(myFont);
        r13.setFont(myFont);
        r14.setFont(myFont);
        
       ButtonGroup G1 = new ButtonGroup(); //Radio button Group is created because we need to choose only 1 Radio button 
                                          //so Radito buttons added to a group.. amoung those Radio buttons only 1 can be selected
       ButtonGroup G2 = new ButtonGroup();
       
       ButtonGroup G3 = new ButtonGroup();
       
        G1.add(r1); //adding the buttons to the group G1
        G1.add(r2);
        G1.add(r3); 
        G1.add(r4); 
        G1.add(r5); 
        
        G2.add(r6); //adding the buttons to the group G2
        G2.add(r7);
        G2.add(r8); 
        G2.add(r9); 
        G2.add(r10);
        
        G3.add(r11); //adding the buttons to the group G2
        G3.add(r12);
        G3.add(r13); 
        G3.add(r14); 
        
        add(l1); //adding the labels to frame output
        add(l2);
        add(r1); //adding the radio buttons to frame output
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        add(l3);
        add(t1);
               
        add(b1);  //adding Go1 button for donor table
        
         b1.addActionListener(this); //button click action event for donor table
         
        add(l4); //adding the labels to frame output
        add(l5);
        add(r6); //adding the radio buttons to frame output
        add(r7);
        add(r8);
        add(r9);
        add(r10);
        add(l6);
        add(t2);
               
        add(b2);  //adding Go1 button for blood bank table
        
         b2.addActionListener(this); //button click action event for blood bank table
         
        add(l7); //adding the labels to frame output
        add(l8);
        add(r11); //adding the radio buttons to frame output
        add(r12);
        add(r13);
        add(r14);
        add(l9);
        add(t3);
               
        add(b3);  //adding Go1 button for blood bank table
        
         b3.addActionListener(this); //button click action event for blood bank table
         
         setLayout(new FlowLayout());  //dont edit 
       
    }
   
    public void actionPerformed(ActionEvent e)
    {
       String g=e.getActionCommand();
       String AttributeName=null;
       String AttributeValue=null;
       String query=null;
       int count; //dont edit this count
       
        try{  //dont edit this try block
            SQLConnection Sm = new SQLConnection();    
            c = Sm.getConn();     
            st= c.createStatement(); 
           }catch(Exception y){System.out.println(y);};
           
           
        if(g.equals("GO1"))  //for donor table (if user clicks on GO1 button to delete a row from donor table)
             {
                 AttributeValue= t1.getText(); //fetching the value whoz record is to be deleted
                 
                    if(r1.isSelected())
                  {    
                      AttributeName="did";
                  }    
                     if(r2.isSelected())
                  {    
                      AttributeName="name";
                  } 
                   if(r3.isSelected())
                  {    
                      AttributeName="age";
                  } 
                    if(r4.isSelected())
                  {    
                      AttributeName="address";
                  } 
                     if(r5.isSelected())
                  {    
                      AttributeName="phno";
                  }
               query="delete from donor where "+AttributeName+" = '"+AttributeValue+"' ; "; //type similar query for table hospital and bloodbnk
                 System.out.println(query);
                  try //always use try-catch block to execute the query (even for other tables)
                    {      
                       count= st.executeUpdate(query); //will return how many rows affected and store in count variable        
                       Font myFont=new Font("Arial",Font.PLAIN,16);
                     
                       System.out.println(+count+" rows affected "); //print how many rows affected
                       st.close(); //close the connections
                       c.close();        
                     } catch(Exception x){ System.out.println(x); }             
             }  
        
        if(g.equals("GO2"))  //for blood bank table (if user clicks on GO2 button to delete a row from donor table)
             {
                 AttributeValue= t2.getText(); //fetching the value whoz record is to be deleted
                 
                    if(r6.isSelected())
                  {    
                      AttributeName="did";
                  }    
                     if(r7.isSelected())
                  {    
                      AttributeName="Blood group";
                  } 
                   if(r8.isSelected())
                  {    
                      AttributeName="Quantity";
                  } 
                    if(r9.isSelected())
                  {    
                      AttributeName="Cost";
                  } 
                     if(r10.isSelected())
                  {    
                      AttributeName="Hid";
                  }
               query="delete from BloodBank where "+AttributeName+" = '"+AttributeValue+"' ; "; //type similar query for table hospital and bloodbnk
                 System.out.println(query);
                  try //always use try-catch block to execute the query (even for other tables)
                    {      
                       count= st.executeUpdate(query); //will return how many rows affected and store in count variable        
                       Font myFont=new Font("Arial",Font.PLAIN,16);
                     
                       System.out.println(+count+" rows affected "); //print how many rows affected
                       st.close(); //close the connections
                       c.close();        
                     } catch(Exception x){ System.out.println(x); }             
             } 
        
        if(g.equals("GO3"))  //for hospital table (if user clicks on GO3 button to delete a row from hospital table)
             {
                 AttributeValue= t3.getText(); //fetching the value whoz record is to be deleted
                 
                    if(r11.isSelected())
                  {    
                      AttributeName="Hid";
                  }    
                     if(r12.isSelected())
                  {    
                      AttributeName="name";
                  } 
                   if(r13.isSelected())
                  {    
                      AttributeName="address";
                  } 
                    if(r14.isSelected())
                  {    
                      AttributeName="phno";
                  } 
               
               query="delete from Hospital where "+AttributeName+" = '"+AttributeValue+"' ; "; //type similar query for table hospital and bloodbnk
                 System.out.println(query);
                  try //always use try-catch block to execute the query (even for other tables)
                    {      
                       count= st.executeUpdate(query); //will return how many rows affected and store in count variable        
                       Font myFont=new Font("Arial",Font.PLAIN,16);
                     
                       System.out.println(+count+" rows affected "); //print how many rows affected
                       st.close(); //close the connections
                       c.close();        
                     } catch(Exception x){ System.out.println(x); }             
             }  
             /*
                **NOTE** Create for blood bank table first because hospital table rows wont get deleted because
                            they have foreign keys referencing from donor and hospital table
                            so first try creating deletion for bloodbank table and let me know if it works and then for hospital table
        
                So now similary make label: for table bloodbank,
                1. add radio buttons corresponding to bloodbank attributes
                2. add the radio buttons to new group G2 to get only 1 radio button selected
                3. add the labels,buttons, textArea to type the attribute value , set fonts also
                4. add button GO2 to perform the execution in event listener
                5. in actionPerformed(ActionEvent e), put if(GO2) condition similar to donor table above (how i made) and check if attributes
                   are selected by the user
                6. form the query= .... similar what i did above
                7. execute the query in a new try-catch block
                8. start the xampp services and test it
                9. Testing eg: delete from bloodbank where did='D12' ;
        */
        }    
}
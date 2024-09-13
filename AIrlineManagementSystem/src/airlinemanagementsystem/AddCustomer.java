package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname , tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale , rbfemale;
    
   public AddCustomer (){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
       heading.setBounds(260,30,500,30);
       heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
       heading.setForeground(Color.blue);
       add(heading);
       
       JLabel lblname  = new JLabel("Name");
       lblname.setBounds(60,110,150,25);
       lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lblname);
       
       tfname = new JTextField();
       tfname.setBounds(220,110,150,25);
       add(tfname);
       
       JLabel lblnationality  = new JLabel("Nationality");
       lblnationality .setBounds(60,150,150,25);
       lblnationality .setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lblnationality );
       
       tfnationality  = new JTextField();
       tfnationality.setBounds(220,150,150,25);
       add(tfnationality);
       
       JLabel lblaadhar = new JLabel("Aadhar Number");
       lblaadhar.setBounds(60,190,150,25);
       lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lblaadhar );
       
       tfaadhar = new JTextField();
       tfaadhar .setBounds(220,190,150,25);
       add(tfaadhar);
       
       JLabel lbladdress = new JLabel("Address");
       lbladdress.setBounds(60,230,150,25);
       lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lbladdress);
       
       tfaddress = new JTextField();
       tfaddress .setBounds(220,230,150,25);
       add(tfaddress);
       
       JLabel lblgender = new JLabel("Gender");
       lblgender .setBounds(60,270,150,25);
       lblgender .setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lblgender );
       
       ButtonGroup gendergroup = new ButtonGroup();
        
       rbmale = new JRadioButton("Male");
       rbmale.setBounds(220,270,70,25);
       rbmale.setBackground(Color.white);
       add(rbmale);
       
       rbfemale = new JRadioButton("Female");
       rbfemale.setBounds(300,270,110,25);
       rbfemale.setBackground(Color.white);
       add(rbfemale);
       
       gendergroup.add(rbmale);
       gendergroup.add(rbfemale);
       
       JLabel lblphone = new JLabel("Phone Number");
       lblphone.setBounds(60,310,150,25);
       lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lblphone);
       
       tfphone = new JTextField();
       tfphone.setBounds(220,310,150,25);
       add(tfphone);
       
       JButton save = new JButton ("Save");
       save.setBackground (Color.black);
       save.setForeground(Color.white);
       save.setBounds(220,350,150,30);
       save.addActionListener(this);
       add(save);        
       
       ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
       JLabel lblimage = new JLabel(image);
       lblimage.setBounds(450, 80, 280, 400);
       add(lblimage);
       
       setSize(900,600);
       setLocation(300,150);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       String name = tfname.getText();
       String nationality = tfnationality.getName();
       String phone = tfphone.getText();
       String address = tfaddress.getText();
       String aadhar = tfaadhar.getText();
       String gender = null;
       if(rbmale.isSelected()){
           gender = "Male";
       }
       
       try{
         Conn conn = new Conn();
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
  public static void main (String[] args){
      new AddCustomer();
  }
}
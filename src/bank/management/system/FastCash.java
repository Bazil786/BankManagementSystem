
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    
    JButton first,second,third,four,five,six,exit;
    String pinnumber;
    
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(240,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        first=new JButton("Rs 100");
        first.setBounds(170,415,150,30);
        first.addActionListener(this);
        image.add(first);
        
        second=new JButton("Rs 500");
        second.setBounds(355,415,150,30);
        second.addActionListener(this);
        image.add(second);
        
        five=new JButton("Rs 1000");
        five.setBounds(170,450,150,30);
        five.addActionListener(this);
        image.add(five);
        
        third=new JButton("Rs 2000");
        third.setBounds(355,450,150,30);
        third.addActionListener(this);
        image.add(third);
        
        four=new JButton("Rs 5000");
        four.setBounds(170,485,150,30);
        four.addActionListener(this);
        image.add(four);
        
        six=new JButton("Rs 10000");
        six.setBounds(355,485,150,30);
        six.addActionListener(this);
        image.add(six);
        
        exit=new JButton("Back");
        exit.setBounds(260,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
             
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            
            Conn c=new Conn();
            
            try{
                
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(e.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                    
                }
                
                Date date=new Date();
                
                String query= "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Rs "+amount +" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception ae)
            {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[])
    {
        new FastCash("");
    }

}

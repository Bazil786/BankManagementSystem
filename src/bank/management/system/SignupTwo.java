
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,income,education;
    
    String formno;
            
            
    SignupTwo(String formno) {
        
        this.formno =formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","others"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel cat=new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        add(cat);
        
        String valCategory[]={"General","OBC","SC","ST","others"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc=new JLabel("Income:");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        String incomeCategory[]={"Null","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel edu=new JLabel("Educational-");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);
   
        JLabel qual=new JLabel("Qualification:");
        qual.setFont(new Font("Raleway",Font.BOLD,20));
        qual.setBounds(100,315,200,30);
        add(qual);
        
        String educationvalue[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","others"};
        education=new JComboBox(educationvalue);
        education.setBounds(300,310,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel Ocup=new JLabel("Occupation:");
        Ocup.setFont(new Font("Raleway",Font.BOLD,20));
        Ocup.setBounds(100,390,200,30);
        add(Ocup);
        
        String Occupationvalue[]={"Salaried","Self-Emloyed","Bussiness","Student","Retired","others"};
        occupation=new JComboBox(Occupationvalue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel pan_no=new JLabel("PAN Number:");
        pan_no.setFont(new Font("Raleway",Font.BOLD,20));
        pan_no.setBounds(100,440,200,30);
        add(pan_no);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel adhar=new JLabel("Adhar Number:");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel senior=new JLabel("Sinior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup Seniorgroup=new ButtonGroup();
        Seniorgroup.add(syes);
        Seniorgroup.add(sno);
        
        JLabel eaccount=new JLabel("Existing ccount:");
        eaccount.setFont(new Font("Raleway",Font.BOLD,20));
        eaccount.setBounds(100,590,200,30);
        add(eaccount);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existgroup=new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,850);
        setLocation(350,10);
        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String sreligion= (String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        
        String seniorcitizen=null;
        if(syes.isSelected())
        {
            seniorcitizen="Yes";
        }else if(sno.isSelected())
        {
            seniorcitizen="No";
        }
        
        String existingaccount=null;
        if(eyes.isSelected())
        {
            existingaccount="Yes";
        }else if(eno.isSelected())
        {
            existingaccount="No";
        }
        
        String span= pan.getText();
        String sadhar= aadhar.getText();
 
        try{
            
//            Checking Null Fields 

            if(sreligion.equals(""))
                JOptionPane.showMessageDialog(null,"Religion is Required");
            else if(scategory.equals(""))
                 JOptionPane.showMessageDialog(null,"Category is Required");
            else if(sincome.equals(""))
                 JOptionPane.showMessageDialog(null,"Income is Required");
            else if(seducation.equals(""))
                 JOptionPane.showMessageDialog(null,"Education is Required");
            else if(soccupation.equals(""))
                 JOptionPane.showMessageDialog(null,"Occupation is Required");
            else if(span.equals(""))
                 JOptionPane.showMessageDialog(null,"Pan is Required");
            else if(sadhar.equals(""))
                 JOptionPane.showMessageDialog(null,"Aadhar is Required");
            
//            Database Call
            
            else{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
             
//                SignUpthree object
                  setVisible(false);
                  new SignupThree(formno).setVisible(true);
                  
            }
            
        }catch(Exception e)
        {
               System.out.println(e);
        }
      
    }
    
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}

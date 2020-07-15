package com.org;


import javax.swing.*;  
import java.awt.event.*;    
import javax.swing.JFrame;  

public class Interface extends JFrame implements ActionListener{    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JFrame frame;
    JButton submitButton;    
    JRadioButton r1,r2,r3,r4,r5;

    Interface(){    
        frame = new JFrame();     
        r1 = new JRadioButton("✯");    
        r2 = new JRadioButton("✯✯");
        r3 = new JRadioButton("✯✯✯");    
        r4 = new JRadioButton("✯✯✯✯");    
        r5 = new JRadioButton("✯✯✯✯✯");        
        r1.setBounds(25,100,100,30);    
        r2.setBounds(25,120,100,30);
        r3.setBounds(25,140,100,30);    
        r4.setBounds(25,160,100,30);    
        r5.setBounds(25,180,100,30);    
    
        ButtonGroup bg = new ButtonGroup();    
        bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);bg.add(r5);      
        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(r4); 
        frame.add(r5);


        submitButton = new JButton("Submit Rating");    
        submitButton.setBounds(25,200,100,30);    
        submitButton.addActionListener(this);  
        frame.add(submitButton);
           
        frame.setSize(600,600);    
        frame.setLayout(null);    
        frame.setVisible(true);    
    }    


    public void actionPerformed(ActionEvent e){  

        if(r1.isSelected()){    
            JOptionPane.showMessageDialog(this,"You rated it 1 star.");    
        }    
        if(r2.isSelected()){    
            JOptionPane.showMessageDialog(this,"You rated it 2 star.");    
        }
        if(r3.isSelected()){    
            JOptionPane.showMessageDialog(this,"You rated it 3 star.");    
        }    
        if(r4.isSelected()){    
            JOptionPane.showMessageDialog(this,"You rated it 4 star.");    
        }    
        if(r5.isSelected()){    
            JOptionPane.showMessageDialog(this,"You rated it 5 star.");    
        }    
    
    }    



    public static void main(String[] args) {    
        new Interface();    
    }    
}    
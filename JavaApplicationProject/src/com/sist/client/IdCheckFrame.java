package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class IdCheckFrame extends JFrame{
      JLabel la1,la2,la3;
      JButton b1,b2,b3;
      JTextField tf;
      
      public IdCheckFrame()
      {
    	  setLayout(null);
    	  la1=new JLabel("아이디 중복체크",JLabel.CENTER);
    	  la1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    	  la1.setBounds(10, 15, 250, 35);
    	  add(la1);
    	  
    	  la2=new JLabel("ID");
    	  la2.setBounds(10, 55, 30, 30);
    	  add(la2);
    	  
    	  tf=new JTextField();
    	  tf.setBounds(45, 55, 150, 30);
    	  add(tf);
    	  
    	  b1=new JButton("검색");
    	  b1.setBounds(200, 55, 60, 30);
    	  add(b1);
    	  
    	  la3=new JLabel("",JLabel.CENTER);
    	  la3.setForeground(Color.red);
    	  la3.setBounds(10, 95, 250, 30);
    	  add(la3);
    	  
    	  b2=new JButton("확인");
    	  b2.setVisible(false);
    	  JPanel p=new JPanel();
    	  p.add(b2);
    	  p.setBounds(10, 135, 250, 35);
    	  add(p);
    	  setSize(290, 220);
    	  //setVisible(true);
    	  
      }
		/*
		 * public static void main(String[] args) { new IdCheckFrame(); }
		 */
      
}

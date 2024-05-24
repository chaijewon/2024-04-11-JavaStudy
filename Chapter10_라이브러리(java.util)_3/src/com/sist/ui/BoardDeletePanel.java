package com.sist.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardDeletePanel extends JPanel{
	
    JLabel titleLa;
    JLabel la,la1;
    JPasswordField pf;
    JButton b1,b2;
    
    public BoardDeletePanel()
    {
    	titleLa=new JLabel("삭제하기");
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,45));
    	titleLa.setHorizontalAlignment(JLabel.CENTER);
    	
    	la=new JLabel("비밀번호");
    	pf=new JPasswordField();
    	la1=new JLabel();
    	la1.setVisible(false);
    	b1=new JButton("삭제");
    	b2=new JButton("취소");
    	setLayout(null);
    	titleLa.setBounds(10, 15, 720, 60);
  	    add(titleLa);
  	    add(la1);
  	    la.setBounds(200, 100, 80, 30);
  	    pf.setBounds(290, 100, 200, 30);
  	    add(la);add(pf);
  	    
  	    JPanel p=new JPanel();
  	    p.add(b1);
  	    p.add(b2);
  	    p.setBounds(200, 175, 290, 35);
  	    add(p);
    }
}
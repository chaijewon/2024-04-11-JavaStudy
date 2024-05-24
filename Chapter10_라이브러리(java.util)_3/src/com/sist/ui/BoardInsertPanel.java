package com.sist.ui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class BoardInsertPanel extends JPanel
{
	
	 JLabel la;
	 JLabel la1,la2,la3,la4;
	 JTextField tf1,tf2,tf3;
	 JTextArea ta;
	 JButton b1,b2;
     public BoardInsertPanel()
     {
    	
    	 la=new JLabel("자유 게시판");
    	 setLayout(null); // 사용자 정의 배치 
     	 la.setHorizontalAlignment(JLabel.CENTER);
     	 la.setFont(new Font("굴림체",Font.BOLD,35));
     	 la.setBounds(10, 15, 710, 50);
     	 add(la);
     	 
     	 la1=new JLabel("이름");
     	 la2=new JLabel("제목");
     	 la3=new JLabel("내용");
     	 la4=new JLabel("비밀번호");
     	 
     	 tf1=new JTextField();
     	 tf2=new JTextField();
     	 tf3=new JTextField();
     	 
     	 ta=new JTextArea();
     	 JScrollPane js=new JScrollPane(ta);
     	 
     	 b1=new JButton("글쓰기");
     	 b2=new JButton("취소");
     	 
     	 // 배치 
     	 la1.setBounds(10, 75, 70, 30);
     	 tf1.setBounds(85, 75, 150, 30);
     	 add(la1);add(tf1);
     	 
     	 la2.setBounds(10, 115, 70, 30);
    	 tf2.setBounds(85, 115, 450, 30);
    	 add(la2);add(tf2);
    	 
    	 la3.setBounds(10, 155, 70, 30);
    	 js.setBounds(85, 155, 550, 350);
    	 add(la3);add(js);
    	 
    	 la4.setBounds(10, 515, 70, 30);
     	 tf3.setBounds(85, 515, 150, 30);
     	 add(la4);add(tf3);
     	 
     	 JPanel p=new JPanel();
     	 p.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
     	 b1.setPreferredSize(new Dimension(120,30));
     	 b2.setPreferredSize(new Dimension(120,30));
     	 p.add(b1);p.add(b2);
     	 p.setBounds(10, 555, 625, 40);
     	 add(p);
     	 
	}
}

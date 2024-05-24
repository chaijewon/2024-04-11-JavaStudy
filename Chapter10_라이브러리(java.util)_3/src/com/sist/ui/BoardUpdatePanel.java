package com.sist.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BoardUpdatePanel extends JPanel{
	
    JLabel titleLa;
    JLabel la1,la2,la3,la4,la5;
    JTextField tf1,tf2;
    JPasswordField pf;
    JTextArea ta;
    JButton b1,b2;
   
    public BoardUpdatePanel()
    {
   	     
   	     titleLa=new JLabel("수정하기");
    	 titleLa.setFont(new Font("맑은 고딕",Font.BOLD,45));
    	 titleLa.setHorizontalAlignment(JLabel.CENTER);
    	 
    	 la1=new JLabel("이름");//<label for="name">이름</label>
    	 la2=new JLabel("제목");
    	 la3=new JLabel("내용");
    	 la4=new JLabel("비밀번호");
    	 la5=new JLabel("");
    	 la5.setVisible(false);// 번호
    	 tf1=new JTextField();//<input type=text>
    	 tf2=new JTextField();
    	 ta=new JTextArea();//<textarea></textarea>
    	 JScrollPane js=new JScrollPane(ta);
    	 pf=new JPasswordField();//<input type=password>
    	 
    	 b1=new JButton("수정");//<input type=button>
    	 b2=new JButton("취소");
    	 
    	 // 배치 
    	 setLayout(null);// css
    	 titleLa.setBounds(10, 15, 720, 60);
	   	 add(titleLa);
	   	 
	   	 la1.setBounds(10,85, 80, 30);
	   	 tf1.setBounds(95,85,150, 30);
	   	 
	   	 la2.setBounds(10,120, 80, 30);
	   	 tf2.setBounds(95,120,450, 30);
	   	 
	   	 la3.setBounds(10,155, 80, 30);
	   	 js.setBounds(95,155,450, 350);
	   	 
	   	 la4.setBounds(10,510, 80, 30);
	   	 pf.setBounds(95,510,150, 30);
	   	 
	   	 JPanel p=new JPanel();
	   	 p.add(b1);
	   	 p.add(b2);
	   	 p.setBounds(10, 545,525 , 35);
	   	 add(la5);
	   	 // 추가
	   	 add(la1);add(tf1);
	   	 add(la2);add(tf2);
	   	 add(la3);add(js);
	   	 add(la4);add(pf);
	   	 add(p);
	}

}
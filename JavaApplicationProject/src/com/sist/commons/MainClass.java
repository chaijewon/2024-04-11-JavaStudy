package com.sist.commons;
import java.util.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
// https://img.cgv.co.kr/Movie/Thumbnail/Poster/000088/88271/88271_320.jpg
public class MainClass extends JFrame{
    JLabel la;
    public MainClass()
    {
    	setLayout(null);
    	la=new JLabel();
    	la.setBounds(30, 50, 300, 450);
    	add(la);
    	try
    	{
    		URL url=new URL("https://img.cgv.co.kr/Movie/Thumbnail/Poster/000088/88271/88271_320.jpg");
    		Image img=ImageChange.getImage(new ImageIcon(url), 300, 450);
    		la.setIcon(new ImageIcon(img));
    	}catch(Exception ex){}
    	setSize(370,550);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass();
	}

}

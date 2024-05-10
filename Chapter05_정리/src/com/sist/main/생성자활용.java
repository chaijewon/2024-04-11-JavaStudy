package com.sist.main;
import javax.swing.*;
public class 생성자활용 {
    /*JFrame frame=new JFrame();
    public 생성자활용()
    {
       frame.setSize(800, 600);
       frame.setVisible(true);
    }*/
	JFrame frame;
	public 생성자활용(String title)
	{
		frame=new JFrame(title);
		frame.setSize(800, 600);
	    frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자 
		new 생성자활용("Music");
	}

}

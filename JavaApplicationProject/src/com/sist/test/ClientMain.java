package com.sist.test;
import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClientMain extends JFrame{
    CardLayout card=new CardLayout();
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    public ClientMain()
    {
    	setLayout(card);
    	add("LOGIN",login);
    	add("WR",wr);
    	setSize(800, 600);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ClientMain();
	}

}

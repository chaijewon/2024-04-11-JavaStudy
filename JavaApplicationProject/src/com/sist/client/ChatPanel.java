package com.sist.client;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class ChatPanel extends JPanel{
    JTextPane pane;
    JTextField tf;
    JComboBox<String> box1,box2;
    JTable table; 
    DefaultTableModel model;
    JButton b1,b2;
    public ChatPanel()
    {
    	setLayout(null);
    	pane=new JTextPane();
    	JScrollPane js1=new JScrollPane(pane);
    	js1.setBounds(10, 15, 480, 480);
    	add(js1);
    	
    	tf=new JTextField();
    	tf.setBounds(10,500, 380, 30);
    	add(tf);
    	
    	box1=new JComboBox<String>();
    	box1.addItem("black");
    	box1.addItem("cyan");
    	box1.addItem("yellow");
    	box1.addItem("blue");
    	box1.addItem("magenta");
    	box1.addItem("green");
    	box1.addItem("pink");
    	box1.addItem("orange");
    	
    	box1.setBounds(395, 590, 100, 30);
    	add(box1);
    	
    }
    
}

package com.sist.client;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
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
    	tf.setBounds(10, 500, 380, 30);
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
    	
    	box1.setBounds(395, 500, 100, 30);
    	add(box1);
    	
    	String[] col={"ID","이름","성별"};
    	String[][] row=new String[0][3];
    	
    	model=new DefaultTableModel(row,col)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		
    	};
    	table=new JTable(model);
    	JScrollPane js2=new JScrollPane(table);
    	js2.setBounds(495, 15, 400, 400);
    	add(js2);
    	
    	box2=new JComboBox<String>();
    	box2.setBounds(495,420, 100, 30);
    	add(box2);
    	
    	b1=new JButton("1:1상담");
    	b1.setBounds(600, 420, 120, 30);
    	
    	b2=new JButton("정보보기");
    	b2.setBounds(725, 420, 100, 30);
    	
    	add(b1);add(b2);
    }
    public void initStyle()
    {
 	   Style green=pane.addStyle("green", null);
 	   StyleConstants.setForeground(green, Color.green);
 	   
 	   Style yellow=pane.addStyle("yellow", null);
 	   StyleConstants.setForeground(yellow, Color.yellow);
 	   
 	   Style blue=pane.addStyle("blue", null);
 	   StyleConstants.setForeground(blue, Color.blue);
 	   
 	   Style pink=pane.addStyle("pink", null);
 	   StyleConstants.setForeground(pink, Color.pink);
 	   
 	   Style cyan=pane.addStyle("cyan", null);
 	   StyleConstants.setForeground(cyan, Color.cyan);
 	   
 	   Style orange=pane.addStyle("orange", null);
 	   StyleConstants.setForeground(orange, Color.orange);
 	   
 	   Style magenta=pane.addStyle("magenta", null);
 	   StyleConstants.setForeground(magenta, Color.magenta);
        
 	   Style red=pane.addStyle("red", null);
 	   StyleConstants.setForeground(red, Color.red);
 	   
    }
    
    // TextPane의 단점 => 문자열 결합 => setText()
    public void append(String msg,String color)
    {
    	try
    	{
    	  Document doc=pane.getDocument();
    	  doc.insertString(doc.getLength(), msg+"\n", pane.getStyle(color));
    	}catch(Exception ex){}
    	
    }
    
}

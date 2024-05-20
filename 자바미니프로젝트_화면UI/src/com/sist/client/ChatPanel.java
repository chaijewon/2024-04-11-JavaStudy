package com.sist.client;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
public class ChatPanel extends JPanel implements ActionListener{
   JTable table1,table2;
   DefaultTableModel model1,model2;
   JTextPane pane;
   JTextField tf;
   JButton b1,b2,b3,b4,b5,b6;
   JScrollBar bar;
   JComboBox<String> box=new JComboBox<String>();
   public ChatPanel()
   {
	   setLayout(null);
	   String[] col1={"방이름","상태","인원"};
	   String[][] row1=new String[0][3];
	   
	   model1=new DefaultTableModel(row1,col1);
	   table1=new JTable(model1);
	   JScrollPane js1=new JScrollPane(table1);
	   
	   js1.setBounds(10, 15, 350, 250);
	   add(js1);
	   
	   String[] col2={"ID","이름","성별","위치"};
	   String[][] row2=new String[0][4];
	   
	   model2=new DefaultTableModel(row2,col2)
	   {

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
		     
	   };
	   table2=new JTable(model2);
	   JScrollPane js2=new JScrollPane(table2);
	   
	   js2.setBounds(10, 275, 350, 200);
	   add(js2);
	   
	   pane=new JTextPane();
	   JScrollPane js3=new JScrollPane(pane);
	   pane.setEditable(false);
	   js3.setBounds(370, 15, 380, 210);
	   add(js3);
	   bar=js3.getVerticalScrollBar();
	   tf=new JTextField();
	   tf.setBounds(370, 230, 280, 30);
	   add(tf);
	   
	   box.addItem("black");
	   box.addItem("blue");
	   box.addItem("green");
	   box.addItem("magenta");
	   box.addItem("pink");
	   box.addItem("cyan");
	   box.addItem("orange");
	   box.setBounds(655, 230, 100, 30);
	   add(box);
	   
	   b1=new JButton("방만들기");
	   b2=new JButton("방들어가기");
	   b3=new JButton("쪽지보내기");
	   b4=new JButton("정보보기");
	   b5=new JButton("1:1 채팅");
	   b6=new JButton("채팅 종료");
	   
	   JPanel p=new JPanel();
	   p.setLayout(new GridLayout(3,2,5,5));
	   p.add(b1);
	   p.add(b2);
	   p.add(b3);
	   p.add(b4);
	   p.add(b5);
	   p.add(b6);
	   p.setBounds(370, 270, 380, 200);
	   add(p);
	   tf.addActionListener(this);
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
   public void append(String msg,String color)
   {
	   try
	   {
		   Document doc=pane.getDocument();
		   doc.insertString(doc.getLength(), msg+"\n",
				   pane.getStyle(color));
	   }catch(Exception ex){}
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf)
		{
			String msg=tf.getText();
			if(msg.length()<1)
				return;
			String color=box.getSelectedItem().toString();
			
			initStyle();
			append(msg, color);
			
			tf.setText("");
		}
	}
}

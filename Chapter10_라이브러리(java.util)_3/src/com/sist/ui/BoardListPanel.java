package com.sist.ui;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import java.text.*;
public class BoardListPanel extends JPanel
{
	JLabel la,pageLa;
	JButton b1,b2,b3,b4;
	JTable table;
	DefaultTableModel model;
    public BoardListPanel()
    {

    	String[] col={"번호","제목","이름","작성일","조회수"};
    	String[][] row=new String[0][5];
    	model=new DefaultTableModel(row,col)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    	    // 익명의 클래스 => 오버라이딩 
    		// 편집 방지 
    		
    	};
    	table=new JTable(model);
    	table.getTableHeader().setReorderingAllowed(false);
    	table.setShowVerticalLines(false);
    	table.setRowHeight(40);
    	table.getTableHeader().setPreferredSize(new Dimension(35,35));
    	table.getColumn("번호").setPreferredWidth(30);
    	table.getColumn("제목").setPreferredWidth(400);
    	table.getColumn("이름").setPreferredWidth(100);
    	table.getColumn("작성일").setPreferredWidth(150);
    	table.getColumn("조회수").setPreferredWidth(50);
    	
    	
    	JScrollPane js=new JScrollPane(table);
    	
    	b1=new JButton("새글");
    	b2=new JButton("검색");
    	b3=new JButton("이전");
    	b4=new JButton("다음");
    	la=new JLabel("자유 게시판");
    	pageLa=new JLabel("1 page / 1 pages");
    	
    	// 배치 
    	setLayout(null); // 사용자 정의 배치 
    	la.setHorizontalAlignment(JLabel.CENTER);
    	la.setFont(new Font("굴림체",Font.BOLD,35));
    	la.setBounds(10, 15, 710, 50);
    	add(la);
    	
    	b1.setBounds(10,75, 100, 30);
    	add(b1);
    	
    	js.setBounds(10, 115, 710, 450);
    	add(js);
    	
    	JPanel p=new JPanel();
    	p.add(b3);
    	p.add(pageLa);
    	p.add(b4);
    	
    	p.setBounds(10, 570, 710, 35);
    	add(p);
    	
    	
    }
}
package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import com.sist.commons.*;
import com.sist.dao.*;
public class MyPagePanel extends JPanel{
    JLabel titleLa;
    JTable table;
    DefaultTableModel model;
    GoodsDAO dao;
    ControllPanel cp;
    
    public MyPagePanel(ControllPanel cp)
    {
    	this.cp=cp;
    	dao=GoodsDAO.newInstance();
    	titleLa=new JLabel("장바구니",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30));
    	setLayout(null);
    	titleLa.setBounds(70, 15, 700, 50);
    	
    	add(titleLa);
    }
}

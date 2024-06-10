package com.sist.client;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
// 사번의 정보를 출력 => 조인 
public class EmpListPanel extends JPanel{
    JLabel titleLa;
    JTable table;
    DefaultTableModel model;
    
    public EmpListPanel()
    {
    	setLayout(null);
    	titleLa=new JLabel("사원 정보",JLabel.CENTER);
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,35));
    	titleLa.setBounds(10, 15, 930, 40);
    	add(titleLa);
    }
}

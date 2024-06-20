package com.sist.client;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.*;
import com.sist.commons.*;
import com.sist.dao.*;
import java.util.List;
import java.util.*;
import java.net.*;
public class MyPagePanel extends JPanel implements MouseListener{
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
    	titleLa.setBounds(70, 15, 800, 50);
    	
    	add(titleLa);
    	
    	String[] col={"번호","상품명","","구매가격","수량"};
    	Object[][] row=new Object[0][5];
    	model=new DefaultTableModel(row,col)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}

    	};
    	table=new JTable(model);
    	table.setRowHeight(50);
    	JScrollPane js=new JScrollPane(table);
    	
    	js.setBounds(70, 75, 800, 400);
    	add(js);
    	
    	table.addMouseListener(this);
    	
    }
    public void print()
    {
    	String id=cp.cMain.myId;
    	System.out.println("ID="+id);
    	List<CartVO> list=dao.cartSelect(id);
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	
    	for(CartVO vo:list)
    	{
    		try
    		{
    			URL url=new URL(vo.getGvo().getGoods_poster());
    			Image img=ImageChange.getImage(new ImageIcon(url), 45, 45);
    			Object[] data={
    					vo.getCno(),
    					vo.getGvo().getGoods_name(),
    					new ImageIcon(img),
    					vo.getPrice(),
    					vo.getAccount()
    			};
    			model.addRow(data);
    		}catch(Exception ex) {}
    	}
    	
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)
			{
				int row=table.getSelectedRow();
				String cno=model.getValueAt(row, 0).toString();
				
				int sel=JOptionPane.showConfirmDialog(this, "장바구니에서 삭제할까요?",
						"삭제",JOptionPane.YES_NO_OPTION);
				if(sel==JOptionPane.YES_OPTION)
				{
					dao.cartCancel(Integer.parseInt(cno));
					print();
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

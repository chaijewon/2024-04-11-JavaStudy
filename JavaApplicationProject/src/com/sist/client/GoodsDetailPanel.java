package com.sist.client;

import javax.swing.*;
import java.net.*;
import com.sist.dao.*;
import com.sist.commons.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
public class GoodsDetailPanel extends JPanel implements ActionListener,ItemListener{
  JLabel la1,la2,la3,la4,la5,la6,la7,la8;
  JButton b1,b2;
  JComboBox<Integer> box;
  JLabel pLa,tLa;
  ControllPanel cp;// 화면 이동
  GoodsDAO dao;
  public GoodsDetailPanel(ControllPanel cp)
  {
	  dao=GoodsDAO.newInstance();
	  this.cp=cp;
	  setLayout(null);
	  la1=new JLabel();
	  la1.setBounds(10, 15, 450, 550);
	  add(la1);
	  
	  la2=new JLabel();
	  la2.setBounds(470, 15, 400, 45);
	  add(la2);
	  la3=new JLabel();
	  la3.setBounds(470, 70, 350, 30);
	  add(la3);
	  la4=new JLabel();
	  la4.setBounds(470, 110, 60, 30);
	  add(la4);
	  la5=new JLabel();
	  la5.setBounds(540, 110, 120, 30);
	  add(la5);
	  la6=new JLabel();
	  la6.setBounds(470, 150, 120, 30);
	  add(la6);
	  la7=new JLabel();
	  la7.setBounds(600, 150, 120, 30);
	  add(la7);
	  la8=new JLabel();
	  la8.setBounds(470, 190, 120, 30);
	  add(la8);
	  b1=new JButton("장바구니");
	  b2=new JButton("목록");
	  JPanel p=new JPanel();
	  p.add(b1);p.add(b2);
	  p.setBounds(470,350 , 350 , 35);
	  add(p);
	  pLa=new JLabel("가격:");
	  pLa.setBounds(470, 270, 200, 30);
	  add(pLa);
	  tLa=new JLabel("구매 총 가격:");
	  tLa.setBounds(470, 310, 200, 30);
	  add(tLa);
	  box=new JComboBox<Integer>();
	  box.addItem(1);
	  box.addItem(2);
	  box.addItem(3);
	  box.addItem(4);
	  box.addItem(5);
	  box.addItem(6);
	  box.addItem(7);
	  box.setBounds(470, 230, 200, 30);
	  add(box);
	  
	  b2.addActionListener(this);
	  box.addItemListener(this);
  }
  public void print(int no)
  {
	  // 1. 오라클에서 값을 받는다 
	  GoodsVO vo=dao.goodsDetailData(no);
	  try
	  {
		  URL url=new URL(vo.getGoods_poster());
		  Image img=ImageChange.getImage(new ImageIcon(url), 450, 550);
		  la1.setIcon(new ImageIcon(img));
	  }catch(Exception ex){}
	  la2.setText("<html><b>"+vo.getGoods_name()+"</b></html>");
	  la3.setText("<html><font color=gray>"+vo.getGoods_sub()+"</font></html>");
	  la4.setText("<html><font color=pink>"+vo.getGoods_discount()+"%</font></html>");
	  la5.setText(vo.getGoods_price());
	  la6.setText("<html><font color=green>첫구매할인가</font></html>");
	  la6.setText("<html><font color=green>"+vo.getGoods_first_price()+"</font></html>");
	  la7.setText("배송:"+vo.getGoods_delivery());
	  pLa.setText("가격:"+vo.getGoods_price());
	  tLa.setText("구매 총 가격:"+vo.getGoods_price());
  }
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box)
		{
			String price=pLa.getText();
			price=price.substring(price.indexOf(":")+1);
			price=price.replaceAll("[^0-9]", "");
			
			int account=box.getSelectedIndex()+1;
			int total=Integer.parseInt(price)*account;
			
			DecimalFormat df=new DecimalFormat("##,###,###");
			String s=df.format(total);
			tLa.setText("구매 총 가격:"+s+"원");
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			cp.card.show(cp, "HP");
		}
	}
  
}

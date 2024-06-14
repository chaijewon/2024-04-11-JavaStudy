package com.sist.client;

import javax.swing.*;
import com.sist.dao.*;
import java.awt.*;
import java.util.ArrayList;
public class HomePanel extends JPanel{
	   JButton b1,b2,b3;
	   PosterCard[] pcs=new PosterCard[12];
	   JPanel pan=new JPanel();
	   int curpage=1;
	   int totalpage=0;
	   public HomePanel()
	   {
		     
		      GoodsDAO dao=GoodsDAO.newInstance();
		      ArrayList<GoodsVO> list=
					dao.goodsListData(curpage);
		      System.out.println(list);
		      pan.setLayout(new GridLayout(4,3,5,5));
		      setLayout(new BorderLayout());
		      JScrollPane pp=new JScrollPane();
		      Dimension size = new Dimension();//사이즈를 지정하기 위한 객체 생성
		      size.setSize(960, 700);//객체의 사이즈를 지정
		      pan.setPreferredSize(size);//사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정
		      pp.setViewportView(pan);
		      add("Center",pp);
		      
		      cardPrint(list);
		      //cardInit(list);
			  

	   }
	   public void cardPrint(ArrayList<GoodsVO> list)
	   {
		   int i=0;
		   for(GoodsVO vo:list)
		   {
			   //System.out.println(vo.getPoster().substring(0,vo.getPoster().lastIndexOf("?")));
			   pcs[i]=new PosterCard(vo);
			   
			   pan.add(pcs[i]);
			   //pcs[i].addMouseListener(this);
			   i++;
		   }
		   
	   }
	   public void cardInit(ArrayList<GoodsVO> list)
	   {
		   for(int i=0;i<list.size();i++)
		   {
			   pcs[i].poLa.setIcon(null);
			   pcs[i].tLa.setText("");
		   }
		   pan.removeAll();// 데이터 제거
		   pan.validate();// Panel 재배치 
	   }

}

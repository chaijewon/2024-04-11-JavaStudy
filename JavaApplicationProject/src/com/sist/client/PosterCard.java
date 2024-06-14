package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.net.*;

import com.sist.commons.ImageChange;
import com.sist.dao.*;
public class PosterCard extends JPanel{
   JLabel poLa=new JLabel();
   JLabel tLa=new JLabel();
   public PosterCard(GoodsVO vo)
   {
	   setLayout(null);
	   poLa.setBounds(5, 5, 250, 150);
	   //poLa.setBorder(new LineBorder(Color.blue));
	   tLa.setBounds(5, 110, 250, 30);
	   //tLa.setBorder(new LineBorder(Color.blue));
	   add(poLa);
	   add(tLa);
	   
	   try
	   {
		   if(vo.getGoods_poster()!=null)
		   {
		     URL url=new URL(
				   vo.getGoods_poster());
		     Image image=ImageChange.getImage(new ImageIcon(url),
				   250, 150);
		     poLa.setIcon(new ImageIcon(image));
		   }
		   else
		   {
			     Image image=ImageChange.getImage(
			    		 new ImageIcon(vo.getGoods_poster()),
					   250, 150);
			     
			     poLa.setIcon(new ImageIcon(image)); 
		   }
		   tLa.setText(vo.getGoods_price());
		   System.out.println(vo.getGoods_poster());
	   }catch(Exception ex) {ex.printStackTrace();}
   }
}

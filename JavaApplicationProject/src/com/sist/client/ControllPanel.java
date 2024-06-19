package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
   CardLayout card=new CardLayout();
   //EmpListPanel ep=new EmpListPanel();
   HomePanel hp;
   GoodsDetailPanel dp;
   FindPanel fp;
   BoardListPanel bp;
   BoardInsertPanel bip;
   BoardDetailPanel bdp;
   BoardDeletePanel bdelP;
   BoardUpdatePanel bup;
   ChatPanel chatP=new ChatPanel();
   // 웹에서 => 화면 변경 => Controller 
   /*
    *    처리 : Model 
    *    화면 : View 
    *    화면변경 : Controller ==> MVC
    *    
    *    최근 => Spring MVC가 사라졌다
    *          ----------- JSP 
    *                      ThymeLeaf / Vue / React => HTML
    */
   public ControllPanel()
   {
	   setLayout(card);
	   //add("EP",ep);
	   hp=new HomePanel(this);
	   dp=new GoodsDetailPanel(this);
	   fp=new FindPanel(this);
	   bp=new BoardListPanel(this);
	   bip=new BoardInsertPanel(this);
	   bdp=new BoardDetailPanel(this);
	   bdelP=new BoardDeletePanel(this);
	   bup=new BoardUpdatePanel(this);
	   add("HP",hp);
	   add("CHAT",chatP);
	   add("DP",dp);
	   add("FP",fp);
	   add("LIST",bp);
	   add("INSERT",bip);
	   add("DETAIL",bdp);
	   add("DELETE",bdelP);
	   add("UPDATE",bup);
	  
   }
}

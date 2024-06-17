package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
   CardLayout card=new CardLayout();
   //EmpListPanel ep=new EmpListPanel();
   HomePanel hp=new HomePanel();
   ChatPanel chatP=new ChatPanel();
   public ControllPanel()
   {
	   setLayout(card);
	   //add("EP",ep);
	   add("CHAT",chatP);
	   add("HP",hp);
	  
   }
}

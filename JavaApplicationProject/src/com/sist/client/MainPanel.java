package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MainPanel extends JPanel{
     
     CardLayout card=new CardLayout();
     //EmpListPanel ep=new EmpListPanel();
     HomePanel hp=new HomePanel();
     ChatPanel chatP=new ChatPanel();
     public MainPanel()
     {
  	   setLayout(card);
  	   //add("EP",ep);
  	   add("CHAT",chatP);
  	   add("HP",hp);
  	   
     }
}

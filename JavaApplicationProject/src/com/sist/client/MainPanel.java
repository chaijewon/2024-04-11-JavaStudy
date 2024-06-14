package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MainPanel extends JPanel{
     MenuPanel mp=new MenuPanel();
     ControllPanel cp=new ControllPanel();
     //EmpListPanel ep=new EmpListPanel();
     public MainPanel()
     {
    	 setLayout(null);
    	 mp.setBounds(100, 15, 800, 50);
    	 add(mp);
    	 cp.setBounds(10, 70, 830, 620);
    	 add(cp);
     }
}

package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MainPanel extends JPanel{
     MenuPanel mp=new MenuPanel();
     ControllPanel cp=new ControllPanel();
     //EmpListPanel ep=new EmpListPanel();
     public MainPanel()
     {
    	 setLayout(new BorderLayout());
    	 add("North",mp);
    	 add("Center",cp);
     }
}

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class MyWindow extends JFrame{
    public MyWindow()
    {
    	JButton b1=new JButton("Click");
    	JButton b2=new JButton("Click");
    	JButton b3=new JButton("Click");
    	JButton b4=new JButton("Click");
    	JButton b5=new JButton("Click");
    	setLayout(new FlowLayout());
    	add(b1);
    	add(b2);
    	add(b3);
    	add(b4);
    	add(b5);
    	setSize(640, 480);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try
        {
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        	UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        }catch(Exception ex) {}
        new MyWindow();
	}

}

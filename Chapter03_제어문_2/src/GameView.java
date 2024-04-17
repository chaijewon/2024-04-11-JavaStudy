import java.awt.*;
import javax.swing.*;
public class GameView extends JPanel {
    Image back,horse;
    int x=750;
    int y=500;
    public GameView()
    {
    	// 변수의 초기화 => 생성자 
    	back=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\back.jpg");
    	horse=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\horse.gif");
    }
	@Override
	public void paint(Graphics g) {
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
		g.drawImage(horse,x,y,120,80,this);
	}
    
    
}

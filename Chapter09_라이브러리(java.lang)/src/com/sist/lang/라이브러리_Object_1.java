package com.sist.lang;
// toString
import javax.swing.*;
import java.awt.event.*;
/*
 *    class JFrame extends Object
 *    class 라이브러리_Object_1 extends JFrame 
 *          ---------------- Object,JFrame 
 *          
 *    클래스의 크기 
 *    ---------
 *      상속 => 상속을 내리는 클래스 > 상속을 받는 클래스 
 *      포함 => 포함하고 있는 클래스가 크기가 크다 
 */
class A
{
    static int[] arr=new int[10]; // A.arr
    static 
    {
    	//초기화 => 자동 호출 
    }
}
public class 라이브러리_Object_1 extends JFrame implements ItemListener{
    JComboBox box;
    JLabel la;
    ///// ==> 포함 클래스 => has-a 
    public 라이브러리_Object_1()
    {
    	// 인스턴스 변수/클래스는 => 초기화 (생성자) => 가장 먼저 호출을 해야 된다 
    	// static => 자동 메모리 저장 => 생성자가 필요없는 경우도 존재 => static{}
    	box=new JComboBox();
    	box.addItem("홍길동");
    	box.addItem("심청이");
    	box.addItem("이순신");
    	box.addItem("박문수");
    	box.addItem("강감찬");
    	// 원형 => 접근지정어 (public) , 리턴형 / 매개변수 
    	/*
    	 *   Object는 가장 큰 데이터형이다 => 모든 데이터를 받을 수 있다 
    	 *   Object o=""
    	 *   o=10
    	 *   o=10.9
    	 *   o=true
    	 *   o=new A()
    	 *   Object[] =>  데이터형을 섞어서 사용이 가능 
    	 *   
    	 */
    	la=new JLabel("",JLabel.CENTER);
    	
    	// 배치 
    	setLayout(null);
    	box.setBounds(10, 15, 300, 30);
    	la.setBounds(10, 50, 300, 30);
    	
    	add(box);
    	add(la);
    	
    	setSize(350, 150);
    	setVisible(true);
    	
    	box.addItemListener(this);//이벤트 등록 => 선택시마다 itemStateChanged() 호출 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자 호출 
		new 라이브러리_Object_1();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box)//box에서 선택이 되었다면 
		{
			String name=box.getSelectedItem().toString();// 객체를 문자열로 변환 
			la.setText(name);
		}
	}

}

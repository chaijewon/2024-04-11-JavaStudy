package com.sist.main;
class Movie
{
	void display() {}
}
class MegaBox extends Movie
{
	// int display() {} => 리턴형이 동일 
	// void display() {}
	int display(int a) {
		return 10;
	}// 오버로딩 => 다른 메소드 선언 
	//protected void display() {}
	public void display() {}
	/*
	 *   1. 상속 => 재정의 (메소드 내용을 변경해서 사용)
	 *   2. 메소드명 동일하다 
	 *   3. 매개변수가 동일 (매개변수가 다른 경우 => 메소드가 다른 것을 정의 => 오버로딩) 
	 *   4. 리턴형이 동일하다 
	 *   5. 접근지정어가 동일 , 확대가 되어야 한다 
	 *   
	 *   private < default < protected < public 
	 *             -------              -------
	 *   => 라이브러리 => 오버라이딩 
	 *      ------------------ 한국 IT개발에 잘 맞지 않는다 
	 *   => 상속여러개 있는 경우에는 가장 큰 클래스를 상속을 받는다 
	 *      ----------------------------------------
	 *       JButton , JTextField , JFrame 
	 *                              -------
	 */
}
public class MainClass_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

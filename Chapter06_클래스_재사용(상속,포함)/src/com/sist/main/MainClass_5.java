package com.sist.main;
/*
 *   상속 
 *    => 사용자 정의 클래스는 상속으로 사용을 잘 않한다 
 *    => 라이브러리 클래스 
 *       ------------
 *    => 단일 상속 
 *       => 상위클래스는 가급적인 공통기반을 모아서 처리 
 *          class 사람 => 재사용 
 *             |
 *     extend 사람  
 *      ---------------------
 *      |      |     |      |
 *     회사원   학생   교직원   교수  
 *     
 *     => 메모리에 저장 
 *        상위 클래스 = 하위클래스 
 *        ------------------
 *        상위 클래스 = 상위클래스 
 *        하위 클래스 = 하위클래스 
 *        하위 클래스 = (하위클래스)상위클래스 
 *        
 *        => 클래스 크기는 상속이 있어야 가능 
 *           ------------- 
 *           상속내리는 클래스 > 상속 받는 클래스 
 *           --------------------------
 *           = 선언되는 클래스 : 변수  
 *           = 생성자 : 메소드 지정 
 *           
 *       class Super
 *       {
 *          int a=10;
 *          int b=20;
 *          public void display()
 *          {
 *             System.out.println("Super:display() Call...")
 *          }
 *       }
 *       class Sub extends Super
 *       {
 *           int a=100;
 *           int b=200;
 *           public void display()
 *          {
 *             System.out.println("Sub:display() Call...")
 *          }
 *       }
 *       
 *       Super sup=new Super();  sup=> a=10,b=20, Super:display() Call...
 *       Sub sub=new Sub(); sub=> a=100,b=200 , Sub:display() Call...
 *       
 *       Super sup2=new Sub()
 *       -----      ---------
 *       a=10,b=20   Sub:display() Call... => 오버라이딩 
 *                   => 생성자에 따라서 메소드가 덮어쓴다 
 */
// 동물
class A
{
	int a=10;
	int c=20;
	public void display()
	{
		System.out.println("A:display() Call...");
	}
}
// 사람 
class B extends A implements Cloneable
{
	
	int a=100;
	int c=200;
	public void display()
	{
		System.out.println("B:display() Call...");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
// A aa=new B() ==> (X)
public class MainClass_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A aa=new A();
        System.out.println(aa.a);
        System.out.println(aa.c);
        aa.display();
        
        System.out.println("=====================");
        // 가장 많이 사용 
        B bb=new B();
        System.out.println(bb.a);
        System.out.println(bb.c);
        bb.display();
        try {
			B kk=(B)bb.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("=====================");
        // 2번 
        A cc=new B();
        System.out.println(cc.a);//10
        System.out.println(cc.c);//20
        // 상위 = 하위  => 변수 (상위)
        cc.display();//new B() => B가 가지고 있는 메소드 
        
        System.out.println("=====================");
        B dd=(B)cc;
        // 라이브러리 => 형변환 
        System.out.println(dd.a);
        System.out.println(dd.c);
        dd.display();//B 
        
        
        
	}

}

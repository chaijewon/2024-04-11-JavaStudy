package com.sist.main3;
interface A
{
	public void aaa();
}
interface B
{
	public void bbb();
}
// 다중 상속 => ,로 구분 
/*
 *   자신의클래스 = 자신의생성자()
 *   ---------------------
 *   상위클래스=하위클래스생성자()
 *   
 *   class A
 *   class B extends A
 *   
 *   A a=new A()
 *   B b=new B()
 *   A c=new B()
 *   -----------
 *   
 *   interface A
 *   class B implements A
 *   
 *   A a=new A() => 불가능 => interface,추상클래스는 메모리 할당이 불가능하다 (미완성)
 *   B b=new B()
 *   -----------
 *   A c=new B() => 구현된 클래스를 이용해서 메모리 저장 
 *   -----------
 *     => 구현한 클래스 , 오버라이딩 
 */
class C implements A,B
{

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		System.out.println("C:bbb() Call...");
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		System.out.println("C:aaa() Call...");
	}
	
}
/*
 *   상속을 받은 경우 
 *   ------------
 *   1. 변수 ==============> 클래스 선언 
 *   2. 메소드 =============> 생성자 => 메소드를 덮어쓴다 
 *   
 *   class A
 *   {
 *       int a,b;
 *       public void aaa(){} // public void aaa(){}
 *   }
 *   A aa=new A();
 *   ---- -------
 *   |변수  |메소드    => aa.a aa.b aa.aaa()
 *   class B
 *   {
 *       int c;
 *       public void bbb(){}
 *   }
 *   B bb=new B()
 *   ---- -------
 *   | bb.c => bb.bbb()
 *   
 *   class C extends A
 *   {
 *      -------------------------
 *       int a,b;
 *       public void aaa(){}
 *       ------------------------ 상속 
 *       int d;
 *       public void ddd(){}
 *   }
 *   
 *   C c=new C(); ==> C가 가지고 있는 모든 내용 a,b,aaa(),d,ddd()
 *   A a=new C();
 *   --- -------- 
 *       aaa()는 C가 가지고 있는 aaa()를 사용한다  (ddd()는 사용이 안된다)
 *   A안에 있는 a,b
 *   
 *   
 *   interface A
 *   {
 *      void aaa();  
 *   }
 *   interface B
 *   {
 *      void bbb();
 *   }
 *   extends / implements => 상속 과정 
 *   class C implements A,B
 *           ---------- 상속 
 *   {
 *      aaa()
 *      bbb()
 *   }
 *   
 *   A a=new C() => a.aaa()
 *   ---
 *   B b=new C() => b.bbb()
 *   ---
 *   C c=new C() => c.aaa(),c.bbb() ==> 다중 상속시에는 
 *   
 *   A a; => 제어가 가능 => a가 가지고 있는 변수,메소드만
 *   B b; => b가 가지고 있는 변수,메소드만 
 *   --- 
 *   
 */
// => 다중 상속 , 필요시에는 단일 상속을 받을 수 있다
interface AA
{
	void aaa();
}
interface BB extends AA
{
	// aaa()
	void bbb();
}
class CC implements BB
{

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
	
}
public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new C();// => aaa() 호출 가능
        // 클래스명 
        a.aaa();
        
        B b=new C();// => bbb() 호출 가능
        b.bbb();
        // => 다중 상속시에는 상속받은 클래스 이용 => 모든 메소드를 가지고 있기 때문에 ..
        C c=new C();// => aaa(),bbb()
        c.aaa();c.bbb();
        
        BB bb=new CC();
        bb.aaa();
        bb.bbb();
	}

}

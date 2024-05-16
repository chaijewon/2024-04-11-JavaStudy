package com.sist.main2;
class AA
{
	int a=10;
	int b=20;
	public void aaa()
	{
		System.out.println("A:aaa() Call...");
	}
}
// AA a=new AA() ==> a,b,aaa()
class BB extends AA
{
	// int a=10,b=20; aaa() => 수정 (오버라이딩)
	int c=30;
	// 수정 
	public void aaa()
	{
		System.out.println("B:aaa() Call...");
	}
	public void bbb()
	{
		System.out.println("B:bbb() Call...");
	}
}
// BB b=new BB() ==> c , aaa() , bbb()
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("===== AA ======");
		AA aa=new AA(); //AA에 설정된 변수,메소드에만 접근이 가능
        
        System.out.println(aa.a);
        System.out.println(aa.b);
        aa.aaa();
        System.out.println("===== BB ======");
        BB bb=new BB();
        System.out.println(bb.c);
        bb.aaa();
        bb.bbb();
        System.out.println(bb.a);
        System.out.println(bb.b);
        System.out.println("==== AA:new BB() =====");
        AA cc=new BB();
        // 변수는 AA가 가지고 있는 것만 사용이 가능 
        // 메소드는 BB가 가지고 있는 것을 호출 
        // cc=> a,b (c는 사용이 불가능) => 변경된 aaa()를 호출한다 
        System.out.println(cc.a);//AA
        System.out.println(cc.b);//AA
        cc.aaa(); // BB가 가지고 있는 메소드 
        /*
         *   기본 
         *   클래스명 객체명=new 생성자()
         *   -----          ------
         *     |               |
         *     ----------------- 같다 
         *     
         *   클래스명 객체명=new 생성자()
         *   -----          ------
         *     |              |
         *     ---------------- 다르다 
         *   = 상속이 있는 경우에만 가능 
         *   = 상속내리는 클래스와 상속받는 클래스가 변수,메소드가 동일한 경우에만 
         *                   ----------- 추가된 변수 ,메소드가 있는 경우에는 사용하지 않는다 
         *                               ---------------------- 접근이 불가능 
         *                               
         *   = 상속받은 클래스가 여러개인 경우에 주로 사용한다 
         *     => 한개의 객체로 모든 클래스를 제어 
         *     
         *   class A
         *   class B extends A
         *   class C extends A
         *   class D extends A
         *   class E extends A
         *   
         *   B b=new B()
         *   C c=new C()
         *   D d=new D()
         *   E e=new E() 
         *   --------------- 객체를 여러개 생성하는 것이 아니라 
         *   A a=new B()
         *   a=new C()
         *   a=new D()
         *   a=new E()
         *   ---------------- 한개의 객체를 이용한다 
         *   ----------------------------------------> 추상클래스 , 인터페이스 
         *   => 목적 
         *      여러개의 관련된 클래스를 한개로 묶어서 관리할 목적 
         *      설계용 => 다음에 재사용을 할 수 있다 
         *   => 단점 : 단일 상속 
         *            => 일반 클래스와 동일하다 
         *               멤버변수 , 생성자 , 구현된 메소드 
         *               : 구현이 안된 메소드가 포함 
         *           
         *   사이트 
         *     맛집 / 영화 
         *     ---------
         *     영화 => 로그인 , 회원가입 , 영화 목록 / 영화 상세 / 예약 
         *           -------------  ----------------------- 
         *     맛집 => 로그인 , 회원가입 , 맛집 목록 / 맛집 상세 / 예약
         *           -------------  -----------------------
         *   public abstract class ClassName
         *   {
         *       -----------------------------
         *         변수 
         *          static / 인스턴스변수 
         *       -----------------------------
         *         생성자 : 디폴트만 사용하는 것을 권장 
         *       -----------------------------
         *         구현된 메소드 
         *           => 사이트에서 같은 기능 
         *              로그인 / 회원가입 / 아이디찾기 / 비밀번호 찾기 / 아이디 중복 / 우편번호 찾기 
         *       -----------------------------
         *         구현이 안된 메소드 => 추상메소드
         *           => 기능은 같은데 출력내용이 다른 경우  
         *           => 목록 / 상세 / 예약 / 결제 ....
         *       -----------------------------
         *   }           
         */
	}

}

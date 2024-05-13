package com.sist.main;
// 메소드 오버라이딩 ==> 204page => 가장 많이 사용 
class Music
{
	int count=10;
	public void list()
	{
		System.out.println("목록 출력");
	}
	public void detail()
	{
		System.out.println("상세보기");
	}
	public void find()
	{
		System.out.println("뮤직 검색");
	}
}
class Genie extends Music
{
    int musiccount=200;
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 검색수행");
	}
	// 목록 출력 
	// 상세보기 
	// 검색 
	
}
class Melon extends Music
{
	// 목록 출력 
    // 상세보기 
	// 검색 
	public void list()
	{
		System.out.println("Melon에서 목록 출력");
	}
	
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 상세보기");
	}

	
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 검색수행");
	}
}
class Mnet extends Music
{
	// 목록 출력 
	// 상세보기 
	// 검색 
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 검색수행");
	}
}
public class MainClass_8 {
    // 유사한 클래스를 여러개 모아서 1개 객체로 제어 => 상속
	/*
	 *   상속을 받는 경우 
	 *   
	 *   변수 : 선언하는 클래스명 
	 *   메소드 : 생성자에 따라 
	 *   생성자 => 상속의 제외 조건
	 *   
	 *   class A
	 *   class B extends A
	 *   
	 *   A a=new B()   변수: A    메소드: B ==> 클래스가 여러개 
	 *   A a=new A()   변수:A     메소드 : A
	 *   B b=new B()   변수 : B   메소드 : B  ******
	 *   -----------------------------------
	 *   B b=new A() => 라이브러리 (값을 받는 경우)
	 *   ------------- 오류 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("===== 지니뮤직 =====");
		Music m=new Genie();
		// Genie g=new Genie()
		// 메소드 호출 => 생성자 
        m.detail();
        m.list();
        m.find();
        System.out.println("===== 멜론 ======");
        m=new Melon();
        m.detail();
        m.list();
        m.find();
        
        System.out.println("===== Mnet =====");
        m=new Mnet();
        m.detail();
        m.list();
        m.find();
        
        
	}

}

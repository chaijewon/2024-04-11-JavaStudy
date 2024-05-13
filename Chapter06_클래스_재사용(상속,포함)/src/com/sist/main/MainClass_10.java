package com.sist.main;
/*
 *  206page / 207page 
 *  --------  --------
 *             상속에서 접근지정어 
 *    오버로딩 / 오버라이딩 => 면접 (97%) , 7장 (추상클래스 / 인터페이스) => 85%
 *               | 라이브러리                         | Spring기반 
 *    
 *    오버로딩 : 중복 메소드 정의 => 같은 기능 
 *      예) print(int) print(char) print(char[]) ...
 *         ----------------------------------------
 *         printInt() printChar ...
 *         
 *         => 사칙연산 
 *            plus(byte, byte)
 *                 byte int 
 *                 byte short
 *                 byte long
 *                 byte float
 *                 byte char
 *                 byte double 
 *                 7 
 *                 short 
 *                 7
 *                 int 
 *                 7
 *                 char
 *                 7 
 *      => 버스 
 *         버스 => 일반버스 
 *         버스(좌석)
 *         버스(마을) 
 *         버스(고속엔진) 
 *         
 *    오버라이딩 : 기존의 클래스를 상속을 받아서 => 재정의 (메소드 기능을 변경)
 *              --------------               ---------------
 *    ------------------------------------------------------------
 *                   오버 로딩                     오버라이딩
 *    ------------------------------------------------------------
 *    상태           같은 클래스내에서                   상속 
 *             class A
 *             {
 *                 public void aaa(){}   ===> aaa()
 *                             -----
 *                 public void aaa(int a){} ==> aaa(int)
 *                             ----------
 *                 public void aaa(char c){} ==> aaa(char) ----
 *                             -----------                     |-- 같은 메소드 
 *                 public void aaa(char k){}  ==> aaa(char)----
 *                 public void aaa(int a, int b){} ===> aaa(int,int)
 *                             -----------------
 *                 public int aaa(double d){} =>aaa(double)
 *                            -------------
 *                 void aaa(float f){} == aaa(float)
 *                      ------------
 *             }
 *    ------------------------------------------------------------
 *    메소드명         동일                             동일
 *    ------------------------------------------------------------
 *    매개변수      갯수,데이터형이 다른다                   동일 
 *    ------------------------------------------------------------
 *    리턴형          관계없다                          동일 
 *    ------------------------------------------------------------
 *    접근지정어       관계없다                           확대만 가능 
 *    ------------------------------------------------------------
 *     접근지정어의 크기 
 *        private < default < protected < public 
 *                                        ------- 기본 (public)
 *                                        
 *     오버라이딩 => 상속 
 *                예외조건)
 *                       static : 상속은 안된다 => 사용이 가능하게 만든다 (공유)
 *                       private : 상속은 가능 => 접근이 불가능 
 *                          => protected
 *                       생성자
 *                       초기화블록 
 *                       ------------------
 *                       멤버변수(인스턴스) =====> 변수값 변경 (변수 오버라이딩)
 *                       메소드 ==============> 기능 변경 (메소드 오버라이딩)
 *                       ------------------ 상속
 *                       
 *             메소드의 종류 
 *             1. 인스턴스메소드 : NEW에 의해서 따라 저장 
 *             2. 공통메소드 : static => 상속의 예외 조건 => 변경 (전체 변경) => 오버라이딩이 안된다 
 *             3. 종단 메소드 : 확장이 불가능 => 변경이 불가능 => final
 *             -------------------------------------------------------------------
 *              권장) 메소드의 접근지정어는 가급적이면 public 
 *              ----------------------------------
 *              
 *              접근지정어 
 *              -------
 *               public : 생성자 , 클래스 , 메소드 , 인터페이스 
 *                        => 다른 클래스와 연결  
 *               private : 멤버변수 => 데이터 노출 방지 (데이터 보호) 
 *                        => 다른 클래스에서 사용 
 *                           => 변수 기능의 메소드 제작 
 *                              -----------------
 *                              메모리 저장 / 메모리에 읽어오기 
 *                              --------  -------------
 *                              |set변수명()  | get변수명()
 *                         => class A
 *                            {
 *                                private String name;
 *                                private boolean login;
 *                                public void getName()
 *                                               -
 *                                public void isLogin()
 *                                              -
 *                            }
 *                            
 *                            class B
 *                            {
 *                                A a=new A();
 *                                
 *                            }
 *               
 *             class 영역 
 *             ---------------------
 *              static메소드 : 기본은 static 메소드 , static 변수만 사용이 가능 
 *                 => 인스턴스메소드 , 인스턴스변수는 사용할 수 없다
 *                 => this가 없다
 *              인스턴스메소드 : 인스턴스메소드 , 인스턴스변수, static변수 , static메소드 사용이 가능 
 *             --------------------- this가 있다 
 */
class ABC
{
	public void display1() {}// 멤버메소드 => 오버라이딩이 가능 
	public static void display2() {} // 공통메소드 
	public final void display3() {} // 종단메소드 => 변경할 수 없는 메소드 
}
class BCD extends ABC
{
	public void display1() {}// 멤버메소드 
	// public static void display2() {} // 공통메소드 
	// public final void display3() {} // 종단메소드
}
// 인스턴스 메소드 , 인스턴스변수 => 중심 , static은 데이터베이스 => MyBatis => 2차 (Spring)
// => 실무 : SpringFramework + MyBatis => MySQL
class DGB
{
	
	// this. ==> DGB가 가지고 있는 변수 
	// 생성자 , 멤버 메소드에만 존재 => static메소드는 this가 없다 => 멤버변수를 사용 할 수 없다
	private String name;
	private boolean login;
	private static int age;
	public void display()
	{
		
		this.name="홍길동";
		name="";
		age=100;
		aaa();
	}
	public static void aaa()
	{
		// 클래스의 멤버변수가 아니다 => 공통 사용부분을 구사 
		System.out.println(age);
		
	}
	public String getName() {
		return name;
	}
	// 변수가 충돌이 안되면 this.생략 할 수 있다 
	public void setName(String n) {
		name = n;
		// 지역변수 우선순위 
		// 지역변수,매개변수 ====> 멤버변수 
	}
	// 읽기 
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
	
}
public class MainClass_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

}

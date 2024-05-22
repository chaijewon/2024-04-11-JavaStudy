package com.sist.lang;
/*
 *    java.lang / java.util / java.io / java.net / java.sql 
 *    ---------   ---------                        --------- 웹관련 핵심 라이브러리 
 *                               |         |
 *                                       브라우저에서 한글인식 => 인코딩 / 디코딩 => 한글 깨짐방지
 *                            파일업로드/다운로드(자료실)
 *    라이브러리 => 자바에서 지원하는 클래스의 집합(API)
 *              ---------- 사용법 , 사용용도 
 *    => 프로그램은 라이브러리+사용자 정의
 *              ----------------- 조립 
 *              라이브러리는 변수는 존재하지 않고 => 메소드 (어떤 기능)
 *    java.lang : 자바의 기본적으로 사용이 많은 클래스 모아서 관리 => import를 생략할 수 있다 
 *    ---------- 292page 
 *      = Object : 자바의 모든 클래스(사용자 정의)의 상위 클래스 => 최상위 클래스 
 *                 => 모든 클래스는 Object로부터 상속을 받는다 
 *                 => 생략이 가능 => extends Object
 *                 => 데이터형중에 가장 큰 데이터형 
 *                    --------------------- 모든 데이터를 받아서 저장이 가능 
 *                 => 라이브러리의 메소드의 리턴형은 대부분이 Object => 객체 형변환 
 *                                                          --------
 *                 class A (extends Object)
 *                 {
 *                     int a;
 *                     int b;
 *                     public void display(){}
 *                 }
 *                 
 *                 => Object obj=new A();
 *                    obj는 a,b,display() => 가지고 있지 않는다 
 *                 => A a=(A)obj 
 *                 => 상위 클래스는 하위클래스의 변수,메소드에 접근이 불가능하다
 *                 => 형변환 => 데이터형의 크기 변경 
 *                    -----------------------
 *                    | 상속 / 포함 
 *                      
 *                    상속 :  상속을 내리는 클래스 > 상속을 받는 클래스
 *                                            -------------
 *                                            | 추가된 기능 , 상속받은 기능 
 *                                 | 상속받은 클래스의 추가된 기능에 접근 불가능 
 *                    포함 : 포함하고 있는 클래스가 크다 
 *                    -------------------------
 *                    class A
 *                    {
 *                    }
 *                    class B
 *                    {
 *                       public void display()
 *                       {
 *                           A a=new A(); => 포함클래스가 아니다 (지역변수)
 *                       }
 *                    } 
 *                    class C
 *                    {
 *                        A a=new A(); // 포함 클래스 => 멤버일 경우에만 
 *                    }
 *             = 제공하는 기능 (메소드) 
 *               ***1. toString() => 객체를 문자열화 => 객체의 주소 
 *                  ---------- 묵시적 , 명시적 
 *                  class A
 *                  
 *                  A a=new A();
 *                  System.out.println(a) => 묵시적 => toString() 생략할 수 있다 
 *                  System.out.println(a.toString()) => 명시적 
 *                  => 가장많이 오버라이딩 => 변수의 값을 출력 
 *                                      ------------
 *                2. hashCode() => 객체의 메모리 주소값을 리턴형 
 *                   ----------- 데이터값이 같은 경우 => 같은 사람 ... => 중복을 제거 
 *                ***3. clone() : 객체를 복제 => 새로운 메모리를 만들때 필요한 객체의 내용을 그대로 복사 
 *                   -------- ProtoType패턴 => 이모티콘 / 아바타 
 *                4. finalize() : 소멸자 => 객체 메모리 해제 => 자동 호출 
 *                                => 호출이 안되면 메모리에 남아 있다..
 *                                => System.gc() : 사용하지 않는 메모리를 회수 요청 
 *                                => 웹/애플리케이션에서는 사용하지 않는다 => 멀티미디어 (동영상,화상채팅,CCTV)
 *                                                                 -------------------------
 *                ***5. equals() : 객체를 비교할때 
 *                              => 메모리 주소값 (디폴트)
 *                              => 멤버변수값을 비교 (오버라이딩)
 *                객체의 생명주기 
 *                -----------
 *           객체에 대한 설계      객체생성    =========> 객체 활용  ==========> 객체 소멸 
 *            class        new 생성자()            .(변수/메소드)          객체=null
 *                                                           null은 더이상 사용하지 않는다 
 *                                                           => GC 대상 (메모리 회수 대상)
 *                                                           | 바로 회수하지 않는다 => 프로그램 종료시에 회수
 *                                                           ** new을 많이 사용하면 => 누적 => 부하 
 *                    
 *      = String 
 *      = System 
 *      = Math
 *      = Wrapper
 *      = StringBuffer 
 *      
 */
import java.util.*;
class Sawon
{
	private int sabun;
	private String name;
	// 사용자로부터 값을 받아서 초기화 
	public Sawon(int sabun,String name)
	{
		this.sabun=sabun;
		this.name=name;
	}
	// 출력 
	@Override // => 반드시 상속 => 재정의 (정의를 변경) => 덮어쓴다 
	public String toString() {
		// TODO Auto-generated method stub
		return "사번:"+sabun+",이름:"+name; // 메모리 주소값을 변경 => 변수의 초기화 출력 
	}
	// => 디폴트 생성자는 없다 (자동추가가 안된다) 
	
}
class Student
{
	private int hakbun;
	private String name;
	// 생성자 => 디폴트는 사용할 수 없다 (자동 추가 불가능하다)
	public Student(int hakbun,String name)
	{
		this.hakbun=hakbun;
		this.name=name;
	}
	// hashCode변경 => 라이브러리는 필요한 경우에 대부분 오버라이딩을 해서 사용 
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(hakbun,name);
	}
	
}
/*
 *    인터페이스 => 클래스 (다중상속)
 *     => 미완성된 클래스 => 완성해서 사용한다 
 *                      ------------ 상속 
 *     인터페이스 ======> 인터페이스 
 *             확장 => extends 
 *     인터페이스 ======> 클래스 
 *             미완성된 메소드를 구현 => implements
 *     클래스    ======> 클래스
 *             확장 => extends 
 *     클래스   =====> 인터페이스(X)
 *     
 *     = 형식 => 모든 구성요소 : 변수/메소드 => only public
 *       interface interface명
 *       {
 *           ----------------------
 *             상수 (변수는 존재하지 않는다)
 *             (public static final) int a=100; // 반드시 선언괴 동시에 초기화값을 설정 => 변경이 불가능 
 *           ----------------------
 *             구현이 안된 메소드 
 *             (public abstract) void display();
 *           ----------------------
 *             구현이 된 메소드
 *             (public) default 리턴형 메소드명(매개변수)
 *                      -------
 *             {
 *             } 
 *           ----------------------
 *       }
 *    
 */
class Box implements Cloneable
{
	private int width;
	private int height;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	// throws문장에 뒤에 붙는 예외클래스는 => RuntimeException관련은 없다 => 예외처리를 하고 사용한다 
	// CloneNotSupportedException => CheckedException
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
class Member
{
	// c언어 => Member() , ~Member()
	private int mno;
	private String name;
	// 생성시에 호출 => 생성자 
	public Member(int mno,String name)
	{
		this.mno=mno;
		this.name=name;
		System.out.println("객체 메모리 할당...");
	}
	public void print()
	{
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
	}
	// 소멸시에 호출 => 소멸자 
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("객체 메모리 회수...");
	}
	
	// 멤버변수의 값을 설정 => 여러번 변경 / 한번만 변경 
	//                             | 생성자
	//                   | 생성자를 이용할 수 없다 => setter
	/*
	 *    Member m=new Member(1,"aaa");
	 *    m=new Member(2,"bbb");
	 *    m=new Member(3,"ccc");
	 *    --------------------------------- 객체가 3번이 생성 
	 */
}
class Food
{
	private int fno;
	private String name;
	
	public Food(int fno,String name)
	{
		this.fno=fno; 
		this.name=name;
		// 지역변수 우선순위 
		// 변수 => 지역변수,매개변수 => 멤버변수 
		// 변수명이 같은 경우에는 반드시 구분 => this : 클래스 자신의 객체 ,super : 상속내린 클래스의 객체
		/*
		 *   메모리 
		 *   ---------------------------
		 *      ------- super ----------
		 *        상속 내린 클래스의 변수/메소드
		 *        => clone()
		 *        => finalize()
		 *        => equals()
		 *        => toString()
		 *        => hashCode()
		 *      ------------------------
		 *      
		 *      ------- this -----------
		 *        추가된 내용 
		 *      ------------------------
		 *   ---------------------------
		 * 
		 */
	}
    /*
     *   void display(int a)
     *               ------- 10 => a=10
     *   {
     *   }
     *   
     *   display(10)
     */
	@Override
	public boolean equals(Object obj) {
		// f1.equals(f2)
		// Object obj=f2; => Object => fno,name이 존재하지 않는다 
		// TODO Auto-generated method stub
		Food f=(Food)obj;
		return name.equals(f.name) && fno==f.fno;// 실제 멤버변수값을 가지고 변경 
	}
	/*
	 *   class A
	 *   {
	 *      int a,b;
	 *      void display(){}
	 *   }
	 *   class B extends A
	 *   { 
	 *      -------------
	 *      int a,b;
	 *      void display(){} => 내용 변경이 가능 => 오버라이딩 
	 *      -------------
	 *      int c;
	 *      void bbb(){}
	 *   }
	 *   
	 *   A a=new A(); a,b,display() => 사용이 가능
	 *   B b=new B(); a,b,display(),c,bbb()
	 *   A c=new B(); a,b, display()=>B가 가지고 있는 메소드 호출 
	 *                --------------
	 */
	
}
public class Object_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*Sawon s1=new Sawon(1, "홍길동"); // 데이터베이스에 데이터 읽기 / 파일 데이터 읽기 
        System.out.println(s1); // s1q.toString() => toString()
        Sawon s2=new Sawon(2,"박문수");
        System.out.println(s2.toString());*/
		/*Student s1=new Student(1, "홍길동");
		Student s2=new Student(1, "홍길동");
		// new를 사용하면 (새로운 메모리를 만들어서 사용)
		// 중복을 제거할때 주로 사용한다 
		// => 데이터 중복여부 => hashCode() => 웹에서 데이터 수집 
		//System.out.println("s1:"+s1.hashCode());
		//System.out.println("s2:"+s2.hashCode());
		if(s1.hashCode()==s2.hashCode())
		{
			System.out.println("같은 학생입니다!!");
		}
		else
		{
			System.out.println("다른 학생입니다!!");
		}*/
		Box box1=new Box();
		box1.setWidth(300);
		box1.setHeight(350);
		/*
		 *   Box box4=box1;
		 */
		Box box4=box1; // box1에 대한 별칭 => 같은 메모리를 제어할때 사용 
		System.out.println("box1=>"+box1);
		System.out.println("box4=>"+box4);
		Box box3=new Box();
		System.out.println("box3.width:"+box3.getWidth());//0
		System.out.println("box3.height:"+box3.getHeight());//0
		// clone은 형변환 / 예외처리가 필요하다 
		try {
			  Box box2=(Box)box1.clone();
			  System.out.println("box2.width:"+box2.getWidth());//300
			  System.out.println("box2.height:"+box2.getHeight());//350
			  System.out.println("box2=>"+box2);// 메모리 주소가 다른 경우에는 새로운 메모리가 생성 
			  // 제어를 따로 할때 사용 
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 객체 생성 
		Member m=new Member(1, "심청이");
		// 객체 활용
		m.print();
		// 객체 소멸 
		m=null; // finalize()호출 => X
		// 객체 메모리 회수 명령
		System.gc(); // 필요한 경우에만 사용 
		
		Food f1=new Food(1, "중국집");
		Food f2=new Food(1,"중국집");
		// => 재정의 => 오버라이딩을 하기 전까지 => 주소값
		if(f1.equals(f2))
		{
			System.out.println("f1="+f1);
			System.out.println("f2="+f2);
			System.out.println("같은 업체입니다!!");
		}
		else
		{
			System.out.println("f1="+f1);
			System.out.println("f2="+f2);
			System.out.println("다른 업체입니다!!");
		}
	}

}

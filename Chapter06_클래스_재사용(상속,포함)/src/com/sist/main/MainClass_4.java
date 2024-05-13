package com.sist.main;
/*
 *   자바 ==> 오라클 ==> HTML/CSS ==> JavaScript ==> JSP ==> Spring ==> Python ==> AWS
 *   -----------------------------------------------------------    ------- DJango / 머신러닝 / 딥러닝 
 *                                    |               |             |
 *                                  Ajax            MyBatis / JPA  Spring-Boot
 *                                  Vue
 *                                  React           String-Security
 *                                  -----------------------------------------------
 *                                                     |
 *                                                    MSA / CI,CD 
 *    전공 / ***신기술 
 *    -------------
 *    상속 
 *    ---- 재사용 , 단일상속 
 *    예외조건 : 생성자 , 초기화 블록 , static 
 *                              ------- 공통으로 사용 
 *                              
 *    매모리 저장 
 *                ----------------
 *                  --- 변수 -----
 *                  --- 메소드 ----     .
 *                ----------------
 *                
 *                ---------------
 *                  --- super ---
 *                  
 *                    변수 / 메소드
 *                  ------------
 *                  
 *                  ----this ---
 *                  
 *                    변수 / 메소드 
 *                  ------------
 *                
 *                ---------------
 *        class A
 *        {
 *           int a,b,c,d,e,f;
 *        }
 *        class B extends A
 *        {
 *           //int a,b,c,d,e,f; => 소스 간결해 진다 
 *           int k;
 *           => 기능을 변경 => 메소드 (오버라이딩)
 *        }
 *        => 실행 속도가 느려진다 
 *        => 소스를 볼 수 없기 때문에 => 가독성이 떨어진다 
 *        => 제약조건이 많다 
 *        => 결합성이 높아진다 
 *        ------------------------------------- 상속을 사용하지 않는다 (Spring)
 *        => 상속 < 포함 
 *        
 *        Music : 지니 , 멜론 , Mnet => 동일 
 *                ---  ------------
 *        Movie : CGV,롯데시네마 , 메가박스 ...
 *                ---
 *        FoodHouse : 메뉴판닷컴 , 망고....
 *        Shpping : 우체국 
 *        --------------------------------
 *        
 */
/*
 *    상속을 내리는 클래스 : super클래스 , base클래스 , 부모클래스 , 상위클래스 
 *    상속 받는 클래스 : sub클래스, 파생클래스 , 자식클래스 , 하위클래스 
 *    
 *    class 게시판
 *    {
 *       글쓰기()
 *       상세보기()
 *       검색()
 *       수정()
 *       추가()
 *       삭제()
 *    }
 *    
 *    class 묻고답하기 extends 게시판 
 *    {
 *       묻기() => 글쓰기 변경 => 오버라이딩 
 *       상세보기()
 *       검색()
 *       수정()
 *       추가()
 *       삭제()
 *       답하기()
 *    }
 *    
 *    class 댓글게시판 extends 게시판 
 *    {
 *       댓글()
 *    }
 *    class 갤러리게시판 extends 게시판 
 *    {
 *       파일업로드() => 이미지 
 *    }
 */
class Super
{
	int a;
	int b;//c는 사용할 수 없다 
}
class Sub extends Super
{
	// a,b
	int c;
}
public class MainClass_4{
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Super su=new Super();
		System.out.println(su.a);
		System.out.println(su.b);
        Sub sub=new Sub();
        System.out.println(sub.a);
        System.out.println(sub.b);
        System.out.println(sub.c);*/
		Super su=new Sub();// 가장 많이 사용이 된다 
		// 상위     하위 
		// su=> a,b
		// double    int
		System.out.println(su.a);
		System.out.println(su.b);
		Sub sub=(Sub)su;// 형변환 
		// Super > Sub 
		// double  int 
		System.out.println(sub.a);
		// int double
		// sub => a,b,c
		// 클래스에 따라 => 접근 변수가 달라진다 
		// => 인터페이스 => 상위 클래스로 처리 => 형변환 
	}

}

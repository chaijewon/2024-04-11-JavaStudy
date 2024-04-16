/*
 *     int a;   
       int b;   
       a=3;   
       b=a+5;       
       System.out.printf("a의 값: %d \n", a);     
       System.out.printf("b의 값: %d \n", b);  
       
       프로그램 
       1. 변수 선언 => 데이터 저장 공간 확보 => 메모리 
       2. 변수의 초기화 
       ---------------------------------------- 선언+초기화 
       int a
       a=10; 
       int a=10;
       3. 사용자 요청에 대한 처리 
          => 연산처리 / 제어문 
       ------------------------------------ 웹, 일반 자바 , 모바일 동일 
       4. 처리된 결과를 출력 (브라우저 , 핸드폰 , 윈도우)
       
 */
public class 연산자문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   // 코딩 순서 
		   // 1. 변수선언 
		   int a;   
	       int b;   
	       // 2. 초기화
	       a=3;   
	       b= a+5;    
	       // a=3  ==> b=3+5 => b=8
	       // 3. 화면 출력 
	       System.out.printf("a의 값: %d \n", a);
	       //                                3
	       //                         |
	       // %d => 정수값 첨부 
	       // %f => 실수값 첨부 => %.2f ==> 실수 출력 소수점 2자리 출력  
	       // %c => 문자 첨부 
	       // %s => 문자열 첨부 
	       // 출력형식을 만들어서 처리 ==> printf() ==> C언어의 출력형식 도입 
	       System.out.printf("b의 값: %d \n", b);  
	       //                                8
	       //                         |
	}

}

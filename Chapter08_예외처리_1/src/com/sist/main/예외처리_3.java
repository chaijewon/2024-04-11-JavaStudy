package com.sist.main;
/*
 *   1 => 263page
 *     예외 : 프로그램에 의도하지 않은 문제가 발생 
 *                            --------
 *                            발생된 위치에서 비정상 종료한다 
 *                                       --------
 *                                       비정상 종료를 방지하고 정상정료가 가능하게 만드는 방법 
 *     => 문제가 발생 
 *        = 사용자의 부주의 (입력을 잘못하는 경우) 
 *        = 프로그램의 결함 (프로그래머 실수) 
 *        = 해결책 
 *          1. 조건문 사용 => if => 사전에 예방 
 *          2. 조건문이 안되는 경우 => 예외처리를 이용한다 
 *                               -----
 *                               ------------------- 가장 많이 사용이 된다 ---------------------------
 *                               직접처리 : 프로그래머가 에러발생시 처리 => 복구 
 *                                       try~catch
 *                                       --- -----
 *                                           | 에러발생시 처리 => 예상되는 에러를 처리하기 때문에 여러개 사용이 가능 
 *                                       | 소스 코딩 
 *                               ----------------------------------------------------------------
 *                               이미 소스 코드가 완료된 상태 => try~catch를 만들기 어렵기 때문에 ...
 *                               간접처리 : 시스템에 의해 처리가 가능 => 회피 
 *                                       throws 
 *                                       ------
 *                                       | 예상되는 에러를 등록 => 호출시에 처리하고 사용 
 *                                       | 라이브러리에 많이 존재 
 *                                         ---------------- 라이브러리 메소드 호출시에는 예외처리후에 사용 
 *                                         
 *              문장 1 => error => 종료 => catch는 한번 수행 
 *              문장 2 => error
 *              문장 3 => 정상 수행 
 */
import java.util.*;
public class 예외처리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
	        Scanner scan=new Scanner(System.in);
	        System.out.print("첫번째 정수 입력:");
	        // 문자열로 받는다 (윈도우 , 웹 => 정수가 없다 => 문자열로 받는다)
	        String num1=scan.next();
	        System.out.print("두번째 정수 입력:");
	        String num2=scan.next();
	        
	        // 첫번째 에러
	        int n1=Integer.parseInt(num1); // 문자열을 정수로 변환 ==> 유효성검사 
	        // => 에러 발생 의심부분 1
	        int n2=Integer.parseInt(num2); // 문자열을 정수로 변환 
	        // => 에러 발생 의심부분 2
	        int n3=n1/n2; // => if처리가 편리하다 
	        // => 에러 발생 의심부분 3
           	System.out.println("n1="+n1);
	        System.out.println("n2="+n2);
	        System.out.println("n3="+n3);
	        
	        // num1 , num2 , n1 , n2, n3 => try블록안에서만 사용이 가능 => 블록변수 / 지역변수 
	        // ==> {}안에서만 사용이 가능 
		}/*catch(NumberFormatException e) // 정수변환이 안되는 경우에만 처리 
		{
			System.out.println("정수만 입력할 수 있습니다!!");
		}catch(ArithmeticException e) // 0으로 나누는 경우에만 처리 
		{
			System.out.println("0으로 나눌 수 없습니다");
		}*/
		catch(RuntimeException e)
		{
			System.out.println("사용자 입력 오류가 발생!!");
		}
		// NumberFormatException, ArithmeticException ..... RuntimeException
	        
        // 정상수행 가능 , 사용자가 입력을 잘못한 경우 => 에러 처리가 안된다 => 입력값을 받아야 알 수 있다 
        // => 강제로 예외처리를 하지 않는다 => 필요시 => 예외처리를 생략이 가능 
        System.out.println("프로그램 종료!!");// 정상 종료
        // 프로그램을 정상 종료가 가능하게 만든다 => 윈도우,브라우저=> 실행상태 유지 ...
	}

}

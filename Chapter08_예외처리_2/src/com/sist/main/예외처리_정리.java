package com.sist.main;
/*
 *   예외처리가 필요한 곳 
 *     => 컴파일시에 예외처리가 되어 있는지 확인 
 *        --------------------------- 반드시 예외처리후에 사용 (메소드) => CheckedException 
 *        java.io / java.sql / java.net / javax.http.servlet
 *     => 예외처리를 확인하지 않는 곳 => UnCheckException 
 *        java.lang => 예외처리가 필수가 아니다 
 *        => 생략을 할 수 있는데 => 사용자의 에러가 많이 발생하는 위치 => 예외처리를 하는 것이 좋다 
 *                            -------------------------
 *                            | 사용자 입력창 
 *                            | 나이 입력 => TextField ==> 받는 경우 int
 *                              -----------------------------------
 *     => try~catch~finally 
 *     => throws가 있는 경우 어떻게 처리 
 *     --------------------------- Exception / Throwable 
 *        throws Exception => 모든 예외처리 클래스가 포함되어 있다 
 *        try
 *        {
 *           
 *        }catch(Exception e){} 
 *        
 *        throws Throwable 
 *         => throws Exception => 오류 발생 
 *         
 *        Throwable > Exception > 기타 
 *        ---------Spring AOP
 *        
 *        *** 상속이 있는 경우에는 => 상위 클래스가 하위 클래스보다 크다 
 *            | 위로 올라갈 수록 크다 
 *            
 *            Object
 *              |
 *            Throwable
 *              |
 *        ----------------
 *        |              |
 *       Error       Exception
 *                       |
 *                     나머지 예외클래스 
 *                     ------------ (예외처리 필수 , 예외처리 필수가 아니다)
 *                                   =========   ================
 *                                   컴파일시        실행시 => 입력값을 받아봐야 알 수 있다
 *                                   
 *       => 예외 발생이 많은 경우 : NumberFormatException 
 *                            브라우저         ==========      자바 
 *                                           문자열 (다른 데이터형 없다) => 정수 / 실수 => 변환 
 *          부분적으로 예외처리가 가능 
 *          ------------------
 *          
 *          1
 *         try ---
 *          2
 *          3
 *          ---
 *          4
 *          5
 *         try ---
 *          6
 *          7
 *          ---
 *          8
 *          
 *          => for()
 *             {
 *                try
 *                {
 *                }catch(Exception ex){}
 *             }
 *         try => 원하는 위치에서 사용이 가능 
 */
public class 예외처리_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

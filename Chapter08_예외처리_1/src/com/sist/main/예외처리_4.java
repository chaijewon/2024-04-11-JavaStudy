package com.sist.main;
/*
 *   try절 ==> 정상수행이 가능한 문장 
 *   catch절 => try안에 문장을 수행하는 과정에서 에러가 발생시 처리 
 *   ------- 여러개 사용이 가능 , 예외처리 클래스의 순서 
 *                          -----------------
 *                           크기 => 상속 => 상속도 => 위로 올라갈 수록 에러 처리의 기능이 많다 
 *   Exception 
 *      |
 *   RuntimeException 
 *      |
 *    NumberFormatException , NullPointerException , ClassCastException 
 *    
 *    Exception > RuntimeException > NumberFormatException , NullPointerException , ClassCastException 
 *                ----------------   ---------------------------------------------------------
 *                  | 세가지 동시에  처리가 가능 
 */
import java.util.*;
class A1
{
	
}
class B1 extends A1
{
	
}
public class 예외처리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
             A1 a=new A1();
             B1 b=(B1)a;// 오류 발생 => ClassCastException 
        }
        /*catch(ArithmeticException e) // 0으로 나눌때 에러 처리 
        {
        	
        }catch(ArrayIndexOutOfBoundsException e) //배열범위 초과시에만 처리
        {
        	
        }catch(NumberFormatException e) // 문자열을 정수로 변환할때 => 오류처리 
        {
        	
        }*/catch(RuntimeException e)
        {
        	// 전체를 잡아주는 예외처리 ==> RuntimeException
        	// ArithmeticException ArrayIndexOutOfBoundsException NumberFormatException
        	// ClassCastException
        }
        // ClassCastException 
        System.out.println("프로그램 종료!!");
	}

}

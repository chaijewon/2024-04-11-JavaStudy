package com.sist.main;
/*
 *    문자열 2개 받아서 
 *    정수 배열에 저장 ==> 정수 변환 (사용자) , 배열의 인덱스 (프로그래머 실수)
 *    배열값을 나누기 해서 출력 ==> 사용자가 나누기 값을 0을 입력하는 경우 
 *    ------------------------------------------------------
 *     1. 예상되는 에러 => 3개 
 *     2. 기타 발생 => 4개 
 *     -----------------------------------------------------
 *     1. 사전에 에러 방지할 수 있는 프로그램 제작 
 *        -----------------------------
 *        웹 => 사용자 => 사이트에서 오류 발생하면 => 탈퇴 
 *        => 배포 => 의뢰자가 일부러 오류 => 유지하는 확인 
 *        =>       ---------------------------- 통과안 됨 (위약금 / 다시 개발)
 *                                                             -------
 *                                                             |  
 *        => 방지하기 위해서 => 신입사원 교육이 타이트하다
 *        => 신입 사원 교육 => Spring 
 *        
 *     2. 조건문으로 가능 
 *        예외처리 => 예상되는 에러 도출 
 *                 -------------
 *                 catch 1개로 처리 => 경력 
 *                 catch => 에러별 처리 => 신입  
 *        
 *        
 *    
 */
import java.util.*;
public class 예외처리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	String s1="3";
        	String s2="0";
        	int n1=Integer.parseInt(s1);
        	int n2=Integer.parseInt(s2);// error 
        	int[] arr= {n1,n2};
        	System.out.println(arr[0]/arr[1]);// error
        }catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.println("배열 범위 초과");
        }catch(NumberFormatException e)
        {
        	System.out.println("정수 변환 오류");
        }catch(ArithmeticException e)
        {
        	System.out.println("0으로 나눌 수 없다");
        	
        }// 반드시 큰 예외처리는 마지막에 처리 ==> 예상을 못한 예외처리 
        catch(Exception e)
        {
        	System.out.println("예상하지 못한 에러 발생");
        }
	}

}

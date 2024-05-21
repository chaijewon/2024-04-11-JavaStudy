package com.sist.main;
import java.util.*;
// Exception / RuntimeException
// => CheckedExeption UnCheckedExeption
class MinusException extends Exception
{
	// 상속 => 예외처리 전체를 상속을 받아서 처리 
	public MinusException(String msg)
	{
		super(msg);
	}
}
public class 예외처리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("양수만 입력:");
        int no=scan.nextInt();
        try
        {
        	// catch는 자바에서 제공하는 예외 클래스는 인식 => 사용자 정의는 인식하지 못한다 => 예외 임의로 발생 => throw
        	if(no<0) // 에러 발생이 아니다 => 일부러 발생 => throw
        	{
        		throw new MinusException("음수는 사용 불가!!");
        		// throw => 사용자 정의 예외처리를 만든 경우 
        		// => catch절을 호출한다 
        	}
        }catch(MinusException e)
        {
        	System.out.println("에러메세지:"+e.getMessage());
        	System.out.println("======= 에러 발생 위치 =======");
        	e.printStackTrace();
        }
	}

}

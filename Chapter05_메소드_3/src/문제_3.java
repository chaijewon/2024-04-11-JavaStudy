/*
 *   년도를 입력 받아 윤년여부를 확인하는 프로그램 작성
     년도 입력 메소드
     윤년 처리 
     출력 

 */
import java.util.*;
public class 문제_3 {
	//년도 입력 메소드
	static int input() 
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int a=scan.nextInt();
		return a;// 입력받은 값을 돌여준다 
	}
    //윤년 처리 
	static void isYear(int year)
	{
		if((year%4==0 && year%100!=0)||(year%400==0))
        	System.out.println(year+"년도는 윤년입니다");
        else
        	System.out.println(year+"년도는 윤년이 아닙니다");
	}
    //출력 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=input();
		isYear(year);
        /*Scanner scan=new Scanner(System.in);
        // => System.in : 키보드 입력값 , System.out => 화면 출력 
        //           inputStream              outpurStream 
        // System.in을 이용해서 키보드 입력값을 가지고 올 수 있다 => 모든 문자를 정수형 
        // => 클래스 => 키보드 입력받아서 => 메모리에 저장 
        System.out.print("년도 입력:");
        int year=scan.nextInt();
        ////////////////////// 입력 부분 
        if((year%4==0 && year%100!=0)||(year%400==0))
        	System.out.println(year+"년도는 윤년입니다");
        else
        	System.out.println(year+"년도는 윤년이 아닙니다");*/
	}

}

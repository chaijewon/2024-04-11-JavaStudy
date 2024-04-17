/*
 *   4) 년도를 입력 받아 윤년인지 아닌지를 판별하는 방법을 if~else문으로 사용하라
 *   
 *   윤년 조건 => 로마시대 => 윤년 계산법 , 암호화 ...
 *   4년마다 
 *   100년마다 제외
 *   400년마다 
 *   -------------- 
 *   if((year%4==0 && year%100!=0)||(year%400==0))
 *   {
 *      
 *   }
 *   else
 *   {
 *   }
 *    
 */
import java.util.Scanner;
public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("년도 입력:");
        int year=scan.nextInt();
        // 처리 ==> 윤년 조건 
        if((year%4==0 && year%100!=0)||(year%400==0))
        {
        	System.out.println(year+"년도는 윤년입니다");
        }
        else
        {
        	System.out.println(year+"년도는 윤년이 아닙니다");
        }
	}

}

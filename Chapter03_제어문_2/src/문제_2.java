/*
 *   2) 한 개의 정수를 입력 받아 3의 배수인지 판별하여 출력하라
 */
import java.util.Scanner;
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        // 사용자 요청 
        // 결과값 출력 => 프로그래머가 처리 
        if(num%3==0 && num!=0) // % => 배수 , 자리수 나눠서 처리 
        {
        	System.out.println(num+"는(은) 3의배수입니다");
        }
        else
        {
        	System.out.println(num+"는(은) 3의배수가 아닙니다");
        }
	}

}

// 정수입력을 받는다 => 양수/음수인지 확인해서 출력 

import java.util.Scanner;

public class 제어문_단일조건문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int num;
        System.out.print("정수 입력:");
        num=scan.nextInt();
        
        // 결과값 
        if(num>=0)
        {
        	System.out.println(num+"는(은) 양수입이다");
        }
        if(num<0)
        {
        	System.out.println(num+"는(은) 음수입니다");
        }
	}

}

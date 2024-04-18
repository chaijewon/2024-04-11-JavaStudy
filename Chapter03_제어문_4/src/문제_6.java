/*
 *  한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라
 */

import java.util.Scanner;

public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 합 
		int sum=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int num=scan.nextInt();
		for(int i=1;i<=num;i++)
		{
			sum+=i;
		}
		System.out.println("1~"+num+"까지의 합:"+sum);
		
	}

}

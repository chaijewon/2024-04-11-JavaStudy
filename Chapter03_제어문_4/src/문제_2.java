/*
 *  정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 
    프로그램을 만들어라 (switch~case 사용)
 */

import java.util.Scanner;

public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 정수 입력:");
        int num1=scan.nextInt();
        System.out.print("연산자 입력(+,-,*,/):");
        char op=scan.next().charAt(0);
        System.out.print("두번째 정수 입력:");
        int num2=scan.nextInt();
        ///  사용자 입력 요청 
        ///  결과값 출력 
        /*
         *   문자  ==> ''
         *   문자열 ==> ""
         */
        switch(op) // 문자 , 정수 , 문자열 (실수,논리형은 사용이 불가능)
        {
          case '+':
        	  // 처리문장 
        	  System.out.println(num1+"+"+num2+"="+(num1+num2));
        	  // case 한개 수행 => break를 사용 
        	  break;
          case '-':
        	  System.out.println(num1+"-"+num2+"="+(num1-num2));
        	  break;// 문장을 수행하고 종료 
          case '*':
        	  System.out.println(num1+"*"+num2+"="+(num1*num2));
        	  break;
          case '/':
        	  if(num2==0)
        		  System.out.println("0으로 나눌 수 없습니다!!");
        	  else
        		  System.out.println(num1+"/"+num2+"="+(num1/num2));
        	  break;
           // 연산자가 잘못된 경우 => default는 생략이 가능 
           default:
        	   System.out.println("잘못된 연산자입니다!!");
        	   // 마지막은 break사용할 수 있고 사용하지 않을 수 있다
        	//*** case에 등록된 값이 중복되면 오류 발생 
        	//*** 데이터가 일치 => case에 등록되는 데이터형 통일 
        }
        
	}

}

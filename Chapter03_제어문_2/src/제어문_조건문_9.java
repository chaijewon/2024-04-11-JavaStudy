// 사칙연산 => 연산을 한번만 수행==>다중 조건문 
import java.util.Scanner;
public class 제어문_조건문_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in); 
        // 사용변수 
        int num1,num2;
        char op=' ';
        
        System.out.print("첫번째 정수 입력:");
        num1=scan.nextInt(); // 변수 => 한개의 데이터를 저장하는 공간 
        System.out.print("연산자 입력(+,-,*,/):");
        op=scan.next().charAt(0);
        System.out.print("두번째 정수 입력:");
        num2=scan.nextInt();
        
        if(op=='+')
        {
        	System.out.println(num1+"+"+num2+"="+(num1+num2)); // 문장 수행후 종료
        }  //     | false
        else if(op=='-')
        {
        	System.out.println(num1+"-"+num2+"="+(num1-num2)); // true => 수행후 종료
        }  //     | false
        else if(op=='*')
        {
        	System.out.println(num1+"*"+num2+"="+(num1*num2)); // true => 수행후 종료
        }  //     | false
        else if(op=='/')
        {
        	if(num2==0)
        	{
        		System.out.println("0으로 나눌 수 없습니다");
        	}
        	else
        	{
        		System.out.println(num1+"/"+num2+"="+(num1/num2));
        	}
        }
        else //  해당 조건이 없는 경우에 처리 문장 ==> 생략이 가능 
        {
        	// + , - , / , *가 아닌 경우 => 1,2,3,4
        	System.out.println("잘못된 연산자입니다");
        }
        
	}

}

import java.util.Scanner;
// 숫자를 입력을 받아서 => 3의배수 , 5배수, 7배수 => 15
// 조건 여러개를 동시에 수행 => 단일 조건문 
// 조건 1개만 수행 => 다중 조건문 
public class 제어문_조건문_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        
        if(num%3==0) // 3의 배수
        {
        	System.out.println(num+"는(은) 3의 배수입니다");
        }
        if(num%5==0)
        {
        	System.out.println(num+"는(은) 5의 배수입니다");
        }
        if(num%7==0)
        {
        	System.out.println(num+"는(은) 7의 배수입니다");
        }
	}

}

/*
 *   10개의 정수를 입력받아 그 수들 중 짝수의 개수가 몇개인지 출력하는 프로그램 작성
 */
import java.util.Scanner;
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int even=0;
        for(int i=1;i<=10;i++)
        {
        	System.out.print(i+"' 정수 입력:");
        	int num=scan.nextInt();
        	//System.out.println("num="+num);
        	if(num%2==0)
        		even++;
        }
        System.out.println("갯수:"+even);
	}

}

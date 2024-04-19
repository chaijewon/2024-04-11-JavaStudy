/*
 * 사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 
 *           ---------------------
   끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오.
               --
               i=1;i<=5

 */
import java.util.Scanner;
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int start,end;
        int gop=1;
        // sum=0 , gop=1 
        Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 정수 입력:");
        start=scan.nextInt();
        System.out.print("두번째 정수 입력:");
        end=scan.nextInt();
        
        for(int i=start;i<=end;i++)
        {
        	gop*=i;// 처리부분 
        }
        System.out.println("결과값:"+gop);
	}

}

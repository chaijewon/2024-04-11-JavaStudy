// 사용자로부터 2~9사이의 정수를 입력받아서 구구단 출력 
// 단 입력이 2~9까지 아닐 경우에는 다시 입력을 하게 만든다 
import java.util.Scanner;
public class 자바제어문_반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int dan=0; // 블록변수 => {}을 벗어나면 자동으로 삭제 
        // 프로그램에 필요한 데이터를 사용자로부터 받아서 => 오류 체크 
        /*
         *   for(int i=0;i<10;i++)
         *   {
         *      int j=10;
         *      
         *   }// for 종료시까지만 사용이 가능 => i,j
         *   // => for안에서 변수를 설정 => for안에서만 사용이 가능 
         */
        for(;;) // 무한 루프 => 사용자 입력 ~ 2-9
        {
        	System.out.print("2~9사이의 정수 입력:");
        	dan=scan.nextInt();
        	if(dan<2 || dan>9)
        	{
        		System.out.println("잘못된 입력입니다");
        		//=> for처음으로 이동 
        		continue;// for을 처음부터 수행 
        	}
        	break; // for종료 => 정상 입력을 했을 경우 
        }
        System.out.println("단="+dan);
        System.out.println("===== "+dan+"단 =====");
        for(int i=1;i<=9;i++)
        {
        	System.out.printf("%d * %d = %d\n",dan,i,dan*i);
        }
	}

}

// => 리턴형(X) => 매개변수(O)
//    ------- 메소드 자체에서 출력
// 단입력을 받아서 해당 단을 출력 
import java.util.*;
public class 메소드_4 {
	// 결과값이 없는 경우에는 void를 사용한다 
    static void gugudan(int dan)
    {
    	
    	for(int i=1;i<=9;i++)
    	{
    		System.out.printf("%d * %d = %d\n",dan,i,dan*i);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* gugudan(2);// 반복 제어 => 구조적 프로그램(단락) => 조립 
        System.out.println("===============");
        gugudan(3);
        System.out.println("===============");
        gugudan(4);
        System.out.println("===============");
        gugudan(5);*/
		for(int i=2;i<=9;i++)
		{
			gugudan(i);// 항상 호출시에 처음부터 수행 
			System.out.println("================");
		}
	}

}

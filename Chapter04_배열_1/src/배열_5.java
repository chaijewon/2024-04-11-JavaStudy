// 알파벳을 임의로 10개 저장 => char[]
import java.util.*;
public class 배열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[] alpha=new char[10];
        // 초기화 
        // length=> 배열의 갯수
        System.out.println("배열의 갯수:"+alpha.length);
        for(int i=0;i<alpha.length;i++)
        {
        	// 0 ~ 9 => 인덱스번호는 무조건 0번부터 시작한다 
        	alpha[i]=(char)((Math.random()*26)+65);
        	//              ------------------ 0~25 => 65 -> 90
        }
        System.out.println("===== for-each:실제 저장된 데이터를 읽어 온다 =====");
        // 용도는 출력할 때 주로 사용 
        for(char c:alpha)
        {
        	System.out.print(c+" ");
        }
        System.out.println("\n===== 일반 for문:인덱스 번호를 이용해서 읽기 ======");
        // 용도는 데이터 값 변경 , 초기화 , 출력 


        for(int i=0;i<alpha.length;i++)
        {
        	System.out.print(alpha[i]+" ");
        }
        System.out.println("\n===== 자바에서 제공하는 API를 이용해서 읽기 =====");
        Arrays.sort(alpha);
        System.out.println(Arrays.toString(alpha));
        
	}

}

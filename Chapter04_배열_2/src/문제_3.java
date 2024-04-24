/*
 *   char[] alpha = {'a', 'b', 'c', 'd'};

    for(                          )
     System.out.print(alpha[i]);

 */
import java.util.*;
public class 문제_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        char[] alpha = {'a', 'b', 'c', 'd'};
		for(int i=0;i<alpha.length;i++)// 값 변경 , 초기화 (인덱스번호가 필요하다)
		{
			System.out.println(alpha[i]);
			//                 -------- 인덱스 => 일반 for문 사용 
		}
		System.out.println("===== for-each =====");
		for(char c:alpha) // 출력용 => 웹 => for-each
		{
			// 받는 변수 데이터형 = 배열의 데이터형이 동일 
			// 받는 변수 데이터형이 크다
			System.out.println(c); // 실제 값 출력 => for-each
		}
		System.out.println("===== API ======");
		System.out.println(Arrays.toString(alpha));
	}

}

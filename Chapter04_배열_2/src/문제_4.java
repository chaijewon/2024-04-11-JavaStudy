/*
 *   양의 정수 10개 입력받아 배열에 저장하고, 
 *   배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라
 */
import java.util.*;
public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1 정수 10개를 저장하는 공간 => 배열 
		int[] arr=new int[10];
		//2 초기화 
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));// 저장된 값 확인 
		//3 출력
		for(int i:arr)// 실제 저장된 값을 읽어 온다 
		{
			if(i%3==0)
				System.out.print(i+" ");
		}
	}

}

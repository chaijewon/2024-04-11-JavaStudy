/*
 *   int[] num = { 94, 85, 95, 88, 90 };
 *   다음 배열에서 최대값,최소값을 출력하는 프로그램을 작성하시오
 */
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성과 동시에 초기화 
		int[] num = { 94, 85, 95, 88, 90 };
		// 최소값,최대값 구하기 => 요청 처리
		int max=num[0];
		int min=num[0];
		for(int i:num)
		{
			if(max<i) // if(94<94) if(94<85) if(94<95) ...
				max=i;
			if(min>i)
				min=i;
		}
		// 출력 
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);
	}

}

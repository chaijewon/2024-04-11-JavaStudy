/*
 *   반복 => 필요한 내용만 출력 
 *   
 *   for은 무조건 지정된 횟수만큼 돌아간다 
 *   for(초기값;조건식;증감식)
 *   {
 *       if(조건)
 *       {
 *          출력문 
 *       }
 *   }
 */
public class 자바제어문_반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1~10까지 짝수만 출력 
		for(int i=1;i<=10;i++)
		{
			if(i%2==0)
				System.out.print(i+" ");
		}
		System.out.println();
		for(int i=1;i<=10;i+=2)
		{
			// if(i%2!=0) // i%2==1 , 
				System.out.print(i+" ");
		}
		// 같은 내용을 출력 => 경우의 수가 많다 => 개발자마다 다르게 소스 코딩 : 정답이 없다
		// 요구한 결과물을 출력 
		System.out.println();
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****"); // 가독성 => 다른 프로그래머가 볼 경우 알아보기 쉽게
		// 가독성 = 유지보수 = 최적화
		//        ------   -----
		
		// 유지보수
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

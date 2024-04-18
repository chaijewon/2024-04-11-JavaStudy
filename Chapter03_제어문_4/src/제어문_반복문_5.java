/*
 *   1~100 사이의 ==> 루프변수 => i,j
 *     => 짝수의 합 => 누적변수 
 *     => 홀수의 합
 *     => 전체 합 
 */
public class 제어문_반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum=0,even=0,odd=0;// 합
        int ecnt=0,ocnt=0;// 갯수 
        // 초기값 
        for(int i=1;i<=100;i++)
        {
        	if(i%2==0)
        	{
        		even+=i;// 짝수값 누적 => 복합대입연산자 
        		ecnt++; // 갯수확인 ==> 단항연산자
        	}
        	else
        	{
        		odd+=i; // 홀수값 누적
        		ocnt++; // 갯수확인 
        	}
        	sum+=i; // 전체 합 누적 
        }
        
        System.out.println("1~100 사이의 짝수 합:"+even);
        System.out.println("1~100 사이의 짝수의 갯수:"+ecnt);
        System.out.println("1~100 사이의 홀수 합:"+odd);
        System.out.println("1~100 사이의 홀수의 갯수:"+ocnt);
        System.out.println("1~100 사이의 전체 합:"+sum);
	}

}

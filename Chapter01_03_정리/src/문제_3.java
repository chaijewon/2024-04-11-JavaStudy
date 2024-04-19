/*
 *   5~16까지의 합을 구하시오
 *   ---- for --변수 
 *         5   16    ++
 *   for(초기값;조건값;증가식)
 *   {
 *       반복 처리 
 *   }
 *   
 *   1~100 ==> 좌우대칭 숫자를 추출해서 출력 
 */
public class 문제_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum=0;
        for(int i=5;i<=16;i++)
        {
        	sum+=i;
        }
        System.out.println("결과값:"+sum);
        for(int i=1;i<=100;i++)
        {
        	if(i%11==0)
        		System.out.print(i+" ");
        }
	}

}

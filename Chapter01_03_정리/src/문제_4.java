/*
 * 3이상 4462 이하에서 짝수인 정수의 합을 구하여라.
 * -------------    ------------ 변수
 * for범위
 */
public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum=0,sum2=0;
        for(int i=3;i<=4462;i++)
        {
        	if(i%2==0)
        		sum+=i;
        	else
        		sum2+=i;
        }
        System.out.println("3이상 4462 이하에서 짝수인 정수의 합:"+sum);
        System.out.println("3이상 4462 이하에서 홀수인 정수의 합:"+sum2);
	}

}

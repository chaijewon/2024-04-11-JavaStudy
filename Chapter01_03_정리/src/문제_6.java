/*
 *   1~100까지의 정수 중 4의 배수의 합계를 구하라
 *   -----            ------------변수
 *   for
 */
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum=0;
        for(int i=1;i<=100;i++)
        {
        	if(i%4==0)
        		sum+=i;
        }
        System.out.println("1~100까지의 정수 중 4의 배수의 합계:"+sum);
	}

}

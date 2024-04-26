/*
 *   ★
 *   ★★
 *   ★★★
 *   ★★★★
 *   
 *   줄수  별표
 *    i    j
 *    1    1
 *    2    2
 *    3    3
 *    4    4  ==>  i=j  ==> j=i
 *    
 *    ★★★★
 *    ★★★
 *    ★★
 *    ★
 *    
 *    줄수  별표
 *    i     j  ==> i+j=5   ==> j=5-i
 *    1     4
 *    2     3
 *    3     2
 *    4     1
 *    
 *    ----------------------
 *       *
 *      **
 *     ***
 *    ****
 *    줄수 공백 별표  공백 => i+j=4 ==> j=4-i k=i
 *     i   j   k
 *     1   3   1
 *     2   2   2
 *     3   1   3
 *     4   0   4
 *    
 *    ****
 *     ***
 *      **
 *       *
 *       
 *    줄수 공백 별표
 *    i    j   k    j+1=i  ==> j=i-1
 *    1    0   4
 *    2    1   3
 *    3    2   2
 *    4    3   1    i+k=5 ==> k=5-i
 */
public class 중첩_for_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=4;i++) // 몇줄 
        {
        	// 한줄에 ""을 출력
        	for(int j=1;j<=i-1;j++) // 한줄 몇개 출력 
        	{
        		System.out.print(" ");
        	}
        	// *출력 
        	for(int k=1;k<=5-i;k++)
        	{
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}

}

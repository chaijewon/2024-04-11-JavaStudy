/*
 *   ★★★★★
 *   ★★★★★
 *   ★★★★★
 *   ★★★★★
 *   1차 => 줄수 4 => 1~4
 *   2차 => ★  ==> 5개 ==> 1~5
 *   
 *   ABCD
 *   EFGH
 *   IJKL
 *   MNOP
 *   
 *   ABCD
 *   ABCD
 *   ABCD
 *   ABCD
 *   
 *   ★★☆★★
 *   ★★☆★★
 *   ★★☆★★
 *   ★★☆★★  
 *   
 *   ☆★★★★
 *   ★☆★★★
 *   ★★☆★★
 *   ★★★☆★ 
 *   ★★★★☆
 *   
 *   ☆★★★☆
 *   ★☆★☆★
 *   ★★☆★★
 *   ★☆★☆★ 
 *   ☆★★★☆
 *   
 *   1=5
 *   2=4
 *   3=3
 *   4=2
 *   5=1 ==> 
 *   
 *   i  j
 *   1  5  => i+j=6  i=6-j
 *   2  4
 *   3  3
 *   4  2
 *   5  1 => 더한다 i+j=6 ==> i=6-j
 *   
 *   ♠♥♣◈
 *   ♠♥♣◈
 *   ♠♥♣◈
 *   ♠♥♣◈
 */
public class 중첩_for_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=4;i++)
        {
        	for(int j=1;j<=5;j++)
        	{
        		if(j==3)
        			System.out.print("☆");
        		else
        		    System.out.print("★");
        	}
        	System.out.println();
        }
        System.out.println("===============");
        char c='A'; // for갯수만큼 증가 
        for(int i=1;i<=4;i++)
        {
        	for(int j=1;j<=4;j++)
        	{
        		System.out.print(c++);
        	}
        	System.out.println();
        }
        System.out.println("================");
        for(int i=1;i<=4;i++)
        {
        	c='A'; // 1차 => 초기화
        	for(int j=1;j<=4;j++)
        	{
        		System.out.print(c++);
        	}
        	System.out.println();
        }
        System.out.println("================");
        for(int i=1;i<=5;i++)
        {
        	for(int j=1;j<=5;j++)
        	{
        		if(i==6-j || i==j)
        			System.out.print("☆");
        		else
        		    System.out.print("★");
        	}
        	System.out.println();
        }
        System.out.println("==================");
        // ♠♥♣◈
        String[] img={"","♠","♥","♣","◈"};
        for(int i=1;i<=4;i++)
        {
        	for(int j=1;j<=4;j++)
        	{
        		System.out.print(img[j]);
        	}
        	System.out.println();
        }
	}

}

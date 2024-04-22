/*
 *   8.	1~100 3의 배수이고 5의 배수를 출력하는 프로그램 작성
 */
public class 문제_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 제어문 => 연산자 
        for(int i=1;i<=100;i++)
        {
        	if(i%3==0 && i%5==0)
        	{
        		System.out.print(i+" ");
        	}
        }
        System.out.println("\n======= while ======");
        int i=1;
        while(i<=100)
        {
        	if(i%3==0 && i%5==0)
        	{
        		System.out.print(i+" ");
        	}
        	i++;
        }
        System.out.println("\n======== do~while ======");
        i=1;
        do
        {
        	if(i%3==0 && i%5==0)
        	{
        		System.out.print(i+" ");
        	}
        	i++;
        }while(i<=100);
        // 반복문 => 용도 따라서 사용 
        /*
         *   --------------------------------------
         *   for : 반복의 횟수가 지정 => 화면 출력 
         *   while : 반복 횟수가 없는 경우 => 데이터 관리 
         *   ---------------------------------------
         *   do~while : 무조건 한번 이상 수행 
         */
        
	}

}

/*
 *    1~100까지 정수 => 3의 배수 갯수 , 5의 배수 갯수 , 7의 배수 갯수
 *    -----           ----------   ----------   -----------
 *                    변수 
 *                    => 3,5,7 => 공통 
 *                      15(3,5) , 21(3,7) ,35(5,7)... => 단일 조건문 사용 
 */
public class 자바제어문_반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 변수 설정 => 어떤 값이 변경이 되는지 확인
		int a3=0;
		int a5=0;
		int a7=0;
		// 갯수 누적 (++) , += (누적,합) sum+=i => 값을 계속 더한다 
		for(int i=1;i<=100;i++)
		{
			if(i%3==0)
				a3++;
			if(i%5==0)
				a5++;
			if(i%7==0)
				a7++;
		}
		System.out.println("1~100까지 3의 배수의 갯수:"+a3);
		System.out.println("1~100까지 5의 배수의 갯수:"+a5);
		System.out.println("1~100까지 7의 배수의 갯수:"+a7);
		
	}

}

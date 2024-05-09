// 매개변수의 전송 
// => 메소드안의 변수는 메소드가 종료가 되면 => 자동으로 사라진다 => 다른 메소드로 값을 전송 
import java.util.*;
/*
 *    메소드의 연결 
 *    ----------
 *    숫자야구게임 => 분리 
 *    1) 3개의 중복없는 난수 발생 ==> 1개기능 
 *    2) 사용자부터 3개 정수 입력 
 *    3) 난수 / 사용자 입력 비교 
 *    4) 힌트 제공 
 *    5) 종료 여부 확인 => 다시 게임을 할지 물어본다 
 */
public class 메소드정리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 절차적 언어 => 다시 게임을 할지 물어본다 (불가능) => 재사용이 안된다 
		// 3개의 중복없는 난수 발생
		int[] com=new int[3];
		// com[0]=3 com[1]=3 => com[1]
		/*
		 *   int a=10;
		 *   a++; 11
		 *   a--; 10
		 *   
		 */
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*9)+1; //1~9사이 정수=>중복없이 
			// 중복 체크 
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--; // 다시 발생 (원상 복귀)
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		// 사용자 입력 => 정답입력이 되는 상태 => while
		// 사용자 입력값 저장 
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.print("세자리 정수 입력:");
			int input=scan.nextInt();
			// 오류 처리 
			if(input<100 || input>999)
			{
				// || => 범위를 벗어나는 경우 
				System.out.println("세자리 정수만 사용이 가능합니다");
				// 처음 상태로 돌아간다 
				continue;
			}
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			// 오류 처리 
			if(user[0]==user[1]||user[1]==user[2]||user[0]==user[2])
			{
				System.out.println("같은 수는 사용할 수 없습니다");
				continue;
			}
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0은 사용할 수 없습니다");
				continue;
			}
			
			// 비교
			int s=0,b=0;
			for(int i=0;i<com.length;i++)
			{
				for(int j=0;j<user.length;j++)
				{
					// i=0 => j=0,1,2
					// i=1 => j=0,1,2
					// i=2 => j=0,1,2
					if(com[i]==user[j])// 같은 수가 있는지 
					{
						if(i==j) // 같은 자리 
							s++;
						else
							b++; // 다른 자리
					}
				}
			}
			// 힌트 
			System.out.printf("Input Number:%d,Result:%dS-%dB\n",
					input,s,b);
			// 종료여부 확인 
			if(s==3)
			{
				System.out.println("Game Over!!");
				break;
			}
		}
		
	}

}

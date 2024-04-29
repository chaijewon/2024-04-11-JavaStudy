/*
 *      메소드 => 전체 소스를 분리해서 작업 (분업화)
 *      1) 형식
 *         리턴형 메소드명  (매개변수)  ===========> 선언부 (원형)
 *         ----- 존재 여부 ------- 존재 여부  
 *         {
 *            => 구현 
 *            return 값 => void일 경우에는 생략할 수 있다 
 *         }
 *      2) 유형 
 *         리턴형   매개변수 
 *          O       O
 *          O       X
 *          X       O
 *          X       X 
 *      3) 구현 
 *         {
 *            구현 => 연산자/제어문 
 *         }
 *      4) 호출 
 *         리턴형이 있는 경우 
 *         데이터형 변수=메소드명()
 *         리턴형이 없는 경우 
 *         메소드명()
 *         
 *         --------------------
 *         매개변수 => 메소드(값,값...)
 *         ** 메소드는 호출시마다 => 처음부터 수행 
 *         ** 객체지향의 3대 요소 
 *            --------------- 변수 , 메소드 , 생성자 
 *                            ---   -----  -----
 *         ** 클래스는 1개 기능만 가지고 있다 
 *                   ------ 세분화 : 메소드 
 *                   예) class 예약 =======> 웹 프프로그램에 조립 
 *                      {
 *                         1. 맛집 목록 출력 
 *                         2. 맛집 클릭시에 예약일 출력 
 *                         3. 예약일 클릭시 예약 가능 시간 
 *                         4. 시간 => 인원수 
 *                         5. 예약 버튼 활성화 
 *                      }
 */
import java.util.*;
public class 문제풀이 {
	// => 리턴형 / 매개변수 / 호출 / 메소드 형식 
    // 문제 1  1~10까지 출력하는 메소드를 구현하시오 
	// 리턴형 (X) 매개변수 (X)
	static void munje_1()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.print(i+" ");
		}
	}
	// ==> 출력 
	// 문제 2  1~10까지 합을 구하는 메소드를 구현하시오
	// ==> 합 구하기 
	// 리턴형(O) 매개변수(X)
	/*static int aaa()
	{
		return 'A';
	}*/
	static int munje_2()
	{
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			sum+=i;
		}
		return sum; // 값 = 리턴형에 사용되는 데이터형이 동일 
		// 특별한 경우에는 return 값이 작을 수 있다
	}
	// 문제 3  1~n까지 합을 구하는 메소드를 구현하시오
	// 리턴형(O) 매개변수 (O) ==> n => 사용자의 요청값 
	static int munje_3(int n)
	{
		int sum=0;
		for(int i=1;i<=n;i++)
		{
			sum=sum+i; // sum+=i
		}
		return sum;
	}
	// ==> n => 합
	// 문제 4  두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
	// ==> 두 정수 ==> 결과
	static double munje_4(int a,int b)
	{
		double d=0.0;
		try
		{
			d=a/(double)b;// 정상 수행
		}catch(Exception e)
		{
			System.out.println("0으로 나눌 수 없습니다!!");//오류 발생 
		}
		return d;
	}
	// 문제 5  문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오
	static String munje_5(String str)
	{
		String res="";
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(c>='A' && c<='Z')
			{
				res+=c;
			}
			else if(c>='a' && c<='z')
			{
				res+=(char)(c-32);
			}
			else
			{
				res+=c;
			}
		}
		//return str.toUpperCase();
		return res;
	}
	// ==> 문자열 
	// 문제 6  문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
	static void munje_6(String msg)
	{
		// 구글 
		if(msg.length()%2!=0)
		{
			System.out.println("잘못된 입력입니다");
			return; // 메소드 종료 => return은 원하는 위치에서 사용이 가능 
		}
		/*
		 *    AB|BA
		 *    0123
		 */
	    boolean bCheck=true;
	    for(int i=0;i<msg.length()/2;i++)
	    {
	    	char c1=msg.charAt(i);
	    	char c2=msg.charAt(msg.length()-1-i);
	    	if(c1!=c2)
	    	{
	    		bCheck=false;
	    		break;
	    	}
	    }
	    if(bCheck==true)
	    	System.out.println("좌우 대칭입니다");
	    else
	    	System.out.println("좌우 대칭이 아닙니다");
		
	}
	// ==> 확인 
	// 문제 7  문자열을 거꾸로 출력하는 메소드를 구현하시오
	static void munje_7(String msg)
	{
		for(int i=msg.length()-1;i>=0;i--)
		{
			System.out.print(msg.charAt(i));
		}
		System.out.println();
		System.out.println(new StringBuffer(msg).reverse());
	}
	// ==> 출력
	// 문제 8  학점을 구하는 메소드를 구현하시오 => ChoiceFormat
	static char munje_8(int score)
	{
		char c=' ';
		switch(score/10)
		{
		case 10: case 9:
			c='A';
			break;
		case 8:
			c='B';
			break;
		case 7:
			c='C';
			break;
		case 6:
			c='D';
			break;
		default:
			c='F';
			break;
		}
		return c;
	}
	// ==> 학점 
	// 문제 9  년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
	// ==> 윤년 여부
	static boolean isYear(int year)
	{
		boolean bCheck=false;
		if((year%4==0 && year%100!=0)||(year%400==0))
			bCheck=true;
		else
			bCheck=false;
		return bCheck;
	}
	// 문제 10 두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오
	// ==> 출력 
	// 문제 11 입력 받은 값이 짝수인지 홀수인지 판별하는 메소드를 구현하시오
	// ==> 짝수/홀수
	// 문제 12 3의 배수를 판별하는 메소드를 구현하시오
	// ==> 판별 
	// 문제 13 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
	// ==> 요일
	// 문제 14 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 수를 출력하는 프로그램을 작성하세요
	// ==> 출력 
	static void munje_14(int num)
	{
		System.out.println(num);
		String s=String.valueOf(num);
		// valueOf ==> 모든 데이터형을 문자열로 변환 
		for(int i=s.length()-1;i>=0;i--)
		{
			System.out.print(s.charAt(i));
		}
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//System.out.print("문자열 입력:");
		//String str=scan.next();
		//munje_7(str);
		//char c=munje_8(85);
		//System.out.println(c);
		boolean bCheck=isYear(2024);
		if(bCheck==true) System.out.println("윤년");
		else System.out.println("윤년이 아닙니다");
		//munje_6(str);
		//String res=munje_5(str);
		//System.out.println(res);
		//System.out.print("1' 정수 입력:");
		//int num1=scan.nextInt();
		//System.out.print("2' 정수 입력:");
		//int num2=scan.nextInt();
		//double res=munje_4(num1, num2);
		//System.out.println("res="+res);
		//int sum=munje_3(n);
		//System.out.println("sum="+sum);
		//munje_1();
		// 리턴형이 있는 경우 => 결과값을 받는다 
		//int sum=munje_2(); // 메소드 호출 
		//System.out.println("sum="+sum);
		//System.out.print("정수 입력:");
		///int num=scan.nextInt();
		///munje_14(num);
	}

}

/*
 *    자바에서 지원하는 제어문 
 *    => 조건문 => 연산자 응용 => 부정연산자,비교연산자,논리연산자 
 *       = 단일 조건문 : if 
 *       = 선택 조건문 : if~else 
 *       = 다중 조건문 : if~else if ~ else if ~ else
 *       ** 중첩 조건문 :
 *             if()
 *             {
 *                if()
 *                {
 *                }
 *             }
 *    => 선택문 => 조건이 없고 값 1개 선택 => 정수,문자,문자열 
 *       switch~case  
 *       case 1: => if(num==1) 값이 1일 경우 
 *    => 반복문
 *       for : 반복횟수가 지정된 경우 => 화면 출력 
 *       while : 반복횟수를 모르는 경우 => 데이터베이스값 읽기 => 선조건 
 *       do~while : 사용빈도가 거의 없다 => 무조건 1번 이상 수행 => 후조건 
 *    => 반복제어문  
 *       break : 반복문 종료
 *       continue : 특정부분을 제외 => 처음으로 다시 돌아가는 경우 
 */
import java.util.Scanner;
public class 자바제어문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초 입력: ");
		int num = sc.nextInt();
		
		//1분->60초, 5분-> 300초, 10분-> 600초, 1시간 ->3600초
        int hour = num/3600;
		System.out.print(hour+"시 ");
		
		int minute = num%3600/60;
		System.out.print(minute+"분 ");
		
		int second = num%3600%60;
		System.out.print(second+"초");

	}

}

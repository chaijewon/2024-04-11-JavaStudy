/*
 *  1)	100점 만점으로 성적을 입력 받아 
 *       90~100이면 A,80~89이면 B,
 *       70~79이면 C, 60~69이면 D, 
 *       60점 이하면 F를 출력하라 (switch~case 사용)
 *       
 *       => switch ~ case 
 *       
 *   switch ~ case : 선택문 
 *   ---------------------
 *   if문의 조건문과 다르게 case를 사용 => case에 사용할 수 있는 것 : 정수,문자,문자열
 *   => 값을 한개 지정 
 *   => 값이 입력 => switch에 값을 받는다 
 *      switch(op)
 *   => case 처음부터 검색 
 *   => 해당 문자 ,정수를 찾아서 문장을 수행 
 *   => case를 찾아서 처리하고  break가 없는 경우에는 break가 존재하는 곳까지 문장을 수행 
 *      int a=3;
 *      switch(a)
 *      {
 *        case 1:
 *          문장1
 *        case 2:
 *          문장2
 *        case 3:==>시작 
 *          문장3
 *        case 4: ==> 수행
 *          문장4
 *        case 5: ==> 수행  => 문장3 문장4 문장5
 *          문장5
 *      }
 *      
 *      int a=3;
 *      switch(a)
 *      {
 *        case 1:
 *          문장1
 *        case 2:
 *          문장2
 *        case 3:==>시작 
 *          문장3 ==> 종료하지 않는다 
 *        case 4: ==> 수행
 *          문장4
 *          break;
 *        case 5: ==> 수행  => 문장3 문장4 
 *          문장5
 *      }
 *    
 *      ** 찾은 case부터 break가 있는 case까지 수행 
 *      ** 해당 case에 없는 경우에는 default (생략이 가능) => case마다 break;
 *      ** break는 switch~case를 종료
 *      
 *      ** 보통 프로그램에서는 if를 많이 사용한다 
 *         경우의 수가 많은 경우에는 switch를 주로 이용한다 (게임,메뉴)
 *         => swicth가 if보다 간결하다 
 *         => 네트워크 
 *      ** if => 범위가 있는 경우 
 *         if(score>=90 && score<=100)
 *      ** 값 1개씩 여러개인 경우 => switch
 *         switch(score)
 *         {
 *            case 100: case 99: case 98.... case 90: // /10 => 10,9
 *            
 *         }
 *      switch(정수,문자,문자열)
 */
import java.util.Scanner;
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int score=0;
        // 유효성 검사 
        while(true)
        {
          System.out.print("0~100 사이 정수 입력:");
          score=scan.nextInt();
          if(score<0 || score>100)
          {
        	  System.out.println("다시 입력하세요");
        	  continue;
          }
          break;
        }
        switch(score/10)
        {
		/*
		 * case 100: case 99: case 98: case 97: case 96: case 95: case 94: case 93: case
		 * 92: case 91: case 90: System.out.println("A"); break;
		 */
        case 10: case 9://10,9를 동시에 처리
        	System.out.println("A");
        	break;
        case 8:
        	System.out.println("B");
        	break;
        case 7:
        	System.out.println("C");
        	break;
        case 6:
        	System.out.println("D");
        	break;
        default:
        	System.out.println("F");
        }
	}

}

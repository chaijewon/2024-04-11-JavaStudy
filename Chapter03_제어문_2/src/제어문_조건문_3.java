/*
 *   단일 조건문 
 *   --------- 단점 
 *   if(조건문)
 *   {
 *   }
 *   -----------
 *   if(조건문)
 *   {
 *   }
 *   -----------
 *   if(조건문)
 *   {
 *   }
 *   ------------독립문장 => 속도가 느리다 
 *   if(조건문)
 *   {
 *   
 *   }
 *   ...
 *   
 *   => 선택조건문 => true/false => 나눠서 처리 
 *   형식)
 *        if(조건문)
 *        {
 *           조건이  true일때 처리 
 *        }
 *        else
 *        {
 *           조건이 false일때 처리 
 *        }
 *        
 *        if(조건문)
 *        {
 *        }
 *        ----------------
 *        if(조건문)
 *        {
 *        }
 *        else
 *        {
 *        }
 *        ----------------
 */
// 1. 짝수 => num%2==0 / 홀수 num%2!=0 
/*
 *   if 
 *    => 정상 수행
 *   else
 *    => 오류 => 입력문제 
 *   ------------------
 *   오류 발생 
 *   1) 프로그래머의 실수 => 어렵다 => 예외처리 
 *   2) 사용자 입력 => if~else
 */
public class 제어문_조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num=(int)(Math.random()*100)+1;
        System.out.println("num="+num);
        if(num%2==0)
        {
        	// true일때 처리
        	System.out.println(num+"는(은) 짝수입니다");
        }
        //if(num%2!=0)
        else
        {
        	// false일때 처리
        	System.out.println(num+"는(은) 홀수입니다");
        }
	}

}

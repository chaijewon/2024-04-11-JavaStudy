/*
 *   1) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 
 *      양수인지 음수인지 판별하여 출력하라
 *      --------------
 *      => if~else : 경우수 두개이면
 *         if(양수라면)
 *         {
 *            조건 true => 처리문장
 *         }
 *         else
 *         {
 *            음수라면 
 *            조건 false => 처리문장 
 *         } 
 *         
 *         => 웹 
 *            => 로그인 / 아이디중복 / 아이디찾기 / 비밀번호 찾기 / 검색 / 우편번호 
 *   
 */
import java.util.Scanner;
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        // 사용자 요청 
        // 결과값 출력 => 프로그래머가 처리 
        if(num>=0)
        {
        	System.out.println(num+"는(은) 양수입니다");
        }
        else
        {
        	System.out.println(num+"는(은) 음수입니다");
        }
        
	}

}

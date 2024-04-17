/*
 *    6) 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,
 *       70~79이면 C, 60~69이면 D,
         60점 이하면 F를 출력하라 (다중조건문 사용)

 */
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=(int)(Math.random()*101); // 0~100
        System.out.println("점수:"+score);
        System.out.println("===== 결과값 =====");
        if(score>=90)
        	System.out.println("A학점");
        else if(score>=80)
        	System.out.println("B학점");
        else if(score>=70)
        	System.out.println("C학점");
        else if(score>=60)
        	System.out.println("D학점");
        else
        	System.out.println("F학점");
	}

}

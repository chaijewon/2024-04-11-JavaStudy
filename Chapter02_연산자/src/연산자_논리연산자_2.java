// 점수 >=60 <=100 => true 
public class 연산자_논리연산자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int score=(int)(Math.random()*100)+1; // 1~100 난수 발생 
        System.out.println("난수값:"+score);
        
        boolean bCheck=(score>=60) && (score%2==0);
        //                            짝수 조건 
        System.out.println(bCheck);
        // score가 40이상이고 score홀수면 score%2==1 score%2!=0
        // 재사용 => 변수만 사용 
        bCheck=(score>=40) && (score%2!=0);
        System.out.println(bCheck);
        
        int a=10;
        a++;
        a=100;
        a++;
        a=200;
        a++;
        a=300;
        a--;
        System.out.println(a);
        // 변수 => 필요시마다 변경해서 사용이 가능 
        // main이 종료시까지 메모리가 유지
        
	}

}

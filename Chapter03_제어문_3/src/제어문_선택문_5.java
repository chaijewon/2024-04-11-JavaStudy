// 국어 영어 수학 => 총점 , 평균 (연산자) , 학점 (if , switch)
import java.util.Scanner;
// AI => 개발자(X)
public class 제어문_선택문_5 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("국어 점수 입력:");
        int kor=scan.nextInt();
        System.out.print("영어 점수 입력:");
        int eng=scan.nextInt();
        System.out.print("수학 점수 입력:");
        int math=scan.nextInt();
        
        System.out.println("국어 점수:"+kor);
        System.out.println("수학 점수:"+math);
        System.out.println("영어 점수:"+eng);
        System.out.println("총점:"+(kor+math+eng));
        System.out.printf("평균:%.2f\n",(kor+math+eng)/3.0);
        
        int avg=(kor+math+eng)/30;
        // 10~0
        char score=' ';
        switch(avg)
        {
          case 10:
          case 9:
        	  score='A';
        	  break;
          case 8:
        	  score='B';
        	  break;
          case 7:
        	  score='C';
        	  break;
          case 6:
        	  score='D';
        	  break;
          default:
        	  score='F';
        }
        System.out.println("학점:"+score);
        // 프로그램은 결과값 => 정답은 없다 => 여러가지 경우의 수 
        
	}

}

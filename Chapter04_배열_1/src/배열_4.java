/*
 *   1. 배열 
 *      기능별로 묶는다
 *      ------------
 *      예)
 *          3명의 학생 국어,영어,수학,총점,평균
 *                     3  3   3   3   3  ==> 15
 *                 배열 1  1   1   1   1  ==> 5
 *          int kor1,kor2,kor3
 *          int[] kor
 *          int[] eng
 *          int[] math
 *          int[] total
 *          double[] avg
 *          ------------- 웹에서는 1차 배열 => Collection 
 *          => int[3][5] score
 */
import java.util.Scanner;
public class 배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*
         *      Scanner scan=new Scanner(System.in);
		        int kor1,kor2,kor3;
		        int eng1,eng2,eng3;
		        int math1,math2,math3;
		        int total1,total2,total3;
		        double avg1,avg2,avg3;
		        char score1,score2,score3;
         */
		Scanner scan=new Scanner(System.in);
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		
		for(int i=0;i<3;i++)
		{
			System.out.print((i+1)+"번째 국어 점수 입력:");
			kor[i]=scan.nextInt();
			
			System.out.print((i+1)+"번째 영어 점수 입력:");
			eng[i]=scan.nextInt();
			
			System.out.print((i+1)+"번째 수학 점수 입력:");
			math[i]=scan.nextInt();
			
			total[i]=kor[i]+eng[i]+math[i];
			avg[i]=total[i]/3.0;
			
			switch(total[i]/30)
			{
			case 10: case 9:
	        	score[i]='A';
	        	break;
	        case 8:
	        	score[i]='B';
	        	break;
	        case 7:
	        	score[i]='C';
	        	break;
	        case 6:
	        	score[i]='D';
	        	break;
	        default:
	        	score[i]='F';
			}
		}
		// 출력 
		for(int i=0;i<3;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c\n",
	        		kor[i],eng[i],math[i],total[i],avg[i],score[i]);
		}
	}

}

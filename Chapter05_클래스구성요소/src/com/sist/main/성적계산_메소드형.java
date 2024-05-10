package com.sist.main;
// 국어,영어,수학 점수를 입력을 받아서 => 메소드
// 총점 평균 학점 출력 => 4개 
import java.util.*;
class Student
{
	// 반복 제거 ==> 메소드 첫번째 목적 => 반복적인 소스를 제거 
	public int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	// 총점 => 메소드 종료시에 사라진다 => 결과값을 넘겨준다
	// => 멤버변수 => 프로그램 종료시 메모리가 사라진다 => 메모리(변수) => 모든 메소드에서 사용이 가능 
	public int totalData(int kor,int eng,int math)
	{
		return kor+eng+math;
	}
	// 평균 
	public double avgData(int total)
	{
		return total/3.0;
	}
	// 학점 
	public char scoreData(int avg)
	{
		char c='A';
		switch(avg/10)
		{
		case 10:
		case 9:
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
		}
		return c;
	}
	
	// 출력 => return total,avg,score
	// total,avg,score=메소드()
	public void print(int kor,int eng,int math,int total,double avg,char score)
	{
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println("학점:"+score);
	}
	
	// 프로그램 실행 => 조립 
	public void process()
	{
		int kor=input("국어");
		int eng=input("영어");
		int math=input("수학");
		//총점 
		int total=totalData(kor, eng, math);
		// 평균 
		double avg=avgData(total);
		// 학점
		char score=scoreData((int)avg);
		
		// 출력
		print(kor, eng, math, total, avg, score);
		
	}
}
public class 성적계산_메소드형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student s=new Student();
        s.process();
	}

}

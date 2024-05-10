package com.sist.main;

import java.util.Scanner;

class Student2
{
	private int kor,eng,math,total;
	private double avg;
	private char score;
	// => Student2에 선언되는 모든 메소드에서 사용이 가능 
	// 입력 
	public int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	// total 
	public void totalData()
	{
		total=kor+eng+math;
	}
	// avg
	public void avgData()
	{
		avg=total/3.0;
	}
	// score
	public void scoreData()
	{
		switch(total/30)
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
	}
	// 지역변수 우선순위 => 지역변수,매개변수  ==> 변수가 없는 경우 멤버변수 
	
	public void print()
	{
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println("학점:"+score);
	}
	public void process()
	{
		kor=input("국어");
		eng=input("영어");
		math=input("수학");
		totalData();
		avgData();
		scoreData();
		print();
		
	}
	
}
public class 성적계산_멤버변수형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student2 s=new Student2();
        s.process();
	}

}

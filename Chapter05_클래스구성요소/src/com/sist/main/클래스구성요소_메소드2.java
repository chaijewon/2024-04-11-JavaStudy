package com.sist.main;
import java.util.*;
// Diary.class / 클래스구성요소_메소드2.class
class Diary2{
  	private int year;
  	private int month;
  	private int week;
  	private int lastday;
  	
  	// private => Diary2 클래스안에서는 사용이 가능 => 다른 클래스에 사용한다면 => getter/setter
  	public int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	// 요일 구하기 
	public void getWeek()
	{
		Calendar cal=Calendar.getInstance(); // 객체 생성 방법 => 추상클래스는 new사용해서 객체 생성이 불가능 
		// => 추상클래스 : 미완성된 클래스 => 객체은 new사용하지 않아도 객체 생성이 가능 
		// Spring => new를 사용하지 않고 객체 사용이 가능 => 리플렉션 
		// => 디자인 패턴 / 알고리즘 / 자료 구조 ...
		//    --------- GOF패턴 => 23개 => 8가지
		cal.set(Calendar.YEAR, year);// static final int YEAR
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		// 상수 => static final => 모든 프로그램에서 공유 => 클래스명.상수명  
		// 상수형 => final => 클래스내에서 사용  => 객체명.상수
		
		week=cal.get(Calendar.DAY_OF_WEEK)-1;
		lastday=cal.getActualMaximum(Calendar.DATE);
	}
	
	// 달력 출력 => 전역변수 없이 => 전역변수(멤버변수)
	public void print()
	{
		System.out.println(year+"년도 "+month+"월");
		String[] strWeek={"일","월","화","수","목","금","토"};
		for(String s:strWeek)
		{
			System.out.print(s+"\t");
		}
		System.out.println("\n");
		for(int i=1;i<=lastday;i++)
		{
			if(i==1)
			{
				// 공백 
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			
			 System.out.printf("%2d\t",i);
			
			week++;
			if(week>6)
			{
				week=0;
				System.out.println();
			}
		}
		
	}
	public void process()
	{
		year=input("년도");
		month=input("월");
		getWeek();
		print();
	}
  	
}
public class 클래스구성요소_메소드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Diary2 d=new Diary2();
        d.process();
	}

}

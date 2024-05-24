package com.sist.util;
import java.util.*;
// 사용자 정의 
class Student
{
	private int hakbun;
	private String name;
	private int kor,eng,math;
	// 읽기 / 쓰기 기능 추가 => 다른 클래스에서 사용이 가능하게 만든다 
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	// 자동으로 디폴트 생성자가 생성이 안된다 ...
	// 사용자 입력값을 받아서 초기화 
	public Student(int hakbun, String name, int kor, int eng, int math) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	// 매개변수가 있는 생성자가 있는 경우에는 디폴트 생성자 만들어야 제어가 편리하다 
	public Student()
	{
		// 초기화 => 모든 학생 정보가 같은 값을 가지고 저장이 된다 
	}
	// 데이터 추가 
	
}
class A
{
	int a,b;
	public A()
	{
		a=10;
		b=20;
	}
	public A(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
}
/*
 *    A aa=new A(); 
 *    
 *       --aa--
 *       
 *       ------  ----------
 *                 -----
 *                   10  => a
 *                 -----
 *                   20  => b
 *                 -----
 *               ----------
 *     A bb=new A(); 
 *    
 *       --bb--
 *       
 *       ------  ----------
 *                 -----
 *                   10  => a
 *                 -----
 *                   20  => b
 *                 -----
 *               ----------
 *     A cc=new A(100,200);
 *       --cc--
 *       
 *       ------ -------------
 *                 ------
 *                   100 => a
 *                 ------
 *                   200 => b
 *                 ------
 *              -------------
 *      A dd=new A(1000,2000);
 *       --dd--
 *       
 *       ------ -------------
 *                 ------
 *                   1000 => a
 *                 ------
 *                   2000 => b
 *                 ------
 *              -------------
 */
public class 컬렉션_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Student> list=new ArrayList<Student>();
        // Object => Student변경 
        list.add(new Student(1, "홍길동", 90, 80, 70));//0
        list.add(new Student(2, "박문수", 78, 83, 75));//1
        list.add(new Student(3, "이순신", 95, 80, 70));//2
        list.add(new Student(4, "이산", 89, 80, 70));//3
        list.add(new Student(5, "심청이", 67, 80, 70));//4
        System.out.println("===== 데이터 출력 =====");
        // 배열 / 컬렉션 => for-each를 이용해서 출력 
        /*
         *   %d => 정수 
         *   %s => 문자열 
         *   %c => 문자 
         *   %f => 실수 
         *   
         *   %-3d 
         *   000
         *   1--
         *   %3d
         *   000
         *   --1
         *   %-5s
         *   홍길동--
         */
        for(Student std:list)
        {
        	// 서식이 있는 출력 => 출력 형식을 만들어서 처리
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        	// 웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
        }
        System.out.println("===== 데이터 추가 1=====");
        // Student 추가 
        Student s=new Student();
        s.setHakbun(6);
        s.setName("강감찬");
        s.setKor(78);
        s.setEng(90);
        s.setMath(60);
        list.add(s);
        
        for(Student std:list)
        {
        	// 서식이 있는 출력 => 출력 형식을 만들어서 처리
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        	// 웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
        }
        
        System.out.println("===== 데이터 추가 2======");
        list.add(new Student(7, "춘향이", 89, 80, 90));
        for(Student std:list)
        {
        	// 서식이 있는 출력 => 출력 형식을 만들어서 처리
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        	// 웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
        }
        System.out.println("===== 데이터 출력 =====");
        for(int i=0;i<list.size();i++)
        {
        	Student std=list.get(i); // 형변환없이 사용이 가능 
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        }
        System.out.println("===== 학생 삭제 =====");
        list.remove(3);
        for(Student std:list)
        {
        	// 서식이 있는 출력 => 출력 형식을 만들어서 처리
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        	// 웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
        }
        System.out.println("===== 학생 수정 ======");
        list.set(1, new Student(2,"수정",90,90,90));
        // list.add(new Student(2, "박문수", 78, 83, 75));//1
        for(Student std:list)
        {
        	// 서식이 있는 출력 => 출력 형식을 만들어서 처리
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        	// 웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
        }
        System.out.println("===== 학생 졸업 =====");
        System.out.println(list);
        list.clear();
        for(Student std:list)
        {
        	// 서식이 있는 출력 => 출력 형식을 만들어서 처리
        	System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
        			std.getHakbun(),std.getName(),std.getKor(),
        			std.getEng(),std.getMath());
        	// 웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
        }
        System.out.println("현재 인원:"+list.size());
       
        
	}

}

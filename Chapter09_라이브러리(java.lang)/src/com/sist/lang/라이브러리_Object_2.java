package com.sist.lang;
import java.util.*;
class Sawon
{
	private String name;
	private String sex;
	// 메소드를 통해서 변수에 접근 (읽기/쓰기) => getter/setter => 변수는 은닉화 메소드 통해서 접근 => 캡슐화 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		// this는 Sawon의 객체 => 지역변수 우선순위 
		// 지역변수명=멤버변수가 같은 경우에 => 구분 => this이용한다 
		// 변수가 같을 수 있다 => 멤버변수=Heap , 지역변수=Stack 
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	// toString() => 오버라이딩 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름:"+name+",성별:"+sex;
	}
	// toString() => default (메모리 주소)
	// => Object에서 오버라이딩은 toString => 멤버변수값 확인 
	// 문자열 변환 => 대부분이 자바에서 지원하는 메소드의 리턴형 Object로 되어 있다 
	// 클래스 저장 => Object
	
}
public class 라이브러리_Object_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*Sawon s=new Sawon(); // 메모리에 name,sex이 저장됨 
        s.setName("홍길동");
        s.setSex("남자");
        System.out.println(s);//주소값 => 자동으로 toString() 호출 
        System.out.println(s.toString());//toString() 생략이 가능*/
		/*
		 * ArrayList<Sawon> list=new ArrayList<Sawon>(); list.add(new Sawon());
		 * list.add(new Sawon()); list.add(new Sawon());
		 */
		
		
	}

}

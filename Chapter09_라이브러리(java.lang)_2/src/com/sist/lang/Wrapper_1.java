package com.sist.lang;
/*
 *     Wrapper : 모든 기본형 데이터형를 클래스화 => 기능 부여 => 사용이 쉽게 
 *     -------
 *       ***Integer  :  int
 *          문자열 => 정수로 변환 
 *          Integer.parseInt(String)
 *       ***Double   : double
 *          문자열 => 실수로 변환 
 *          Double.parseDouble(String)
 *       ***Boolean  : boolean
 *          문자열 => 논리형으로 변경  
 *          Boolean.parseBoolean(String)
 *       Float    : float
 *       Byte     : byte 
 *       ------------------ 
 *       
 *       오토박싱 / 언박싱 
 *       -------------
 *       Integer i=10; => 오토박싱 
 *       int ii=i => 언박싱 
 *       
 *       ---------------------
 *       Integer / int 교환이 가능 
 *       
 *        제네릭스 : 데이터형을 변경 => 이미 만들어져 있는 라이브러리의 데이터형 변경 
 *                               --------------------------------
 *                                메소드의 리턴형 / 매개변수 
 *          |
 *        등록 => 클래스만 가능 
 *        <데이터형>
 *        <int> (X) => <Integer>
 *        => 라이브러리 매개변수/리턴형이 변경할 수 있다 => 형변환 없이 사용 
 */
class A<T>
{
	T t;
	public T getT()
	{
		return t;
	}
	public void setT(T t)
	{
		this.t=t;
	}
}
public class Wrapper_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Integer i=100;
        System.out.println(i);
        int ii=i;
        System.out.println(ii);
        // 형변환 없이 사용 
        
        String s="1000";// => 웹에서 자바로 보내는 모든 정수는 문자열 
        System.out.println(Integer.parseInt(s)+1);
        
        
	}

}

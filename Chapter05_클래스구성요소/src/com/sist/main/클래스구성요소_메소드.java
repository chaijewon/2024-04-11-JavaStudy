package com.sist.main;
/*
 *   메소드 
 *     => 문장 => 단락 
 *     => 기능별 분리 => 오류 처리 
 *        -------- 1. 재사용 
 *                 2. 수정이 쉽다 
 *                 3. 추가가 가능 
 *                 4. 유지보수 
 *                 5. 분업 => 나눠서 작업 => 일이 줄어준다 ...
 *                    --------------
 *                    | 인원 
 *     => 역할 : 다른 클래스와 연결해서 사용 
 *        사람클래스 ========== 자판기클래스 
 *                 동전 투입 => 음료수 선택 
 *                           음료수 뽑기 
 *                           잔돈을 돌려준다  ==> 동작 
 *        객체지향 프로그램 = 여러개의 클래스를 만들어서 상호 연결해서 사용 
 *     
 *     
 *     => 사이트 분석 
 *        --------
 *        1. 데이터 확인 
 *        2. 기능 확인 ==> 데이터 추출  
 *        
 *     예)
 *           중복없는 난수 3개 발생  int[] com 
 *           사용자 입력 int[] user
 *           입력값 난수 비교 com/user
 *           힌트  com/user/s/b
 *           종료여부 확인 s==3
 *           
 *     예)
 *          년도/월 입력 year/month 
 *          요일 구하기 => 윤년 처리 => year/month/week
 *          달력출력 => year/month/week 
 */
// public => 한개의 파일에서는 public은 한개만 사용이 가능
import java.util.*;
class Diary
{
	public int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	// 요일 구하기 
	// 달력 출력 => 전역변수 없이 => 전역변수(멤버변수)
}
// public이 있는 클래스가 저장명이 된다 => 자바는 파일명=클래스명이 동일 
public class 클래스구성요소_메소드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Diary d=new Diary(); // input => 저장 
        int year=d.input("년도");
        int month=d.input("월");
        System.out.println(year+"년도 "+month+"월");
	}

}

package com.sist.util;
import java.text.SimpleDateFormat;
// 332page => 날짜 
/*
 *   Date / Calendar 
 *   => 웹에서 날짜 출력 
 *      댓글 (날짜,시간) , 게시판 (입력된 날짜) , 예약일 ....
 *      => 오라클 
 *         데이터형 => 정수/실수 => 숫자형 (Number)
 *         문자 => VARCHAR2 , CHAR , CLOB => String 
 *         날짜 => DATE 
 *   Date => 간단한 날짜 정보 , 기능은 없다 , 오라클 호환 , 일반 클래스  
 *           ------------  Date date=new Date() => 시스템의 날짜,시간 
 *   Calendar => Date에 없는 기능을 보완 
 *        => 달력 만들기 , 일정표 ...
 *        => 요일 , 마지막날 읽기 ...
 *        => 추상 클래스 
 *           ==> new 사용할 수 없다 
 *           Calendar cal=Calendar.getInstance() => 디자인 패턴 => 싱글턴 패턴 
 *                                                             ----------
 *                                                             => 1개의 객체 주소만 이용 
 *                                                             => 스프링은 싱글턴 
 *        
 *   
 */
import java.util.*;
public class 라이브러리_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Date date=new Date();
        //System.out.println(date);
        // 오라클에서 날짜를 받는 경우에 주로 사용 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
        String today=sdf.format(date);
        StringTokenizer st=new StringTokenizer(today,"-");
        int year=Integer.parseInt(st.nextToken());
        int month=Integer.parseInt(st.nextToken());
        int day=Integer.parseInt(st.nextToken());
        
        System.out.println(year+"년도 "+month+"월 "+day+"일");//자바 탄생일 => 자바 , GO , Dart => Flutter
        // MM => 01 ~ 09 11 12
        // M => 1 2 3... 11 12
        // System.out.println(09);
        // 0 => 8진법 표현 
        // 요일 확인 / 마지막 날 
        Calendar cal=Calendar.getInstance();
        // 설정
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, day);
        
        int week=cal.get(Calendar.DAY_OF_WEEK);// 요일 읽기 
        String[] strWeek={"","일","월","화","수","목","금","토"};
        System.out.println(today+"의 요일은 "+strWeek[week]+"요일");
        int lastday=cal.getActualMaximum(Calendar.DATE);
        System.out.println("마지막 날:"+lastday);
	}

}

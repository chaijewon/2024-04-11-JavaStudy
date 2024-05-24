package com.sist.main;

import java.util.Arrays;

/*
 *   자바에서 지원하는 클래스의 집합 => 라이브러리 (완제품 => 특별한 경우가 아니면 그대로 사용)
 *   => 운영체제와 연결 => API (Application Program Interface) 
 *   => 분류 : 패키지 => 관련된 클래스끼리 모아서 제공 
 *      ***java.lang : 자바의 기본 클래스 => import를 생략할 수 있다
 *         Object : 최상위 클래스 => 모든 클래스의 상속을 내려주는 클래스 
 *                  extends Object
 *                  --------------
 *                  객체와 관련된 기능(메소드)을 제공
 *                  ***= 메모리 할당시 주소값 확인 : toString()
 *                  = 객체 사용시 복제해서 사용 : clone() ==> 스프링 (prototype)
 *                            ---- 새로운 메모리를 만들어서 사용
 *                  =  객체 소멸자 , 메모리가 해제시 호출 : finalize()
 *                  ***=  객체 메모리 주소를 리턴 => 필요시에는 변경이 가능 : hashCode()
 *                  ***=  객체 비교 : equals   
 *                  *** Object가 가지고 있는 기능 => 모든 클래스에서 사용이 가능 
 *                                             -------------------- 필요시에는 오버라이딩해서 사용이 가능
 *                                                                         --------
 *                                                                          메소드 내용을 변경 
 *                                                                          => toString()
 *                                                                          => hashCode()
 *         String : 문자열을 저장하는 클래스 
 *                  String s=""
 *                  String s=new String("") => 새로운 메모리에 저장해서 사용 , 한글 변환 코드 
 *                  C언어   자바언어 
 *                  ----   -----
 *                  ASC     Unicode => 각국의 언어를 사용이 가능하게 만들어 준다 => UTF-8
 *                  => 1byte  => 2byte 
 *                  => 한글이 깨진다 (알파벳,숫자=>한글 : 포인터)
 *                  => Encoding / Decoding 
 *                    Encoding (Byte배열) 자바 => %EC%9E%90%EB%B0%94
 *                  자바 ==> 브라우저(C언어)
 *                     자바 <== %EC%9E%90%EB%B0%94
 *                    Decoding 
 *                  기능(메소드) 
 *                  
 *                  1. 문자의 갯수 : length()
 *                  2. 문자를 있는 그대로 가지고 오기 : toString()
 *                  3. 문자 변환 : replace(),replaceAll()
 *                  4. 문자 위치 찾기 : indexOf() , lastIndexOf()
 *                  5. 문자제어 자르기 : substring() , split()
 *                  6. 공백문자 제거 : trim()
 *                  7. 모든 데이터형을 문자열 변경 : valueOf()
 *                  8. 비교 : equals() 
 *                  7. 검색 : startsWith() , endsWith(), contains()
 *                  => 웹의 핵심
 *                     1) 문자열 제어 
 *                     2) 데이터베이스 연동 
 *                     --------------- => 웹 프로그램 (92%)
 *         StringBuffer : 문자열 결합 
 *            => append()
 *         Math : 수학 
 *            => 올림 : ceil()
 *            => 난수발생 : random() => Random
 *         System
 *            => exit() : 프로그램 종료 
 *            => gc() : 메모리 회수 
 *         Wrapper => 제네릭에서 주로 사용 
 *           = Integer : parseInt() => 문자열을 정수형 변환 
 *           = Double  : parseDouble() => 문자열 실수형 변환 
 *           = Boolean : parseBoolean() => 논리형 변환 
 *      ***java.util : 프로그램 사용에 유용하게 사용할 수 있게 만든 클래스 집합 
 *         Random : 난수 발생 
 *            => nextInt() => nextInt(100) => 0~99
 *         Date : 기능이 없다 => 생성 Date date=new Date()
 *                => 오라클 날짜 데이터와 호환 => 데이터베이스 호환 
 *         Calendar : Date에 없는 기능 첨부 
 *                => 추상 클래스로 되어 있다 
 *                   -------- new 사용할 수 없다 
 *                   Calendar cal=Calendar.getInstance()
 *                   => 요일 , 마지막 날 구하기 
 *                   => 예약 / 예매 => 달력  
 *         StringTokenizer : 단어별 분리할때 주로 사용 
 *                   => nextToken() : 분리된 단어를 한개씩 읽어 올때 
 *                   => countTokens() : 분리된 단어의 갯수 
 *                   => 반복문 수행 => hasMoreTokens()
 *         -------------------- 제네릭 (데이터형을 변경 => Object : 형변환) <클래스명>
 *                              => 기본형 데이터는 사용이 불가능 하다
 *                                 ---------- 각 데이터형마다 클래스를 지원 (Wrapper)
 *         ArrayList
 *            => 중복된 데이터가 있는 경우 
 *            => 순서(인덱스 자동 조절이 된다) => 구분자 (인덱스)
 *            ***=> 추가  ==> add()
 *            => 수정  ==> set()
 *            => 삭제  ==> remove()
 *            ***=> 전체 삭제 ==> clear()
 *            ***=> 저장 갯수 ==> size()
 *            ***=> 읽기  ==> get()
 *            => ArrayList가 여러개 있는 경우 
 *               = retainAll() => 같은 값(교집합)
 *               = removeAll() => 차집합 => 한쪽에 없는 데이터
 *               = addAll() => 전체 데이터 복사 
 *               = subList() => 부분 데이터 복사
 *         HashSet 
 *            => 중복이 없는 데이터 
 *            => 순서가 없다 (출력시에 원하는 순서로 출력이 안되는 경우도 있다) => 중복제거 => list로 변경 
 *            => 구분자 => 자체 값
 *            ***=> add()
 *            ***=> clear()
 *            => iterater()
 *         HashMap 
 *         ---------------------
 *      java.text : 변환 (숫자,날짜변환) 
 *         DecimalFormat : format()
 *            ***DecimalFormat df=new DecimalFormat("###,###,###,###"); // 오라클 9,999,999
 *         SimpleDateFomat : format()
 *            ***SimpleDateFormat sdf=new SimpleDateDormat("yyyy-MM-dd");
 *              년도 => yyyy 
 *              월  => MM/M
 *              일  => dd/d
 *              시간 => hh/h
 *              분  => mm/m
 *              초  => ss/s
 *      --------------------------------------
 *      java.io : 입출력 (메모리 , 파일 , 네트워크)
 *      java.net : 네트워크 프로그램 개발 
 *      ***java.sql : 데이터베이스 프로그램 개발 
 *      --------------------------------------
 */
import java.net.*;
public class 라이브러리_정리 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        //System.out.println("자바".getBytes());
		String s=URLEncoder.encode("자바", "UTF-8");
		System.out.println(s);
		s=URLDecoder.decode(s, "UTF-8");
		System.out.println(s);
	}

}

package com.sist.util;
/*
 *    라이브러리 : 자바에서 지원하는 클래스의 집합 
 *                          ---------- 관련된 클래스 모음 (패키지)
 *    1. java.lang : import를 사용하지 않는다 => 자동 인식  
 *         => ***Object : 최상위 클래스 => 모든 클래스(사용자 정의)의 상속을 내리는 클래스 
 *            => 기능(메소드) 
 *               toString() : 객체를 문자열화 
 *               clone() :복제 (새로운 메모리를 생성) => prototype 
 *               equals() : 객체 비교 
 *               finalize() : 소멸자 
 *               hashCode() => 객체 주소를 반환 
 *             => Object는 가장 큰 데이터형 
 *         => ***String : 문자열 저장하는 데이터형 
 *             => 웹에서 가장 많이 사용되는 데이터형 
 *             => 기능(메소드) 
 *                length() : 문자갯수 확인 => int 
 *                equals() : 실제 저장된 문자열 비교 => 대소문자 구분
 *                substring() : 문자열을 자르는 경우 => 화면 UI => CSS => ...
 *                trim() : 좌우의 공백 제거 => 사용자 입력에서 실수 ...
 *                valueOf() : 모든 데이터형을 문자열로 변환 
 *                replace() , replaceAll() : 문자 변환 
 *                indexOf(),lastIndexOf() : 문자나,문자열의 위치 찾기 
 *                -----------------------------------------------------
 *          => StringBuffer : 임시저장장소를 만들어서 문자열 결합 => 최적화 
 *             => append() : 문자열 결합 
 *          => Math : 수학연산 
 *             => random() : 임의 추출 
 *             => ceil() : 올림
 *          => System : 운영체제와 연결 
 *             => print,printf,println
 *             => gc() : 메모리 회수 
 *             => exit() : 프로그램 종료 
 *          => ***Wrapper : 기본 데이터형(int,long,double)을 쉽게 사용이 가능하게 기능 부여 
 *             int => Integer  ====> Integer.parseInt()
 *             double => Double ===> Double.parseDouble()
 *             boolean => Boolean  ==> Boolean.parseBoolean()
 *             byte  => Byte 
 *             ------------------> 변환 (문자열) => 정수,실수,논리형 
 *           라이브러리 : 
 *              1) 어떤 클래스의 메소드 
 *              2) 원형 => 리턴형 / 매개변수 (static,instance)
 *              3) 어떤 기능을 가지고 있는지 ..
 *              4) 사용처 
 *              
 *       2. java.util 
 *          ----------
 *            = 클래스를 사용하기 위해서는 반드시 import를 사용한다
 *            = 프로그램에 많이 유용하게 사용할 수 있는 클래스의 집합 
 *            = 날짜관련 
 *               ***Date : 기능에 없다 (오라클에서 저장된 날짜를 읽어서 저장) 
 *                 => 기능을 추가 : Calendar
 *            = 문자열을 분해 
 *               StringTokenizer => split() => 배열 (제어하기 어렵다) 
 *               --------------- 단어별 추출 
 *            = ***자료구조 => 데이터를 저장해서 쉽게 관리 => 배열(X)
 *              ------ 라이브러리 => 표준화
 *                  Collection : interface 
 *                      |
 *              -----------------------------
 *              |            |              |
 *            List          Set            Map => interface 
 *              |            |              | Spring/Mybatis
 *        ------------      ------          --- ===> 구현한 클래스 
 *          ***ArrayList     ***HashSet        Hashtable
 *          LinkedList       TreeSet        ***HashMap
 *          Vector
 *          Stack / Queue
 *          ----------------------- CRUD가 가능하다 (추가,수정,삭제,읽기)
 *          
 *          List 
 *          ------
 *            1. 중복을 허용한다 
 *            2. 순서가 존재 => 인덱스 번호 
 *               0
 *               1
 *               2 => 삭제 
 *               3 => 2
 *               4 => 3
 *               5
 *            3. 데이터베이스에 데이터를 저장해서 브라우저에 전송 
 *            
 *            -------------------
 *              0  데이터 
 *            -------------------
 *              1  데이터
 *            -------------------
 *              2  데이터
 *            -------------------
 *          Set
 *          ----
 *            1. 중복을 허용하지 않는다 
 *            2. 순서가 존재하지 않는다 
 *            3. 중복을 제거 => 장르 / 카테고리 / 부서명 / 근무지 
 *            
 *            ---------------
 *              데이터 1
 *            ---------------
 *              데이터 2
 *            ---------------
 *              데이터 3
 *            ---------------
 *          Map 
 *          ----
 *            1. 키,값으로 구성된다 
 *            2. 키는 중복이 불가능 => 값은 중복허용 
 *            3. 많이 사용되는 곳 => 세션 ("id","hong") , 브라우저에서 자바로 요청값 전송 , 쿠키 
 *                              클래스 등록 
 *                              웹에서 70% => Map으로 되어 있다 
 *            -----------------
 *              id    hong
 *            -----------------
 *              pwd  1234
 *            -----------------
 *              name 홍길동 
 *            -----------------
 *           
 *       3. java.text 
 *       4. java.io
 *       5. java.net : 데이터 수집 => 크롤링
 *       6. java.sql : 오라클 연결 
 *          -------------------
 *          
 *          브라우저    =====   자바  ===== 오라클 
 *                                      -----
 *                                      | 사용자가 볼 수 있게 데이터 저장 장소 
 *                                                       ----------- 데이터베이스 
 *                                                       => 저장 / 읽기 / 수정 / 삭제 => CRUD
 *                           ----
 *                           | 브라우저에서 사용되는 언어 (브라우저에서 자바는 일반 텍스트) => HTML/XML
 *                             ML => <a> : 태그 => 사용자 정의
 *                             HTML/XML은 오라클을 연결하는 언어가 아니다.. (화면 출력)
 *                           | 자바는 오라클에 있는 데이터를 관리 
 *          ------
 *          화면 출력 (JavaScript) => NodeJS
 *          String / ArrayList / Integer => 웹에서 사용하는 3대 클래스    
 *              
 *                
 */
// 323page  => Random 
// Random => 임의로 추출 => 정수
/*
 *    정수 => nextInt() => 정수형 전체 => 0~21억 4천 
 *          -----------
 *          nextInt(10) => 0~9
 *          nextInt(46) => 0~45
 *                 ---- 제외  
 */
import java.util.*;
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Random r=new Random();
        //int num=r.nextInt(10); // 0~9 => 사이의 정수를 임의로 추출 
        //System.out.println(num);
        // A~Z => 10개 발생 => 26 => 65
        for(int i=1;i<=10;i++)
        {
        	char c=(char)(r.nextInt(26)+65);
        	System.out.print(c+" ");
        }
        System.out.println();
        for(int i=1;i<=6;i++)
        {
        	int lotto=r.nextInt(45)+1; //1~45
        	System.out.print(lotto+" ");
        }
        
	}

}

package com.sist.main;
// Movie를 불러온다 
import com.sist.vo.Movie;
// 클래스가 다른 폴더에 저장된 경우는 반드시 import를 이용해서 불러온다 
//       -------- 패키지
/*
 *   private / public 
 *   
 *   변수 => private => 데이터 공개 (X)
 *          => 접근이 가능하게 만든다 
 *          => getXxx() , setXxx()
 *   메소드 / 클래스 / 생성자 => 다른 클래스에서 연결 => public 
 *   
 *   127page 
 */
import java.util.*;
import java.sql.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 메모리 저장 
		//com.sist.vo.Movie movie=new com.sist.vo.Movie();
		java.util.Date date=new java.util.Date();// 클래스 충돌 
		Movie movie=new Movie();
		// 데이터 초기화 
		movie.setRank(1);
		System.out.println("순위:"+movie.getRank());
		
	}

}

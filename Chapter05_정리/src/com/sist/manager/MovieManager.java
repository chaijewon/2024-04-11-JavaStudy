package com.sist.manager;
// 사용자의 요청이 있는 경우 처리 
// 모든 데이터 관리 
/*
 *   1. 데이터 읽기 => 시작과 동시에 => 초기화 
 *                              ----- 자동 초기화 / 생성자 
 *   2. 요청에 대한 처리 => 메소드 
 *      => 전체 목록 (페이지 나누기)
 *      => 검색 결과 출력 
 *      => 상세보기 
 *   ------------------------------ 윈도우 
 *   3. 패키지 => 관련된 클래스를 모아서 관리 
 *      => 접근지정어 => public 
 */
import java.io.*;
import java.util.*;
import com.sist.vo.*; // Movie 
public class MovieManager {
   // Movie에 있는 모든 데이터를 읽어서 저장 => 변수 => 모든 User가 공통된 데이터를 사용한다 
   private static Movie[] movies=new Movie[1938]; // 목록을 저장 => 모든 데이터가 동일 
   /*
    *   변수 => 기본형 / 배열 / 클래스 
    *   Movie : 사용자 정의 테이터형 => 배열 , 형변환도 가능하다 
    *   
    *   초기화 
    *   static 
    *   {
    *   }
    *   생성자
    */
   // 초기화 => 생성자 => UserMain에서 사용  
   public MovieManager()
   {
	   // 파일에서 데이터를 읽어서 저장 => 예외처리 => 컬렉션 
	   try
	   {
		   // 정상적으로 수행 => 명령문 
		   // => 예외처리는 모든 문장에 있다 => 생략 => 파일입출력 / 네크워크 / 데이터베이스
		   FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
		   int i=0; // fr.read() => 리턴형 => int (문자의 번호를 읽어온다)
		   StringBuffer sb=new StringBuffer(); // 읽어서 데이터를 누적 
		   //String data="";
		   while((i=fr.read())!=-1) // -1:파일끝 (EOF)
		   {
			   sb.append((char)i);
			   //data+=(char)i;
		   }
		   // 반드시 파일 닫기
		   fr.close();
		   
		   String data=sb.toString(); // 전체 데이터를 모운다 
		   
		   String[] temp=data.split("\n"); // 한줄씩 저장 
		   i=0;
		   for(String s:temp)
		   {
			   String[] movie=s.split("\\|");
			   // split , replaceAll => ? , . , + , * , | => 기호 자체 => \\. 
			   // \\를 사용하지 않으면 => 연산자로 처리 
			   // \"  \' \\
			   movies[i]=new Movie();
			   movies[i].setRank(movie[0]);
			   // 변수에 값을 설정 ==> setter
			   movies[i].setTitle(movie[1]);
			   movies[i].setGenre(movie[2]);
			   movies[i].setPoster(movie[3]);
			   movies[i].setActor(movie[4]);
			   movies[i].setRegdate(movie[5]);
			   movies[i].setGrade(movie[6]);
			   movies[i].setDirector(movie[7]);
			   i++;
					   
		   }
	   }catch(Exception ex){}
	   
   }
   
   /*public static void main(String[] args) {
	  MovieManager m=new MovieManager();
	  for(Movie movie:m.movies)
	  {
		  System.out.println(movie.getRank()+"."+movie.getTitle());
	  }
   }*/
   // 목록 출력 
   public Movie[] movieListData(int page)
   {
	   int total=movieTotalPage();
	   int leng=20;
	   if(page==total)// 마지막 페이지면
		   leng=18;
	   // 배열의 단점 => 고정 => 보완 (컬렉션=12장)
	   Movie[] movie=new Movie[leng];
	   
	   int j=0; // 20개씩 나눠주는 변수 
	   int pagecnt=(20*page)-20;
	   
	   /*
	    *    1page => 0~19 (20)
	    *    2page => 20~39
	    *    3page => 40~59
	    *    ...
	    *    ...
	    *    ...
	    */
	   for(int i=0;i<movies.length;i++)
	   {
		   if(j<20 && i>=pagecnt)
		   {
			   movie[j]=new Movie();
			   movie[j]=movies[i];
			   j++;
		   }
	   }
	   
	   return movie;
   }
   public int movieTotalPage()
   {
	   return (int)(Math.ceil(movies.length/20.0)); //ceil올림 
   }
   // 상세보기 
   public Movie movieDetailData(int mno)
   {
	   return movies[mno-1];
   }
   // 검색 
   public Movie[] movieFindData(String title)
   {
	   int count=0;
	   for(Movie m:movies)
	   {
		   if(m.getTitle().contains(title))
		   {
			   count++;
		   }
	   }
	   // 선언 => 갯수 확인 => 갯수확인 => 데이터값 채우기 => 동일하면 선언 => 동일이 하지 않는 경우 
	   Movie[] movie=new Movie[count];//동적 => 가변형 
	   int i=0;
	   for(Movie m:movies)
	   {
		   if(m.getTitle().contains(title))
		   {
			   movie[i]=m;
			   i++;
		   }
	   }
	   
	   return movie;
	   
   }
   // 웹 => 목록(페이징) => 20~40 => 15 => 총페이지 
   public static void main(String[] args) {
	   Scanner scan=new Scanner(System.in);
	   MovieManager m=new MovieManager();
	   /*int total=m.movieTotalPage();
	   // 인스턴스변수 / 인스턴스메소드 ==> 99:1
	   System.out.print("1~"+total+"사이의 페이지 입력:");
	   int page=scan.nextInt();
	   
	   // 데이터 읽기
	   Movie[] movie=m.movieListData(page);
	   for(Movie mm:movie)
	   {
		   System.out.println(mm.getRank()+"."+mm.getTitle());
	   }*/
	   System.out.print("검색어 입력:");
	   String title=scan.next();
	   
	   Movie[] movie=m.movieFindData(title);
	   for(Movie mm:movie)
	   {
		   System.out.println(mm.getRank()+"."+mm.getTitle());
	   }
	   
	   System.out.println("======================================");
	   System.out.print("상세볼 영화번호:");
	   int mno=scan.nextInt();
	   
	   Movie mmm=m.movieDetailData(mno);
	   // 메소드 (요청에 처리 => 기능) 
	   // 처리 기능 / 데이터만 있는 클래스(데이터형) 
	   // 파일 / 오라클 => 데이터만 있는 클래스에 값을 채워서 전송 
	   System.out.println("순위:"+mmm.getRank());
	   System.out.println("영화명:"+mmm.getTitle());
	   System.out.println("감독:"+mmm.getDirector());
	   System.out.println("출연:"+mmm.getActor());
	   System.out.println("장르:"+mmm.getGenre());
	   System.out.println("등급:"+mmm.getGrade());
	   System.out.println("개봉일:"+mmm.getRegdate());
	   
	   // => 목록 / 상세보기 / 검색 => 기본 
	   
   }
   /*
    *   주력 
    *   ----
    *     데이터 모우기 : Movie => 멤버변수  
    *     ---------
    *     기능 설정 => 목록 / 상세 / 검색 / 예약 / 댓글 .... => 메소드 => 액션 클래스 
    *               데이터 읽기 => 초기화(전체목록) => 생성자
    *     ----------
    *     다른 클래스에 활용 : 접근지정어 
    *     ------------- private/protected/default => 사용할 수 없다 (접근이 안된다)
    *                   public 
    *                   --> 데이터 : 접근 금지 
    *                       => 데이터 기능설정 메소드 
    *                          getXxx() , setXxx() => getter/setter
    */
}








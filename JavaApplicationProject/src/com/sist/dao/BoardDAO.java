package com.sist.dao;
/*
 *    DQL / DML 수행  => DDL,DCL,TCL : 오라클에서 작업 
 *    ---------                ---- 오라클 명령어로 사용하는 것이 아니다 => 메소드 (commit(),rollback())
 *                             | 설정이 없으면 AutoCommit()
 *      => 프로그램 : 데이터 관리 
 *                 --------- CRUD (SELECT / INSERT / UPDATE / DELETE) => 핵심 : 게시판 
 *      1. DQL : 데이터 검색 (SELECT) 
 *         자바 =======> 오라클 
 *             SQL문장 
 *             ------> 오라클 문법에 맞춘다 
 *         SELECT 
 *         -------
 *           형식) SELECT * | column1,column2...
 *                FROM table_name | view_name | (SELECT ~~) 
 *                                              ------------
 *                                              1. 페이지 나누기 
 *                                              2. 인기 순위 
 *                                              ------------ rownum(가상컬럼=> INSERT마다 번호를 자동지정)
 *                                                            => 1번부터 => 인라인뷰 
 *                [
 *                   WHERE 조건문 (연산자) => 컬럼(함수) 연산자 값
 *                                                     -- 직접대입 , 사용자 입력값 , (SELECT~) => 뷰
 *                   GROUP BY 그룹컬럼(함수) => 관리자 => 통계 (지정된 그룹별로 따로 설정)
 *                   HAVING 그룹조건 => 반드시 GROUP BY를 동반 
 *                          ------ 집합함수 (COUNT,AVG,SUM)
 *                   ORDER BY 컬럼(함수) (ASC|DESC) 
 *                     => 처리하는 속도가 늦다 => INDEX
 *                   => 다음주 : 오라클 고급 / 화면 출력 (HTML/CSS)
 *                             INDEX / PLSQL / 데이터베이스 설계 ==> DBA 
 *                      -----------------------------------
 *                ]
 *           => 1. 형식 => 화면 설계 , 2. 연산자 (조건에 맞는 데이터 추출) , 3. 내장 함수 
 *              4. 정렬 => 최신 데이터를 먼저 출력 => DESC
 *              ----------------------------------------------------------
 *           DML : 데이터 조작언어 
 *           INSERT => 데이터 저장 
 *             => 형식) 
 *                     1. 컬럼 전체에 값을 저장 
 *                        INSERT INTO table_name VALUES(값....)
 *                             숫자 : 10 , 20 ...
 *                             문자 : ''
 *                             날짜 : SYSDATE(현재날짜) , 'YY/MM/DD'
 *                     2. 원하는 컬럼에만 값 저장 
 *                        INSERT INTO table_name(컬럼명,컬럼명...) VALUES(값...)
 *                          => 컬럼에 null값 허용 / default가 있는 경우 
 *           UPDATE => 데이터 수정 
 *              => 형식) 
 *                      UPDATE table_name SET
 *                      컬럼명=값 , 컬럼명=값...
 *                      [WHERE 조건문]
 *           DELETE => 데이터 삭제 
 *              => 형식) 
 *                      DELETE FROM table_name
 *                      [WHERE 조건문]
 *                      
 *           = 주의점 
 *             문자열 => "" 
 *             ----------- 1. 공백 , 2. '' , 3. ;을 사용하면 오류 => 자동으로 ;을 붙여준다 
 *             ----------- AutoCommit() => 잘못된 데이터가 저장 => 복구할 수 없다 
 *             --> 조인 / 서브쿼리 / NULL 값 처리 => NVL()
 *             --> '' => NULL , ' '
 *             String sql="SELECT "
 *                       +"FROM "
 *                       +"WHERE ~"
 *          
 */
// 1. 목록 : 번호 / 제목 / 이름 / 작성일 / 조회수 
/*
 *    게시판 ==> 흐름 (웹 : 로직 (X) , 데이터베이스 연동 => 이동) 
 *              목록                          상세보기 
 *               |                             |
 *         -------------                 ----------------------
 *         |           |                 |              |     |
 *       글쓰기       상세보기 => 이동        수정            삭제   목록 => 목록 이동  
 *        |                              |              |
 *       완료 => 목록이동                   완료 => 상세보기  완료 => 목록
 *       
 *       
 *       => VO / DAO / Service / Config 
 *          ---------  ------- Open API
 *          장점 : 윈도우 / 모바일 / 웹 => 상관없이 소스가 동일 => 운영체제와 관계없다 
 *                                                     -------------- 개발 (윈도우) , 호스팅:리눅스 
 *          
 */
import java.util.*;
import java.sql.*;
public class BoardDAO {
   // 오라클 연결 객체 
   private Connection conn; // Socket 
   // 오라클 송수신 => Socket / OutputStream , BufferedReader => NetWork 
   private PreparedStatement ps;
   // 오라클 주소 : 상수형 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE"; //xe=>테이블이 저장된 데이터베이스(폴더)
   // 객체 한번만 생성 => 싱글턴 
   private static BoardDAO dao;
   // 드라이버 등록 = 오라클 연결 = SQL문장 전송 = 결과값 읽기 = 데이터 모아서 = 윈도우로 전송 
   public BoardDAO()
   {
	   // 시작과 동시에 수행문장 , 멤버변수 초기화 
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   // 오라클 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // 대문자 구분
		   // 오라클로 명령 => conn hr/happy
	   }catch(Exception ex) {}
   }
   /*
    *     Connection 
    *     PreparedStatement 
    *     ResultSet 
    *     
    *     ResultSet.close()
    *     PreparedStatement.close()
    *     Connection.close()
    */
   // 오라클 닫기 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 싱글턴 
   public static BoardDAO newInstance()
   {
	   if(dao==null)
		   dao=new BoardDAO();
	   return dao;
   }
   //////////////////////////// 공통 기반 => 웹 (클래스 => jar) => 라이브러리화 
   // 기능 => 리턴형 (어떤 데이터를 보내줄지) , 매개변수 (사용자로부터 어떤 값을 받을지) 
   // 1. 목록 => 페이지 나누기 (인라인뷰) 
   // VO => 한개의 게시물 정보 => (컬렉션 / 배열)를 이용해서 여러개를 묶어서 전송 
   /*
    *    Collection 
    *          Collection 
    *             |
    *    ----------------------------
    *    |            |             |
    *   List         Set           Map  ==> interface 
    *                              => Map map=new HashMap()
    *                => Set set=new HashSet()
    *   => List list=new ArrayList()
    *    |            |             |
    *  ArrayList    HashSet       HashMap 
    *  ---------   ---------     ---------
    *                             => 클래스 관리 / SQL문장 관리
    *                                --------   ----------
    *                                 | 스프링     | MyBatis 
    *                             => 키,값 => 두개를 동시에 저장 
    *                                키(중복이 없다), 값(중복이 가능) => Cookie / Session 
    *               => 웹 실시간 채팅 (사용자 정보)
    *               => 순서는 없다 
    *               => 데이터중복을 허용하지 않는다 
    *  => 데이터베이스에서 데이터를 모아서 저장 
    *     순서가 존재 (인덱스) 
    *     데이터 중복을 허용 
    *     비동기 방식 => ORDER BY를 사용하지 않으면 순서가 일정하지 않는다 
    */
   public List<BoardVO> boardListData(int page)
   {
	   // 리턴형 => return 
	   List<BoardVO> list=new ArrayList<BoardVO>(); // VO(게시물 1개) => VO 여러개를 보내준다 
	   try
	   {
		   // 1. 연결 
		   getConnection();
		   // 2. 오라클로 보낼 SQL문장 
		   String sql="SELECT no,subject,name,regdate,hit,num "
				     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
				     +"FROM (SELECT no,subject,name,regdate,hit "
				     +"FROM board ORDER BY no DESC)) "
				     +"WHERE num BETWEEN ? AND ?";
		   //   1page => 1 ~ 10 
		   //   2page => 11 ~ 20
		   ps=conn.prepareStatement(sql); // 먼저 전송 
		   // 실행 요청전에 => ?에 값을 채운다 
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1); // 10-9 = 1
		   // 2=> 20-9 => 11
		   int end=rowSize*page;// 10 , 20
		   
		   // 이전 다음 => < [1][2][3]... >
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   
		   // 실행 
		   ResultSet rs=ps.executeQuery();
		   // no,subject,name,regdate,hit
		   while(rs.next())
		   {
			   BoardVO vo=new BoardVO();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(2));
			   vo.setName(rs.getString(3));
			   vo.setRegdate(rs.getDate(4));
			   vo.setHit(rs.getInt(5));
			   list.add(vo);
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   // 에러 확인 => output
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 닫기 
		   disConnection();
	   }
	   return list;
   }
   // 1-1 총페이지 
   public int boardTotalPage()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT CEIL(COUNT(*)/10.0) FROM board";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
   // SELECT외에는 => 오라클 자체 처리 => 결과값이 없다 
   // 2. 글쓰기 => 시퀀스 사용법 => 매개변수는 특별한 경우외에는 3개이상 초과시는 반드시 배열 , 클래스 객체 
   /*
    *    memberInsert(String a,String b,String c,String d,String e,String f,String g,String h,String i)
    *                 --------------------------------------------------------------------------------
    *                   MemberVO vo
    */
   public void boardInsert(BoardVO vo)
   {
	   try
	   {
		   // 1. 연결 
		   getConnection();
		   // 2. SQL문장 
		   String sql="INSERT INTO board(name,subject,content,pwd) "
				     +"VALUES(board_no_seq.nextval,?,?,?,?)";
		   // 3. 전송 
		   ps=conn.prepareStatement(sql);
		   // 4. 실행요청 
		   // ?에 값을 채운다 
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setString(4, vo.getPwd());
		   
		   ps.executeUpdate();
		   /*
		    *   executeQuery() => 결과값이 있다 => SELECT  
		    *   executeUpdate() => 결과값이 없다 => commit() => INSERT/UPDATE/DELETE
		    */
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 3. 상세보기 => WHERE => 조회수 증가 / 데이터 읽기 
   // 4. 수정 => 비밀번호 체크 => 비밀번호 체크 / 실제 수정  => 묻고답하기 : SQL(5)
   // 5. 삭제 => 비밀번호 체크 => 비밀번호 체크 / 실제 삭제  => 묻고답하기 : SQL(7)
   // 기능 수행을 위해서는  SQL문장이 1개가 아닐 수 있다 => 여러개의 SQL문장을 사용할 수 있다 
}









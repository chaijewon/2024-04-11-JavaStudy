package com.sist.dao;
import java.util.*;
import java.sql.*;
/*
 *   1. JDBC (자바에서 데이터베이스 연결하는 라이브러리) => java.sql
 *      1) 드라이버 등록 
 *         Class.forName("드라이버 클래스") => 각 데이터베이스 업체 (오라클 , MySQL,MariaDB...)
 *         ------------- 클래스의 정보를 읽어서 메모리 할당 ,멤버변수 값 주입 , 메소드를 호출 ...
 *         ------------- ---------------- 리플렉션 (스프링 , 스프링부트 , MyBatis)
 *      2) 데이터베이스 연결 
 *         ------------
 *           Connection => Connection conn=DriverManager.getConnection(URL,username,password)
 *                         => conn username/password 
 *                         => URL
 *                            => jdbc:업체명:드라이버명:@IP:PORT:데이터베이스명 
 *                               jdbc:oracle:thin:@localhost:1521:XE
 *                                           ----- 연결만 해주는 역할 => 속도가 늦다 
 *                                          
 *      3) SQL문장을 오라클 전송 
 *           => SQL문장을 만든다 => String 
 *              String sql="SELECT~" , "INSERT" , "UPDATE" , "DELETE" => DML => 데이터 제어 
 *              => DDL => CREATE , ALTER , DROP , RENAME , TRUNCATE , GRANT , REVOKE 
 *                       ------------------------------------------------------------
 *                         | 오라클 자체에서 처리 
 *           PreparedStatement ps=conn.preparedStatement(sql)
 *      4) SQL문장 실행후에 결과값 받기 
 *         --------------------- SELECT
 *           INSERT/UPADTE/DELETE => executeUpdate() : commit()호출하고 있다 => 데이터 갱신 
 *           SELECT => executeQuery() => 실행된 결과값을 읽어 온다 
 *           
 *           ResultSet rs=ps.executeQuery()
 *                SELECT id,name,sex 
 *           ----------------------------------
 *            컬럼명   ID   NAME   SEX
 *           ----------------------------------
 *                 => rs.getString(1) rs.getString(2) rs.getString(3) => getInt() getDate() getDouble()
 *                 => rs.getString("id")  rs.getString("name") rs.getString("sex")
 *                 aaa    홍길동   남자  ==========> next()
 *           ----------------------------------    |
 *                 bbb    심청이   여자 
 *           ----------------------------------    |
 *                 ccc    춘향이   여자  ==========> previous()
 *           ----------------------------------
 *             => JDBC => SQL관련 (오라클 문법 적용) => 번호가 1번부터 ...
 *      5) 닫기 
 *         rs.close()
 *         ps.close()
 *         conn.close() 
 *         ---------------------------------------------------
 *         1. Connection => 반드시 닫기 수행 (닫기가 안되면 Connection은 사용하지 않는데 오라클 연결..)
 *                                      ---------------------------------------------> DDOS 
 *         2. 사용자가 Connection을 한개만 사용할 수 있게 만든다 : 싱글턴 
 *         
 *         3. JDBC => 웹(DBCP) => 라이브러리 등장 (MyBatis / Hibernate)
 *                                            | 실무     | 자동으로 SQL문장 만들어주는 라이브러리 
 *                                                        --------------------------- JPA 
 *                     | Connection을 미리 연결 
 *            | 연결시마다 => Connection생성 
 *      => 주의점 : 문자열로 되어 있다 
 *                -------------> 컴파일시에 에러가 없다 => 실행시 에러발생 
 *                String sql="SELECT"; => 공백 , 오라클 SQL 문장과 약간 다른 것이 있다 (LIKE)
 *                1) SQL => 먼저는 오라클에서 실행 => 자바에서 전송 
 *                          ---------------
 *                2) 웹 => SQL (85%) 
 *                  ---------------- 
 *                  
 *      => 인라인뷰 : 페이지 나누기 
 *      => 총페이지 
 *      => 검색 
 *      => SELECT 
 *      ---------------------- 내일 : CRUD ... 
 *                             오픈 API => 네이버 연결 
 *                             
 */
public class GoodsDAO {
	 // 오라클 연결 
     private Connection conn;
     // SQL문장 송수신 
     private PreparedStatement ps;
     // 오라클 주소 저장 => 변경 (X) => 상수 
     private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
     
     // 싱글턴 => 메모리 누수 현상 방지 => 객체를 한번만 생성 => DAO 
     private static GoodsDAO dao;
     // 1. 드라이버 등록 : 한번만 수행 (생성자) => 멤버변수의 초기화 
     public GoodsDAO()
     {
    	 try
    	 {
    		 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 }catch(Exception ex) {}
     }
     // 2. 오라클 연결 => SQL문장 => 재사용 
     public void getConnection()
     {
    	 try
    	 {
    		 conn=DriverManager.getConnection(URL,"hr","happy"); 
    	 }catch(Exception ex) {}
     }
     // 3. 오라클 해제
     public void disConnection()
     {
    	 try
    	 {
    		 if(ps!=null) ps.close();
    		 if(conn!=null) conn.close();
    	 }catch(Exception ex) {}
     }
     // 4. 싱글턴 => static은 메모리 공간 1개만 가지고 있다 
     public static GoodsDAO newInstance()
     {
    	 if(dao==null)
    		 dao=new GoodsDAO();
    	 return dao;
     }
     ////////////////////////////////////////// DAO의 필수 공통 코드 
     // 기능 
     // 총페이지 구하기 
     public int goodsTotalPage()
     {
    	 int total=0;
    	 try
    	 {
    		 // 1. 연결 
    		 getConnection();
    		 // 2. SQL문장 
    		 String sql="SELECT CEIL(COUNT(*)/12.0) FROM goods_all";
    		 // 3. 오라클로 전송 
    		 ps=conn.prepareStatement(sql);
    		 // 4. SQL문장 실행 결과를 가지고 온다 => 실행 결과를 저장 (ResultSet)
    		 ResultSet rs=ps.executeQuery();
    		 // 5. 커서위치를 데이터에 출력된 첫번째 위치로 이동 
    		 rs.next();
    		 total=rs.getInt(1);
    		 // 6. 메모리를 닫는다 
    		 rs.close();
    		 // 쉬운 프로그램은 모든 개발자가 동일한 코딩 (표준화) => 패턴이 한개 
    		 // --------- 라이브러리 (MyBatis) => Spring 
    		 
    		 
    	 }catch(Exception ex)
    	 {
    		 // 에러 확인 => 복구(X)
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 // 닫기 
    		 disConnection();
    	 }
    	 return total;
     }
     // 목록 => 페이지 (인라인뷰)
     //    기능설정 => 리턴형 => 사용자로부터 어떤 값을 받는지 (매개변수)
     /*
      *                 파이썬/C#/C/C++/코틀린
      *    브라우저   ========  자바  ======== 오라클 
      *                                    => 사이트,윈도우에 필요한 데이터가 저장 
      *                       |
      *                  브라우저/오라클 연결 
      *     |
      *    HTML / CSS / JavaScript => 브라우저에서 실행이 가능한 언어 (HTML,XML)
      *                 ----------    ------ 자바소스는 일반 텍스트 
      *                  Ajax / VueJS / ReactJS
      *    파이썬 => 장고 
      *           ----- 
      *    C# => ASP.net 
      *    자바,코틀린 => 스프링 
      */
     public ArrayList<GoodsVO> goodsListData(int page)
     {
    	 ArrayList<GoodsVO> list=new ArrayList<GoodsVO>();
    	 // VO는 상품 한개에 대한 모든 정보가 저장 
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,goods_name,goods_poster,num "
    				   +"FROM (SELECT no,goods_name,goods_poster,rownum as num "
    				   +"FROM (SELECT no,goods_name,goods_poster "
    				   +"FROM goods_all ORDER BY no ASC)) "
    				   +"WHERE num BETWEEN ? AND ?";
    		 // 오라클 페이지 나누기 => 인라인뷰 => 가상 컬럼 : rownum (자르기)
    		 // rownum은 Top-N => 처음부터 몇개 => 중간이 다르는 것은 불가능 
    		 // ?에 값을 채운다 
    		 int rowSize=12;
    		 int start=(rowSize*page)-(rowSize-1);
    		 //           12*1 - 11 -> 1 ==> 12*2 - 11 => 13
    		 int end=rowSize*page;// 12 ==> 24
    		 // 1번부터 (rownum=>1번) 
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, start);
    		 ps.setInt(2, end);
    		 
    		 // 실행 요청 
    		 ResultSet rs=ps.executeQuery();
    		 // 첫번째부터 읽기 
    		 while(rs.next())
    		 {
    			 GoodsVO vo=new GoodsVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setGoods_name(rs.getString(2));
    			 vo.setGoods_poster(rs.getString(3));
    			 list.add(vo);
    		 }
    		 
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return list;
     }
     // 상세보기 => 한개에 대한 정보 
     /*
      * NO                                                 NUMBER(38)
		 GOODS_NAME                                         VARCHAR2(4000)
		 GOODS_SUB                                          VARCHAR2(4000)
		 GOODS_PRICE                                        VARCHAR2(26)
		 GOODS_DISCOUNT                                     NUMBER(38)
		 GOODS_FIRST_PRICE                                  VARCHAR2(26)
		 GOODS_DELIVERY                                     VARCHAR2(26)
		 GOODS_POSTER 
      */
     public GoodsVO goodsDetailData(int no)
     {
    	 GoodsVO vo=new GoodsVO();
    	 try
    	 {
    		 getConnection();
    		 // 조회수 증가 
    		 String sql="UPDATE goods_all SET "
    				   +"hit=hit+1 "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, no);
    		 ps.executeUpdate(); // commit()
    		 
    		 // 데이터 읽기
    		 sql="SELECT no,goods_name,goods_sub,goods_price,goods_discount,"
    		    +"goods_first_price,goods_delivery,goods_poster "
    			+"FROM goods_all "
    		    +"WHERE no=?";
    		 
    		 ps=conn.prepareStatement(sql);
    		 // ?에 값을 채운다 
    		 ps.setInt(1, no);
    		 
    		 // 결과값 
    		 ResultSet rs=ps.executeQuery();
    		 rs.next();
    		 // 값을 VO에 저장 
    		 vo.setNo(rs.getInt(1));
    		 vo.setGoods_name(rs.getString(2));
    		 vo.setGoods_sub(rs.getString(3));
    		 vo.setGoods_price(rs.getString(4));
    		 vo.setGoods_discount(rs.getInt(5));
    		 vo.setGoods_first_price(rs.getString(6));
    		 vo.setGoods_delivery(rs.getString(7));
    		 vo.setGoods_poster(rs.getString(8));
    		 rs.close();
    		 
    		 
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return vo;
     }
     // 검색 => LIKE 
     public ArrayList<GoodsVO> goodsFindData(String name)
     {
    	 ArrayList<GoodsVO> list=new ArrayList<GoodsVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,goods_name,goods_poster,goods_price "
    				   +"FROM goods_all "
    				   +"WHERE goods_name LIKE '%'||?||'%' "
    				   +"ORDER BY no ASC";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, name);
    		 
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 GoodsVO vo=new GoodsVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setGoods_name(rs.getString(2));
    			 vo.setGoods_poster(rs.getString(3));
    			 vo.setGoods_price(rs.getString(4));
    			 
    			 list.add(vo);
    		 }
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return list;
     }
     // 구매 => INSERT , UPDATE , DELETE 
     
}










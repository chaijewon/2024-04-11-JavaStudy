package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private static MemberDAO dao; // 싱글턴 
   
   // 1. 드라이버 등록 
   public MemberDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   // 2. 오라클 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // conn hr/happy
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
   // 4. 싱글턴 => 한사람당 한개의 DAO만 사용할수 있게 만든다 => 메모리 누수현상을 제거 
   public static MemberDAO newInstance()
   {
	   if(dao==null)
		   dao=new MemberDAO();
	   return dao;// null이 아니면 기존에 저장된 dao를 전송 
   }
   ////////////////////////////// 모든 DAO에 공통 사항 
   // 기능 
   // 1. 로그인 처리 
   /*
    *   리턴형 => 경우의 수 
    *   = 사번이 없는 경우  => 0 => NOSABUN 
    *   = 사번은 존재 이름이 틀린경우 => 1 NONAME
    *   = 사번은 존재 , 이름도 동일 => 2 OK
    *   ------------------------ String / int 
    */
   public String memberLogin(int empno,String ename)
   {
	   String result="";
	   try
	   {
		   // 1. 연결 
		   getConnection();
		   // 2. SQL문장 
		   String sql="SELECT COUNT(*) FROM emp "
				     +"WHERE empno="+empno; // 사번이 존재하는지 확인 => 0/1
		   // 3. 오라클로 SQL문장 전송 
		   ps=conn.prepareStatement(sql);
		   // 4. 결과값을 받는다 
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   int count=rs.getInt(1); // 0,1
		   rs.close();
		   if(count==0) // 사번이 없는 경우 
		   {
			   result="NOSABUN";
		   }
		   else // 사번이 있는 경우 
		   {
			   sql="SELECT ename FROM emp "
				  +"WHERE empno="+empno;
			   // 오라클로 전송 
			   ps=conn.prepareStatement(sql);
			   // 결과값 받기 
			   rs=ps.executeQuery();
			   rs.next();
			   String db_ename=rs.getString(1);
			   rs.close();
			   
			   if(db_ename.equals(ename))// 로그인 
			   {
				   result="OK";
			   }
			   else // 이름이 없는 상태 
			   {
				   result="NONAME";
			   }
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();// 오류 확인 => null , SQL문장 
	   }
	   finally
	   {
		   // 오라클 해제 
		   disConnection();
	   }
	   return result;
   }
   // 2. 회원가입 => 아이디 중복 체크 / 우편번호 검색 
   // 3. 회원수정
   // 4. 회원탈퇴 
   // => SQL문장 제작 => 웹도 가능 => DAO변경이 없다 
   
   
}

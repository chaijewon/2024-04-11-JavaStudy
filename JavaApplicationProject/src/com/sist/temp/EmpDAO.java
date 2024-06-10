package com.sist.temp;
import java.util.*;
import java.sql.*;
public class EmpDAO {
    // 오라클 연결 
	private Connection conn;
	// 오라클에 SQL문장 전송 
	private PreparedStatement ps;
	/*
	 *             매개변수       SQL문장 제작 
	 *    사용자 요청 ======> 자바 =========> 오라클 
	 *                                     |
	 *                                   SQL문장 실행
	 *        <========== 결과값 저장<==========
	 *      | 데이터 출력  (윈도우 , 브라우저)
	 *                  ---------------- VO,DAO 변경이 없다        
	 */
	// 자바 12장 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 싱글턴 => 한개의 객체가 사용이 가능 => 오라클 연동
	private static EmpDAO dao;
	/*
	 *    thin : 연결만 하는 역할 => 무료
	 *    oci :  oracle client => 유료 
	 */
	// 1. 드라이버 등록 (한번만 등록)
	public EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Dbeaver , sqldeveloper
		}catch(Exception ex) {}
	}
	// 2. 싱글턴 패턴 => 메모리 공간을 한개만 사용 => static
	public static EmpDAO newInstance()
	{
		if(dao==null)
			dao=new EmpDAO();// 생성이 안된 경우
		return dao;// 이미 생성된 dao를 사용한다 
	}
	// 3. 오라클 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// conn hr/happy => 오라클 명령 
		}catch(Exception ex){}
	}
	// 4. 오라클 닫기 
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			// 송수신 => 닫고 
			if(conn!=null) conn.close();
			
			// exit
		}catch(Exception ex) {}
	}
    // 5. 오라클에 요청 
	public ArrayList<EmpVO> empListData()
	{
		ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		try
		{
			// 1. 연결 
			getConnection();
			// 2. SQL문장 만들기
			String sql="SELECT empno,ename,job,sal,deptno FROM emp";
			// 3. 오라클로 전송 
			ps=conn.prepareStatement(sql);
			// 4. 오라클에서 실행된 결과를 가지고 온다 
			ResultSet rs=ps.executeQuery(); // enter 
			// 실행된 모든 데이터는 rs에 존재
            /*
             *    rs
       1    2                    3                         4        5
     EMPNO ENAME                JOB                       SAL     DEPTNO
---------- -------------------- ------------------ ---------- ----------
      7839 KING                 PRESIDENT                5000         10 : cursor => next()
      ---- -----
       int  String              String                   int          int 
      7698 BLAKE                MANAGER                  2850         30
      7782 CLARK                MANAGER                  2450         10
      7566 JONES                MANAGER                  2975         20
      7654 MARTIN               SALESMAN                 1250         30
      7499 ALLEN                SALESMAN                 1600         30
      7844 TURNER               SALESMAN                 1500         30
      7900 JAMES                CLERK                     950         30
      7521 WARD                 SALESMAN                 1250         30
      7902 FORD                 ANALYST                  3000         20
      7369 SMITH                CLERK                     800         20
      7788 SCOTT                ANALYST                  3000         20
      7876 ADAMS                CLERK                    1100         20
      7934 MILLER               CLERK                    1300         10 : cursor => previous()
             */
			// ===> list에 첨부 
			while(rs.next())
			{
				// double => rs.getDouble(번호)
				// date   => rs.getDate(번호)
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setDeptno(rs.getInt(5));
				list.add(vo);
			}
			
			rs.close(); // 메모리 해제 
		}catch(Exception ex)
		{
			// 에러 확인 
			ex.printStackTrace();
		}
		finally
		{
			// 오라클 닫기 
			disConnection();
		}
		return list;
	}
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo=new EmpVO(); // 사원 한명에 대한 정보
		try
		{
			// 1. 오라클 연결 
			getConnection(); // 반복 제거 
			/*
			 *    메소드 : 전송 
			 *    ----- 브라우저/윈도우에서는 사용이 불가능 
			 *    => 리턴형 / 매개변수 
			 *       ----
			 *       1. 목록 => ArrayList
			 *       2. 맛집 한개 정보 => FoodVO ==> 구분자 (맛집 번호) 
			 *       3. 검색 => ArrayList
			 *       
			 */
			// 2. SQL문장 
			String sql="SELECT empno,ename,job,sal,deptno FROM emp WHERE empno="+empno;
			// 3. 오라클 전송 
			ps=conn.prepareStatement(sql);
			// 4. 실행 결과 
			ResultSet rs=ps.executeQuery();
			// 5. EmpVO => 값을 채운다 
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setSal(rs.getInt(4));
			vo.setDeptno(rs.getInt(5));
			rs.close();
			
		}catch(Exception ex)
		{
			// 에러 확인 
			ex.printStackTrace();
		}
		finally
		{
			// 오라클 닫기 
			disConnection();
		}
		return vo;
	}
	public ArrayList<EmpVO> empFind(String ename)
	{
		ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		try
		{
			// 연결 
			getConnection();
			
			String sql="SELECT empno,ename,job,sal,deptno FROM emp WHERE ename LIKE '%"+ename.toUpperCase()+"%'";
			
			ps=conn.prepareStatement(sql);
		    // 4. 오라클에서 실행된 결과를 가지고 온다 
			ResultSet rs=ps.executeQuery(); // enter 
			while(rs.next())
			{
				// double => rs.getDouble(번호)
				// date   => rs.getDate(번호)
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setDeptno(rs.getInt(5));
				list.add(vo);
			}
			
			rs.close(); // 메모리 해제 
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
	// 문제 => 우편번호 검색 
	/*
	 *    VO => desc 테이블명
	 *    메소드 제작 
	 *    MainClass=> 동을 입력 => 출력 
	 */
	public ArrayList<ZipcodeVO> postFind(String dong)
	{
		ArrayList<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try
		{
			// 연결 
			getConnection();
			
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					  +"FROM zipcode "
					  +"WHERE dong LIKE '%"+dong+"%'";
			
			ps=conn.prepareStatement(sql);
		    // 4. 오라클에서 실행된 결과를 가지고 온다 
			ResultSet rs=ps.executeQuery(); // enter 
			while(rs.next())
			{
				// double => rs.getDouble(번호)
				// date   => rs.getDate(번호)
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
			
			rs.close(); // 메모리 해제 
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
}






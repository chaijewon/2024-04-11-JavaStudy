package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 회원가입 
		/*Scanner scan=new Scanner(System.in);
		System.out.print("ID 입력:");
		String id=scan.next();
		
		System.out.print("비밀번호 입력:");
		String pwd=scan.next();
		
		System.out.print("이름 입력:");
		String name=scan.next();
		
		System.out.print("성별 입력(남자/여자):");
		String sex=scan.next();
		
		System.out.print("나이 입력:");
		int age=scan.nextInt();
		
		System.out.print("전화 입력:");
		String tel=scan.next();
		
		System.out.print("주소 입력:");
		String addr=scan.next();
		
		// 오라클 전송 
		String sql="INSERT INTO member VALUES('"
				   +id+"','"+pwd+"','"+name
				   +"','"+sex+"',"+age+",'"+tel
				   +"','"+addr+"')";
		System.out.println(sql);
		
		sql="INSERT INTO member VALUES(''{0}'',''{1}'',''{2}'',''{3}'',{4},''{5}'',''{6}'')";
		Object[] obj= {id,pwd,name,sex,age,tel,addr};
		System.out.println(MessageFormat.format(sql, obj));*/
		// sql="INSERT INTO member VALUES(?,?,?,?,?,?)"
		// => 오라클 => 저장 => 출력 형식을 만들어서 처리 => MessageFormat
		/*
		 *   ***날짜 => SimpleDateFormat 
		 *   ***정수 => DecimalFormat 
		 *   출력 => MessageFormat
		 *   
		 *   => util 
		 *      = Random 
		 *      = StringTokenizer => 네트워크 (채팅) 
		 *        --------------- 갯수가 적은 것은 상관없다 , 많은 경우에 문제 발생 
		 */
		String s="admin|1234|홍길동"; // hasMoreTokens()
		StringTokenizer st=new StringTokenizer(s,"|");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		//System.out.println(st.nextToken());
		
	}

}

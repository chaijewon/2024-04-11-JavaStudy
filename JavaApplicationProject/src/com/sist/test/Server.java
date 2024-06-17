package com.sist.test;
import java.util.*;
import java.io.*;
import java.net.*;

import com.sist.commons.Function;
import com.sist.dao.*; 
public class Server implements Runnable{
    // 접속 담당 
	private ServerSocket ss;
	// PORT => 0~65535 => 0~1023 
	private final int PORT=3355;
	private MemberDAO dao;
	// 저장 공간 (접속자)
	private Vector<Client>  waitVc=new Vector<Client>();
	public Server()
	{
		// 시작과 동시에 서버구동 
		try
		{
			ss=new ServerSocket(PORT);
			dao=MemberDAO.newInstance();// 데이터베이스 
			System.out.println("Server Start...");
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
	}
	// 접속시에 접속자 정보 저장 => 접속자마다 통신이 따로 수행 => 쓰레드 
	public void run()
	{
		// 접속시에 처리 
		while(true)
		{
			try
			{
				Socket s=ss.accept();
				// 접속이 된 경우에만 호출 
				// s => 클라이언트 정보 => 발신자 정보 => IP,PORT
				Client client=new Client(s);
				// 통신을 시작 
				client.start();
			}catch(Exception ex) {}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();// run() 호출 
	}
	/*
	 *   클래스의 종류 
	 *     = 추상 클래스 
	 *     ***= 보완 => 인터페이스 
	 *     = 내부 클래스 
	 *       --------- 클래스 메모리 할당없이 모든 변수/메소드에 접근 가능 
	 *       1) 멤버클래스 : 네트워크 , 쓰레드 ...
	 *          class A
	 *          {
	 *             데이터 
	 *             class B
	 *             {
	 *                A가 가지고 있는 모든 데이터를 공유 
	 *             }
	 *          }
	 *       2) 익명의 클래스 : 스프링 , 데이터 분석 
	 *          => 상속이 없이 오버라이딩이 가능 => 생성자에서 메소드 변경 , 메소드 추가 
	 */
	// 통신 
	class Client extends Thread
	{
		Socket s; // 클라이언트와 통신하는 통신 기기 
		OutputStream out; // 클라이언트에게 전송 
		BufferedReader in; // 클라이언트로부터 요청값 받기 
		// 개인 정보 
		String id,name,sex,pos,admin;
		public Client(Socket s)
		{
			// 변수 초기화 
			try
			{
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				//  네트워크 전송 => 1byte로 전송 
				// 값을 받는 경우는 => 2byte로 받는다 
				// 1->2로 변경해서 받는 클래스 : 필터 스트림 
				// InputStreamReader 
			}catch(Exception ex) {}
			
		}
		// 통신을 시작한다 
		public void run() // 클라이언트마다 따로 동작 => 쓰레드 
		{
			while(true)
			{
				try
				{
					// 클라이언트의 요청값을 받는다 
					String msg=in.readLine();
					StringTokenizer st=new StringTokenizer(msg,"|");
					// 100|id
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
					  // 로그인 요청 
					  case Function.LOGIN:
					  {
						  // ID를 받는다 
						  id=st.nextToken();
						  // 정보 
						  MemberVO vo=dao.memberInfo(id);
						  name=vo.getName();
						  sex=vo.getSex();
						  pos="대기실";
						  admin=vo.getAdmin();
						  
						  // 이미 접속된 회원에게 지금 접속한 회원의 정보 전송
						  messageAll(Function.LOGIN+"|"+
						    id+"|"+name+"|"+sex+"|"+pos+"|"+admin);
						  messageAll(Function.CHAT+"|[☞ 알림]"+name+"님이 입장하셨습니다");
						  // 서버에 저장 
						  waitVc.add(this);
						  
						  //1. 창 갱신 
						  messageTo(Function.MYLOG+"|"+id+"|"+name);//Login=>WaitRoom
						  //2. 이미 접속된 회원의 모든 정보를 받는다 
						  for(Client client:waitVc)
						  {
							  messageTo(Function.LOGIN+"|"
									  +client.id+"|"
									  +client.name+"|"
									  +client.sex+"|"
									  +client.pos+"|"
									  +client.admin);
						  }
						  // 3. 개설된 방정보 
						  
					  }
					  break;
					  // 나가기 요청
					  /*
					   *    로그인 
					   *    -----
					   *      로그인 하는 사람 => MYLOG
					   *      로그인된 사람 => LOGIN
					   *    나가기 
					   *    -----
					   *      남아 있는 사람 => EXIT
					   *      실제 나가는 사람 => MYEXIT
					   *      
					   *   Client / Server (웹)
					   *     |       |
					   *   Slave    Master 
					   *   
					   *   Server => Client에 지시를 내린다 
					   *   Client => Server에서 지시를 받아서 동작 
					   */
					  case Function.EXIT: // exit.jsp 
					  {
						  messageAll(Function.EXIT+"|"+id);// 테이블에서 제거 
						  messageAll(Function.CHAT+"|[☞ 알림]"+name+"님이 퇴장하셨습니다");
						  // 남아 있는 사람 처리 
						  
						  // 실제 나가는 사람 처리 
						  for(Client client:waitVc)
						  {
							  if(client.id.equals(id))
							  {
								  messageTo(Function.MYEXIT+"|"); // 윈도우창 종료 
								  waitVc.remove(client);
								  in.close();
								  out.close();
							  }
						  }
						  
					  }
					  break;
					  // 채팅 요청 
					  case Function.CHAT:
					  {
						  String message=st.nextToken();
						  messageAll(Function.CHAT+"|["
								  +name+"]"+message);
					  }
					  break;
					  /*
					   *   클라이언트 : 요청 / 응답 출력  
					   *            ---- <a> , <input type=button> , <form> 
					   *            ---- html / css 
					   *   --------------------
					   *   서버 : 요청받기  => 자바 라이브러리 (HttpServletRequest)
					   *         응답하기 => HttpServletResponse 
					   *         ------------
					   *         저장하기
					   *         수정기능
					   *         삭제기능 
					   *         찾기기능 
					   *         ------------ JDBC (오라클 연동) 
					   *   --------------------- 
					   */
					  case Function.INFO:
					  {
						  String yid=st.nextToken();
						  MemberVO vo=dao.memberInfo2(yid);
						  messageTo(Function.INFO+"|"
								   +vo.getName()+"|"
								   +vo.getSex()+"|"
								   +vo.getAddr1()+"|"
								   +vo.getEmail()+"|"
								   +vo.getPhone()+"|"
								   +vo.getContent());
					  }
					  break;
					  
					}
					
				}catch(Exception ex){}
			}
		}
		// 접속자 전체로 전송
		public synchronized void messageAll(String msg)
		{
			// synchronized => 동기화
			try
		    {
					for(Client client:waitVc)
					{
						client.messageTo(msg);
					}
			}catch(Exception ex) {}
			
			
		}
		// 접속자에게만 전송 
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex) {}
		}
	}

}

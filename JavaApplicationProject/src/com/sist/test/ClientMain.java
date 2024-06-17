package com.sist.test;
import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
import com.sist.commons.*;
public class ClientMain extends JFrame implements ActionListener,Runnable{
    CardLayout card=new CardLayout();
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    MemberDAO dao;
    // 네트워크 관련 
    Socket s; // 통신기기 
    // 서버로 전송 
    OutputStream out; // 이벤트 발생시 처리 => 버튼 , 마우스 클릭 ... 
    // 서버에서 값 읽기
    BufferedReader in; // 자동화 처리 => 쓰레드 
    public ClientMain()
    {
    	dao=MemberDAO.newInstance();
    	setLayout(card);
    	add("LOGIN",login);
    	add("WR",wr);
    	setSize(800, 600);
    	setVisible(true);
    	
    	login.b1.addActionListener(this);
    	login.b2.addActionListener(this);
    	
    	wr.tf.addActionListener(this);//enter
    	wr.b6.addActionListener(this);//나가기 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b2)
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==login.b1)
		{
			String id=login.tf.getText();
			if(id.length()<1)
			{
				login.tf.requestFocus();
				return;
			}
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.length()<1)
			{
				login.pf.requestFocus();
				return;
			}
			
			String result=dao.memberLogin(id, pwd);
			if(result.equals("NOID"))
			{
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}
			else if(result.equals("NOPWD"))
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();
			}
			else
			{
				// 서버와 연결 
				try
				{
					s=new Socket("localhost",3355);
					in=new BufferedReader(new InputStreamReader(s.getInputStream()));
					out=s.getOutputStream();
					//  서버와 연결 완료 
					// 서버로 로그인 요청 
					out.write((Function.LOGIN+"|"+id+"\n").getBytes());
					//out.write((Function.LOGIN+"|hong\n").getBytes());
				}catch(Exception ex) {}
				// 서버로부터 응답값을 받아서 처리 
				new Thread(this).start();
			}
		}
		else if(e.getSource()==wr.tf)// 대기실 채팅 
		{
			//1. 입력값 가지고 오기 
			String msg=wr.tf.getText();
			if(msg.length()<1)
				return;
			
			// 2. 입력값 전송 
			try
			{
				out.write((Function.CHAT+"|"+msg+"\n").getBytes()); // out 서버와 연결 
			}catch(Exception ex){}
			wr.tf.setText("");
			wr.tf.requestFocus();
		}
		else if(e.getSource()==wr.b6)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex){}
		}
	}
	// client(요청) => server(응답) => client(응답 출력)
	// 이벤트 발생 => 클릭 / 엔터 ... 
	// 서버의 응답값을 처리 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{
				// 서버의 응답값을 받는다 
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				   case Function.LOGIN:
				   {
					   String[] data= {
							   st.nextToken(),
							   st.nextToken(),
							   st.nextToken(),
							   st.nextToken(),
							   st.nextToken()
					   };
					   wr.model2.addRow(data);
				   }
				   break;
				   case Function.MYLOG:
				   {
					   String id=st.nextToken();
					   String name=st.nextToken();
					   setTitle(name+"님의 채팅창");
					   card.show(getContentPane(), "WR");// 대기실창 이동 
				   }
				   break;
				   case Function.CHAT:
				   {
					   wr.ta.append(st.nextToken()+"\n");
					   wr.bar.setValue(wr.bar.getMaximum());
				   }
				   case Function.EXIT:
				   {
					   String mid=st.nextToken();
					   for(int i=0;i<wr.model2.getRowCount();i++)
					   {
						   String ids=wr.model2.getValueAt(i, 0).toString();
						   if(mid.equals(ids))
						   {
							   wr.model2.removeRow(i);
							   break;
						   }
					   }
					   
				   }
				   break;
				   case Function.MYEXIT:
				   {
					   dispose();
					   System.exit(0);
				   }
				   break;
				}
			}catch(Exception ex) {}
		}
	}

}

package com.sist.client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import com.sist.dao.*;

public class ClientMain extends JFrame implements ActionListener,MouseListener{
    CardLayout card=new CardLayout();
    LoginPanel lp=new LoginPanel();
    MainPanel mp=new MainPanel();
    JoinPanel jp=new JoinPanel();
    PostFindFrame post=new PostFindFrame();// 우편번호 검색 
    IdCheckFrame idfrm=new IdCheckFrame();
    public ClientMain()
    {
    	setLayout(card);
    	
    	add("LOGIN",lp);
    	add("MP",mp);
    	add("JP",jp);
    	setSize(960, 700);
    	setResizable(false);
    	setVisible(true);
    	
    	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    	//setDefaultCloseOperation(EXIT_ON_CLOSE);
    	lp.loginBtn.addActionListener(this);// 로그인 
    	lp.joinBtn.addActionListener(this);// 회원가입 
    	lp.cancelBtn.addActionListener(this);// 종료
    	
    	jp.b1.addActionListener(this); // 아이디 중복체크 버튼 
    	jp.b4.addActionListener(this);// 취소
    	jp.b2.addActionListener(this);// 우편번호 검색 
    	jp.b3.addActionListener(this);
    	
    	post.b1.addActionListener(this);// 우편 검색 버튼 
    	post.b2.addActionListener(this);// 취소 
    	post.tf.addActionListener(this);// 우편번호 입력창 
    	
    	post.table.addMouseListener(this);
    	
    	idfrm.b1.addActionListener(this);// 아이디 체크
    	idfrm.b2.addActionListener(this);// 확인 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
        new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lp.cancelBtn)
		{
			dispose();// window메모리 해제 
			System.exit(0);// 프로그램 종료
		}
		else if(e.getSource()==jp.b1)// 아이디 중복 체크 
		{
			idfrm.tf.setText("");
			idfrm.b2.setVisible(false);
			idfrm.la3.setText("");
			idfrm.setVisible(true);
		}
		else if(e.getSource()==jp.b3)
		{
			String id=jp.idtf.getText();
			if(id.length()<1)
			{
				jp.idtf.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(jp.pf.getPassword());
			if(pwd.length()<1)
			{
				jp.pf.requestFocus();
				return;
			}
			
			String name=jp.nametf.getText();
			if(name.length()<1)
			{
				jp.nametf.requestFocus();
				return;
			}
			
			String sex="";
			if(jp.rb1.isSelected())
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			
			String birthday=jp.birthtf.getText();
			if(birthday.length()<1)
			{
				jp.birthtf.requestFocus();
				return;
			}
			
			String post=jp.posttf.getText();
			if(post.length()<1)
			{
				jp.posttf.requestFocus();
				return;
			}
			
			String addr1=jp.addrtf1.getText();
			if(addr1.length()<1)
			{
				jp.addrtf1.requestFocus();
				return;
			}
			
			String phone1=jp.box.getSelectedItem().toString();
			String phone2=jp.teltf.getText();
			if(phone2.length()<1)
			{
				jp.teltf.requestFocus();
				return;
			}
			String phone=phone1+")"+phone2;
			String email=jp.emailtf.getText();
			if(email.length()<1)
			{
				jp.emailtf.requestFocus();
				return;
			}
			
			String addr2=jp.addrtf2.getText();
			String content=jp.cta.getText();
			// phone => NOT NULL => 반드시 입력...
			MemberVO vo=new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setSex(sex);
			vo.setBirthday(birthday);
			vo.setPost(post);
			vo.setAddr1(addr1);
			vo.setAddr2(addr2);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setContent(content);
			
			MemberDAO dao=MemberDAO.newInstance();
			String res=dao.memberInsert(vo);
			
			if(res.equals("yes"))
			{
				JOptionPane.showMessageDialog(this, "회원 가입에 축하합니다");
				card.show(getContentPane(), "LOGIN");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "회원 가입에 실패하셨습니다\n"+res);
			}
		}
		else if(e.getSource()==idfrm.b1)
		{
			String id=idfrm.tf.getText(); 
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");// alert()
				idfrm.tf.requestFocus();// tf.focus()
				return;
			}
			// 입력된 상태 
			// 오라클 연결 
			MemberDAO dao=MemberDAO.newInstance();
			int count=dao.memberIdCheck(id);
			
			if(count==0)
			{
				idfrm.la3.setText(id+"는(은) 사용 가능한 아이디입니다");
				idfrm.b2.setVisible(true);
			}
			else
			{
				idfrm.la3.setText(id+"는(은) 이미 사용중인 아이디입니다");
				idfrm.b2.setVisible(false);
				idfrm.tf.setText("");
				idfrm.tf.requestFocus();
			}
		}
		else if(e.getSource()==idfrm.b2)
		{
			String id=idfrm.tf.getText();
			jp.idtf.setText(id);
			idfrm.setVisible(false);
		}
		else if(e.getSource()==post.b2)
		{
			post.setVisible(false);
		}
		else if(e.getSource()==post.b1 || e.getSource()==post.tf)
		{
			String dong=post.tf.getText();
			if(dong.length()<1)// 입력이 안된 경우
			{
				JOptionPane.showMessageDialog(this, "동/읍/면을 입력하세요");
				post.tf.requestFocus();
				return;
			}
			MemberDAO dao=MemberDAO.newInstance();
			ArrayList<ZipcodeVO> list=dao.postFindData(dong);
			if(list.size()==0)
			{
				JOptionPane.showMessageDialog(this, "검색된 결과가 없습니다");
				post.tf.setText("");
				post.tf.requestFocus();
			}
			else
			{
				for(int i=post.model.getRowCount()-1;i>=0;i--)
				{
					post.model.removeRow(i);
				}
				
				for(ZipcodeVO vo:list)
				{
					String[] data={vo.getZipcode(),vo.getAddress()};
					post.model.addRow(data);
				}
			}
		}
		else if(e.getSource()==jp.b2)
		{
			for(int i=post.model.getRowCount()-1;i>=0;i--)
			{
				post.model.removeRow(i);
			}
			post.tf.setText("");
			post.setVisible(true);
		}
		else if(e.getSource()==jp.b4)
		{
			card.show(getContentPane(), "LOGIN");
		}
		else if(e.getSource()==lp.joinBtn)
		{
			card.show(getContentPane(), "JP");
		}
		else if(e.getSource()==lp.loginBtn)
		{
			//1. 입력한 사번 / 이름을 가지고 온다 
			try
			{
				// 유효성 검색 => 오라클 
				String id=lp.tf.getText();
				if(id.length()<1)
				{
					JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
					lp.tf.requestFocus();
					return;
				}
				String pwd=String.valueOf(lp.pf.getPassword());
				if(pwd.length()<1)
				{
					JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
					lp.pf.requestFocus();
					return;
				}
				
				// 오라클 연결 
				MemberDAO dao=MemberDAO.newInstance();
				String result=dao.memberLogin(id, pwd);
				// 웹 => 자바스크립트로 처리 
				if(result.equals("NOID"))
				{
					// 사번이 없는 경우 
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
					lp.tf.setText("");
					lp.pf.setText("");
					lp.tf.requestFocus();
				}
				else if(result.equals("NOPWD"))
				{
					// 이름이 틀린 경우
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
					lp.pf.setText("");
					lp.pf.requestFocus();
				}
				else
				{
					// 로그인 
					System.out.println("로그인 완료");
					card.show(getContentPane(),"MP"); // 화면 변경 
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "사번은 정수여야 합니다..");
				return; // 메소드 종료 
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==post.table)
		{
			if(e.getClickCount()==2)
			{
			int row=post.table.getSelectedRow();
			String zip=post.model.getValueAt(row, 0).toString();
			String addr=post.model.getValueAt(row, 1).toString();
			
			jp.posttf.setText(zip);
			jp.addrtf1.setText(addr);
			
			post.setVisible(false);
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package com.sist.user;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import com.sist.model.*;
import java.util.*;
public class BoardMain extends JFrame implements ActionListener{
    private CardLayout card=new CardLayout();
    BoardList bList=new BoardList();
    BoardInsert bInsert=new BoardInsert();
    // 클래스 => 관련있는 클래스별로 선언 
    // 프로그램에 필요한 변수 설정 
    int curpage=1;
    int totalpage=0;
    
    BoardSystem bs=new BoardSystem(); // 파일에 List 저장됨 
    public BoardMain()
    {
    	setLayout(card);
    	add("LIST",bList);
    	add("INSERT",bInsert);
    	setTitle("게시판 ver 1.0");
    	listPrint();
    	setSize(640, 550);
    	setVisible(true);
    	
    	// 등록 => actionPerformed를 호출 
    	bList.inBtn.addActionListener(this);// 새글
    	bInsert.b2.addActionListener(this);// 취소
    	bInsert.b1.addActionListener(this);// 글쓰기
    }
    public void listPrint()
    {
    	// 테이블 전체를 한번 지운다
    	for(int i=bList.model.getRowCount()-1;i>=0;i--)
    	{
    		bList.model.removeRow(i);
    	}
    	
    	ArrayList<Board> list=bs.boardList(curpage);
    	totalpage=bs.boardTotalPage();
    	bList.pageLa.setText(curpage+" page / "+totalpage+" pages");
    	for(int i=list.size()-1;i>=0;i--) // 최신 => 가장 위로 올린다.
    	{
    		Board b=list.get(i);
    		String[] data={
    			String.valueOf(b.getNo()),
    			b.getSubject(),
    			b.getName(),
    			new SimpleDateFormat("yyyy-MM-dd").format(b.getRegdate()),
    			String.valueOf(b.getHit())
    		};
    		bList.model.addRow(data);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new BoardMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(bList.inBtn==e.getSource())// 새글 버튼 클릭
		{
			card.show(getContentPane(), "INSERT");
		}
		else if(bInsert.b2==e.getSource())// 취소
		{
			card.show(getContentPane(), "LIST");
		}
		else if(bInsert.b1==e.getSource())// 글쓰기
		{
			// 입력값을 읽기 
			String name=bInsert.nameTf.getText();
			if(name.length()<1) // 입력이 안된 경우
			{
				bInsert.nameTf.requestFocus();
				return;
			}
			
			String subject=bInsert.subTf.getText();
			if(subject.length()<1) // 입력이 안된 경우
			{
				bInsert.subTf.requestFocus();
				return;
			}
			
			String content=bInsert.ta.getText();
			if(content.length()<1) // 입력이 안된 경우
			{
				bInsert.ta.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(bInsert.pwdPf.getPassword());
			if(pwd.length()<1) // 입력이 안된 경우
			{
				bInsert.pwdPf.requestFocus();
				return;
			}
			
			Board b=new Board();
			b.setName(name);
			b.setContent(content);
			b.setPwd(pwd);
			b.setSubject(subject);
			b.setRegdate(new Date());
			b.setHit(0);
			bs.boardInsert(b);//추가 
			// 이동 
			card.show(getContentPane(), "LIST");
			listPrint();
		}
	}

}

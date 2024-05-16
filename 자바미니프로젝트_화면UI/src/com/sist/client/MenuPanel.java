package com.sist.client;
import java.awt.GridLayout;

import javax.swing.*;
// 홈 검색 채팅 게시판 뉴스 ...
public class MenuPanel extends JPanel{
    public JButton b1,b2,b3,b4,b5,b6;
    // JButton[] btn=new JButton[10]
    // 초기화 => 배치 
    public MenuPanel()
    {
    	setLayout(new GridLayout(1,5,5,5)); // 같은 크기의 버튼 생성 
    	b1=new JButton("홈"); // 목록 / 상세보기 
    	b2=new JButton("검색"); // 검색 / 상세보기  
    	b3=new JButton("채팅"); // 채팅 / 쪽지보내기 
    	b4=new JButton("게시판");//목록 , 상세보기 , 수정 , 추가 , 삭제 
    	b5=new JButton("뉴스");// 뉴스 검색 
    	b6=new JButton("나가기");
    	// 추가 
    	add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);
    }
}

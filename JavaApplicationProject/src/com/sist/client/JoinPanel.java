package com.sist.client;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class JoinPanel extends JPanel{
    JLabel tLa,iLa,pLa1,nLa,sLa,bLa,pLa,aLa1,aLa2,telLa,cLa,eLa;
    JTextField idtf,nametf,birthtf,posttf,addrtf1,addrtf2,teltf,emailtf;
    JTextArea cta;
    JButton b1,b2,b3,b4;
    JRadioButton rb1,rb2;
    JComboBox box;
    JPasswordField pf;
    
    public JoinPanel()
    {
    	setLayout(null);
    	tLa=new JLabel("회원 가입",JLabel.CENTER);
    	tLa.setFont(new Font("맑은 고딕",Font.BOLD,35));
    	tLa.setBounds(10, 15, 930, 40);
    	add(tLa);
    	
    	iLa=new JLabel("아이디",JLabel.RIGHT);
    	iLa.setBounds(150, 80, 90, 30);
    	add(iLa);
    	
    	idtf=new JTextField();
    	idtf.setBounds(265, 80, 200, 30);
    	add(idtf);
    	
    	b1=new JButton("아이디 중복체크");
    	b1.setBounds(470, 80, 150, 30);
    	add(b1);
    	/////////////////////////////////////////////////////////////// id
    	pLa1=new JLabel("비밀번호",JLabel.RIGHT);
    	pLa1.setBounds(150, 115, 90, 30);
    	add(pLa1);
    	
    	pf=new JPasswordField();
    	pf.setBounds(265, 115, 200, 30);
    	add(pf);
    	///////////////////////////////////////////////////////////////
    	nLa=new JLabel("이름",JLabel.RIGHT);
    	nLa.setBounds(150, 150, 90, 30);
    	add(nLa);
    	
    	nametf=new JPasswordField();
    	nametf.setBounds(265, 150, 200, 30);
    	add(nametf);
    	////////////////////////////////////////////////////////////////
    	sLa=new JLabel("성별",JLabel.RIGHT);
    	sLa.setBounds(150, 185, 90, 30);
    	add(sLa);
    	
    	rb1=new JRadioButton("남자");
    	rb1.setBounds(265, 185, 70, 30);
    	add(rb1);
    	
    	rb2=new JRadioButton("여자");
    	rb2.setBounds(340, 185, 70, 30);
    	add(rb2);
    	
    	ButtonGroup bg=new ButtonGroup();
    	bg.add(rb1); bg.add(rb2);
    	
    	rb1.setSelected(true);
    	/////////////////////////////////////////////////////////////
    	bLa=new JLabel("생년월일",JLabel.RIGHT);
    	bLa.setBounds(150, 220, 90, 30);
    	add(bLa);
    	
    	birthtf=new JTextField();
    	birthtf.setBounds(265, 220, 200, 30);
    	add(birthtf);
    	////////////////////////////////////////////////////////////
    	eLa=new JLabel("이메일",JLabel.RIGHT);
    	eLa.setBounds(150, 255, 90, 30);
    	add(eLa);
    	
    	emailtf=new JTextField();
    	emailtf.setBounds(265, 255, 450, 30);
    	add(emailtf);
    	////////////////////////////////////////////////////////////
    	pLa=new JLabel("우편번호",JLabel.RIGHT);
    	pLa.setBounds(150, 290, 90, 30);
    	add(pLa);
    	
    	posttf=new JTextField();
    	posttf.setBounds(265, 290, 200, 30);
    	add(posttf);
    	
    	posttf.setEnabled(false);
    	posttf.setHorizontalAlignment(JLabel.CENTER);
    	
    	b2=new JButton("우편번호 검색");
    	b2.setBounds(470, 290, 150, 30);
    	add(b2);
    	////////////////////////////////////////////////////////////
    	aLa1=new JLabel("주소",JLabel.RIGHT);
    	aLa1.setBounds(150, 325, 90, 30);
    	add(aLa1);
    	
    	addrtf1=new JTextField();
    	addrtf1.setBounds(265, 325, 450, 30);
    	add(addrtf1);
    	
    	aLa2=new JLabel("상세주소",JLabel.RIGHT);
    	aLa2.setBounds(150, 360, 90, 30);
    	add(aLa2);
    	
    	addrtf2=new JTextField();
    	addrtf2.setBounds(265, 360, 450, 30);
    	add(addrtf2);
    	///////////////////////////////////////////////////////////
    	telLa=new JLabel("전화",JLabel.RIGHT);
    	telLa.setBounds(150, 395, 90, 30);
    	add(telLa);
    	
    	box=new JComboBox();
    	box.addItem("010");
    	box.setBounds(265, 395, 90, 30);
    	add(box);
    	
    	teltf=new JTextField();
    	teltf.setBounds(370, 395, 200, 30);
    	add(teltf);
    	///////////////////////////////////////////////////////////
    	cLa=new JLabel("소개",JLabel.RIGHT);
    	cLa.setBounds(150, 430, 90, 30);
    	add(cLa);
    	
    	cta=new JTextArea();
    	JScrollPane js=new JScrollPane(cta);
    	js.setBounds(265, 430, 450,170);
    	add(js);
    	
    	b3=new JButton("회원가입");
    	b4=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b3);p.add(b4);
    	
    	p.setBounds(150, 610, 565, 35);
    	add(p);
    }
}

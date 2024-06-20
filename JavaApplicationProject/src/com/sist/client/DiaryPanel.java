package com.sist.client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
class StringManager {

	//넘겨받은 인수가 1자리 수 인 경우 앞에 '0' 문자를 붙이고
	//2자리 수면 그냥 쓴다.
	public static String getZeroString(int n) {
		return (n < 10)? "0"+n : Integer.toString(n);
	}
}
class DateBox extends JPanel{
	String day;
	Color color;
	int width;
	int height;
	
	public DateBox(String day, Color color, int width, int height) {
		this.day = day;
		this.color = color;
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));		
	}
	
	//paint를 재정의하면 컴포넌트에 내가 원하는 것을 그릴 수 있다.
	//이를 이용해서 배경색과 글씨를 넣기
	public void paint(Graphics g) {
		g.setColor(color);
		//꽉찬 상자를 넣는 것인데 위에서 설정한 색으로 배경색을 칠하는 것
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.yellow);
		//글씨를 그리는 것인데 첫번 째 매개변수는 글씨의 내용
		//2번째는 x축  3번째는 y축
		g.drawString(day, 10, 20);
	}
}
public class DiaryPanel extends JPanel{
	
	String[] dayAr = {"Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat"};
	DateBox[] dateBoxAr = new DateBox[dayAr.length*6];
	JPanel p_north;
	JButton bt_prev;
	JLabel lb_title;
	JButton bt_next;
	JPanel p_center; //날짜 박스 처리할 영역
	Calendar cal; //날짜 객체
	
	int yy; //기준점이 되는 년도
	int mm; //기준점이 되는 월
	int startDay; //월의 시작 요일
	int lastDate; //월의 마지막 날
	ControllPanel cp;
	//생성자
	public DiaryPanel(ControllPanel cp) {
		this.cp=cp;
		//디자인
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		lb_title = new JLabel("년도 올 예정", SwingConstants.CENTER);
		bt_next = new JButton("다음");
		p_center = new JPanel();
		
		//라벨에 폰트 설정
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25));
		lb_title.setPreferredSize(new Dimension(300, 30));
		
		p_north.add(bt_prev);
		p_north.add(lb_title);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		//이전 버튼을 눌렀을 때 전 월로 이동해야함
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(-1);
			}
		});
		
		//다음 버튼을 눌렀을 때 다음 달로 이동해야함
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(1);
			}
		});
		
		getCurrentDate(); //현재 날짜 객체 생성
		getDateInfo(); //날짜 객체로부터 정보들 구하기
		setDateTitle(); //타이틀 라벨에 날짜 표시하기
		createDay(); //요일 박스 생성
		createDate(); //날짜 박스 생성
		printDate(); //상자에 날짜 그리기
		
		setVisible(true);
		//setBounds(100, 100, 780, 780);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//현재날짜 객체 만들기
	public void getCurrentDate() {
		cal = Calendar.getInstance();
	}
	
	//시작 요일, 끝 날 등 구하기
	public void getDateInfo() {
		yy = cal.get(Calendar.YEAR);
		mm = cal.get(Calendar.MONTH);
		startDay = getFirstDayOfMonth(yy, mm);
		lastDate = getLastDate(yy, mm);
	}
	
	//요일 생성
	public void createDay() {
		for(int i = 0; i < 7; i++){
			DateBox dayBox = new DateBox(dayAr[i], Color.gray, 100, 70);
			p_center.add(dayBox);
		}
	}
	
	//날짜 생성
	public void createDate() {
		for(int i = 0; i < dayAr.length*6; i++) {
			DateBox dateBox = new DateBox("", Color.LIGHT_GRAY, 100, 100);
			p_center.add(dateBox);
			dateBoxAr[i] = dateBox;
		}
	}
	
	//해당 월의 시작 요일 구하기
	//개발 원리 : 날짜 객체를 해당 월의 1일로 조작한 후, 요일 구하기
	//사용 방법 : 2021년 2월을 구할시 2021, 1을 넣으면 됨
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal = Calendar.getInstance(); //날짜 객체 생성
		cal.set(yy, mm, 1);
		return cal.get(Calendar.DAY_OF_WEEK)-1;//요일은 1부터 시작으로 배열과 쌍을 맞추기 위해 -1
	}
	
	//사용 방법 : 2021년 2월을 구할시 2021, 1을 넣으면 됨
	public int getLastDate(int yy, int mm) {
		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm+1, 0);
		//마지막 날을 의미한다.
		return cal.get(Calendar.DATE);
	}
	
	//날짜 박스에 날짜 출력하기
	public void printDate() {
		System.out.println("시작 요일"+startDay);
		System.out.println("마지막 일"+lastDate);
		
		int n = 1;
		for(int i = 0; i < dateBoxAr.length; i++) {
			if(i >= startDay && n <= lastDate) {
				dateBoxAr[i].day = Integer.toString(n);
				dateBoxAr[i].repaint();
				n++;
			}else {
				dateBoxAr[i].day = "";
				dateBoxAr[i].repaint();
			}
		}
	}
	
	//달력을 넘기거나 전으로 이동할 때 날짜 객체에 대한 정보도 변경
	public void updateMonth(int data) {
		//캘린더 객체에 들어있는 날짜를 기준으로 월 정보를 바꿔준다.
		cal.set(Calendar.MONTH, mm+data);
		getDateInfo();
		printDate();
		setDateTitle();
	}
	
	//몇년도 몇월인지를 보여주는 타이틀 라벨의 값을 변경
	public void setDateTitle() {
		lb_title.setText(yy+"-"+StringManager.getZeroString(mm+1));
		lb_title.updateUI();
	}
	
	/*
	 * public static void main(String[] args) { new DiaryPanel(); }
	 */
}
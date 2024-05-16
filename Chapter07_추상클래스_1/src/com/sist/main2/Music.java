package com.sist.main2;
/*
 *   2|SPOT! (Feat. JENNIE)|지코 (ZICO)|SPOT!|//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/085/072/667/85072667_1714091257020_1_140x140.JPG/dims/resize/Q_80,0|xfqBQ2XhBCg\u0026pp=ygUUU1BPVCEgKEZlYXQuIEpFTk5JRSk%3D
     1|SPOT! (feat. JENNIE)|지코 (ZICO)|SPOT!|https://cdnimg.melon.co.kr/cm2/album/images/114/74/894/11474894_20240426103349_500.jpg/melon/resize/120/quality/80/optimize
 */
// 모든 클래스에는 this,super: 상속 내린 클래스에 접근 
// 모든 클래스는 상속을 받는다 => extends Object (생략)
public class Music {
	// 다른 클래스에서 사용한다 
    private String mno;
    private String title;
    private String singer;
    private String album;
    private String poster;
   // Music안에서만 사용 => 다른 클래스 연결 => 메소드를 이용해서 접근 => 데이터 보호 => 캡슐화 
	public String getMno() {
		
		return mno;
	}
	public void setMno(String mno) {
		// 임시변수 => 메소드안에서만 사용이 가능 => 다른 클래스에서는 사용하지 못한다 
		this.mno = mno;
		// this => 자신의 클래스 객체 주소를 저장해서 사용 
		// this는 static : 모든 객체는 this를 가지고 있다 
		// this가 많이 사용되는 곳 => 멤버변수 / 지역변수의 이름이 같은 경우에 구분 
		// this.mno => Music이 가지고 있는 변수
	}
	public String getTitle() {
		return title;
		// 1. 지역변수,매개변수 => 없는 경우 => 2. 멤버변수 
		// 지역변수 우선순위 
		// 없는 경우에는 this.를 생략이 가능하다 
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
   
}

// 년도를 입력을 받아서 윤년인지 확인하는 프로그램을 작성
/*
 *   년도입력:2024
 *   윤년입니다 
 */
public class 메소드_재사용2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int year=메소드_구조적프로그램_1.input("년도");
        boolean bCheck=메소드_구조적프로그램_1.isYear(year);
        if(bCheck)
        	System.out.println("윤년입니다");
        else
        	System.out.println("윤년이 아닙니다");
	}

}

/*
 *   선언후 값 => true,false,true,false
 *   boolean[] boo=new boolean[4]=> false,false,false,false
 *   boo[0]=true; 값 변경 
 *   -----------------------------------------------
 *   boolean[] boo;
 *   boo=new boolean[]{true,false,true,false}
 *   ----------------------------------------------- 선언후에 초기값
 *   int[] arr=new int[3];
 *   -----
 *   데이터형 => [] 숫자가 들어갈 수 없다 
 *   
 *   1) 10개의 문자를 가지는 배열 c를 생성하는 코드를 한 줄로 쓰라.
​
     2) 0에서 5까지 정수 값으로 초기화된 정수 배열 n을 선언하라.
​
     3) '일', '월', '화', '수', '목', '금', '토'로 초기화된 배열 day를 선언하라.
​
    4) 4개의 논리 값을 가진 배열 bool을 선언하고 true, false, false, true로 선언하라.

 *   
 *  
 */
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1 10개의 문자를 가지는 배열 c를 생성하는 코드를 한 줄로 쓰라.
		char[] c=new char[10];
		//2 0에서 5까지 정수 값으로 초기화된 정수 배열 n을 선언하라
		int[] n={0,1,2,3,4,5};
		//3 '일', '월', '화', '수', '목', '금', '토'로 초기화된 배열 day를 선언하라.
		char[] day={'일', '월', '화', '수', '목', '금', '토'};
		//3-1 "일", "월", "화", "수", "목", "금", "토"로 초기화된 배열 days를 선언하라.
		String[] days={"일", "월", "화", "수", "목", "금", "토"};
		//4 4개의 논리 값을 가진 배열 bool을 선언하고 true, false, false, true로 선언하라.
		boolean[] bool;
		bool=new boolean[]{true, false, false, true};
		
	}

}

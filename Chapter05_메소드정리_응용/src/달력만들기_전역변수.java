import java.util.*;
public class 달력만들기_전역변수 {
    static int year,month,week,lastday;
    static void userInput()
    {
    	Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		year=scan.nextInt();
		
		System.out.print("월 입력:"); // final
		month=scan.nextInt();
    }
    static void getWeek()
    {
    	        // 2. 요일 구하기 => 사용자 정의 / 라이브러리
    			Calendar cal=Calendar.getInstance(); // 싱글턴 
    			// Calendar클래스 메모리 할당 
    			// 추상클래스
    			cal.set(Calendar.YEAR, year);
    			cal.set(Calendar.MONTH, month-1);// 0번부터 
    			cal.set(Calendar.DATE, 1);
    			
    			// 요일 
    			week=cal.get(Calendar.DAY_OF_WEEK);// 1번부터 
    			week=week-1;
    			// 마지막 날 
    			lastday=cal.getActualMaximum(Calendar.DATE);
    }
    static void print()
    {
    	String[] strWeek={
				"일","월","화","수","목","금","토"
		};
		System.out.println(year+"년도 "+month+"월");
		for(String s:strWeek)
		{
			System.out.print(s+"\t");
		}
		System.out.println("\n");
		for(int i=1;i<=lastday;i++)
		{
			if(i==1)// 시작 => 요일까지 공백 출력
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;//0~6
			if(week>6)
			{
				System.out.println();
				week=0;
			}
		}
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        userInput();
        getWeek();
        print();
	}

}

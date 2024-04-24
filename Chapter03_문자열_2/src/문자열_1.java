// contains : 포함된 문자열 읽기 => 결과값 true/false
/*
 *   searchMainDailyBoxOffice.do 일일 박스오피스
 *   searchMainRealTicket.do 실시간 예매율
 *   searchMainDailySeatTicket.do 좌석점유율순위
 */
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
public class 문자열_1 {
	static String[] names= {
			"searchMainDailyBoxOffice.do",
			"searchMainRealTicket.do",
			"searchMainDailySeatTicket.do"
	};
    public static void moviePrint(int no) throws Exception
    {
    	Document doc=Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/"+names[no]).get();
		//System.out.println(doc);
		String data=doc.toString();
		data=data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
		//System.out.println(data);
		JSONParser jp=new JSONParser();
		JSONArray arr=(JSONArray)jp.parse(data);
		for(int i=0;i<arr.size();i++)
		{
			JSONObject obj=(JSONObject)arr.get(i);
			System.out.println((i+1)+"."+obj.get("movieNm"));
		}
    }
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(true) //무한루프 
        {
        	System.out.println("=======================");
        	System.out.println("1. 일일 박스오피스");
        	System.out.println("2. 실시간 예매율");
        	System.out.println("3. 좌석점유율순위");
        	System.out.println("4. 종료");
        	System.out.println("=======================");
        	System.out.print("메뉴 선택:");
        	int menu=scan.nextInt();
        	if(menu==1)
        	{
        		moviePrint(0);
        	}
        	else if(menu==2)
        	{
        		moviePrint(1);
        	}
        	else if(menu==3)
        	{
        		moviePrint(2);
        	}
        	else if(menu==4)
        	{
        		System.out.println("프로그램 종료");
        		break;
        	}
        	else
        	{
        		System.out.println("존재하지 않는 메뉴입니다");
        	}
        }
	}

}

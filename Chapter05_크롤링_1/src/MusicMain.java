/*
 *    Jsoup => 라이브러리 (웹 크롤링) => HTML데이터 읽기 
 *    HTML 
 *     <div class="name">데이터</div>
 *     ----        ----- => div.name
 *     <div id="name">데이터</div>
 *                       => div#name
 *     1. 태그 
 *        => 구분자 (class/id)
 *     2. 바로 위에 있는 태그 
 *        <div>
 *         <div></div>
 *        </div> 
 */
// 지니뮤직 ==> 멜론 
// 사용자 정의 데이터형 

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Music
{
   int rank;
   String title;
   String singer;
   String album;
   String poster;
   String key;
}
class GenieMusic
{
	Music[] musics=new Music[200]; // 클래스 블록은 선언하는 위치 
	/*
	 *    <td class="info">
                 <a href="#" class="title
	 */
	{
		try
		{
		  int k=1;
		  for(int i=1;i<=4;i++)
		  {
			  Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240503&hh=14&rtm=Y&pg="+i).get();
			  Elements title=doc.select("table.list-wrap td.info a.title");
			  Elements singer=doc.select("table.list-wrap td.info a.artist");
			  Elements album=doc.select("table.list-wrap td.info a.albumtitle");
			  Elements poster=doc.select("table.list-wrap a.cover img");
			  for(int j=0;j<title.size();j++)
			  {
				  System.out.println("순위:"+k++);
				  System.out.println("노래명:"+title.get(j).text());
				  System.out.println("가수명:"+singer.get(j).text());
				  System.out.println("앨범:"+album.get(j).text());
				  System.out.println("이미지:"+poster.get(j).attr("src"));
				  //System.out.println("동영상 키:"+youtubeData(title.get(j).text()));
				  System.out.println("===================================================");
			  }
		  }
			
		}catch(Exception ex){}
	}
	static String youtubeData(String title) throws Exception
	{
		String result="";
		String url="https://www.youtube.com/results?search_query="
				  +URLEncoder.encode(title, "UTF-8");
		Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
		Document doc=Jsoup.connect(url).get();
		Matcher m=p.matcher(doc.toString());
		while(m.find())
		{
			String temp=m.group();
			System.out.println(temp);
			temp=temp.substring(temp.indexOf("=")+1,temp.indexOf("\""));
			result=temp;
			break;
		}
		return result;
	}
}
public class MusicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenieMusic gm=new GenieMusic();
        try
        {
        	String url="http://youtube.com/embed/ImuWa3SJulY\\u0026pp=ygUM6rOg66-87KSR64-F";
        	Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+url);
        }catch(Exception ex) {}
	}

}

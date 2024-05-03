import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 *   파일 한개에 클래스가 여러개 있는 경우 
 *   => public class 한번만 사용 
 *      ------------ 저장명 
 *      
 *   => 예)
 *         class A
 *         class B
 *         public class C   =>  C.java
 *         ------ 파일명 == 클래스명 
 *         
 *         class A
 *         class B 
 *         -------- A.java , B.java
 *         => 가급적이면 => main이 있는 클래스명 
 *         
 *     => 따라 컴파일이 된다 
 *        class A
 *        class B 
 *        --------  A.class , B.class => 같은 폴더에서는 같은 이름의 클래스명을 사용할 수 없다 
 *         
 */
class Music2
{
   String rank;
   String title;
   String singer;
   String album;
   String poster;
   String key;
}
class MelonMusic
{
	static Music2[] musics=new Music2[100]; // 클래스 블록은 선언하는 위치 
	/*
	 *    <td class="info">
                 <a href="#" class="title
	 */
	{
		try
		{
//			int k=1;
//		    for(int i=50;i<=100;i+=50)
//		    {
//		      Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
//			  Elements title=doc.select("tr.lst"+i+" div.wrap div.rank01 a");
//			  Elements singer=doc.select("tr.lst"+i+" div.wrap div.rank02 a");
//			  Elements album=doc.select("tr.lst"+i+" div.wrap div.rank03 a");
//			  Elements poster=doc.select("div.wrap a.image_typeAll img");
//			  for(int j=0;j<title.size();j++)
//			  {
//				  System.out.println("순위:"+(k));
//				  System.out.println("노래명:"+title.get(j).text());
//				  System.out.println("가수명:"+singer.get(j).text());
//				  System.out.println("앨범:"+album.get(j).text());
//				  System.out.println("이미지:"+poster.get(j).attr("src"));
//				  //System.out.println("동영상 키:"+youtubeData(title.get(j).text()));
//				  System.out.println("===================================================");
//				  FileWriter fw=
//						  new FileWriter("c:\\javaDev\\melon.txt",true);//append
//				  String data=(j+1)+"|"
//						     +title.get(j).text()+"|"
//						     +singer.get(j).text()+"|"
//						     +album.get(j).text()+"|"
//						     +poster.get(j).attr("src")+"\r\n";
//				  fw.write(data);
//				  fw.close();
//				  k++;
//			  }
//		    }
		  // 파일에서 데이터 읽기
		  FileReader fr=new FileReader("c:\\javaDev\\melon.txt");
		  int i=0;
		  StringBuffer sb=new StringBuffer();
		  while((i=fr.read())!=-1)
		  {
			  sb.append((char)i);
		  }
		  fr.close();
		  
		  String data=sb.toString();
		  String[] temp=data.split("\n");
		  i=0;
		  for(String s:temp)
		  {
			  String[] ss=s.split("\\|");
			  musics[i]=new Music2();
			  musics[i].rank=ss[0];
			  musics[i].title=ss[1];
			  musics[i].singer=ss[2];
			  musics[i].album=ss[3];
			  musics[i].poster=ss[4];
			  i++;
		  }
			
		}catch(Exception ex){}
	}
	static void musicList()
	{
		System.out.println("================Music List===============");
		int i=1;
		for(Music2 s:musics)
		{
			System.out.println(i+"."+s.title);
			i++;
		}
	}
	static void musicDetail(int rank)
	{
		try
		{
			Music2 m=musics[rank-1];
			String url="http://youtube.com/embed/"+m.key;
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+url);
		}catch(Exception ex) {}
	}
	static void musicTitleFind(String title)
	{
		int count=0;
		for(Music2 m:musics)
		{
			if(m.title.contains(title))
			{
				System.out.println(m.title);
				count++;
			}
		}
		System.out.println("검색 결과 총 "+count+"건");
	}
	static void musicSingerFind(String singer)
	{
		int count=0;
		for(Music2 m:musics)
		{
			if(m.singer.contains(singer))
			{
				System.out.println(m.title+"["+m.singer+"]");
				count++;
			}
		}
		System.out.println("검색 결과 총 "+count+"건");
	}
	static String youtubeData(String title) throws Exception
	{
		String result="";
		String url="https://www.youtube.com/results?search_query="
				  +URLEncoder.encode(title, "UTF-8");
		Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
		//정규식 
		Document doc=Jsoup.connect(url).get();
		Matcher m=p.matcher(doc.toString());
		while(m.find())
		{
			String temp=m.group();
			System.out.println(temp);
			/*
			 *  /watch?v=Ejc__vhP2U8\u0026pp=ygUJ7JiI67uk7Ja0","webPageType":"WEB_PAGE_TYPE_WATCH","rootVe":3832}},"watchEndpoint":{"videoId":"Ejc__vhP2U8","params":"qgMJ7JiI67uk7Ja0ugMLCNWu0ZKv-dGC8gG6Aw8SDVJERWpjX192aFAyVTi6AwoIoPKA1va5u5cFugMKCNjj4YCYlcuDCboDCgjOqJGHgZ2J-Tq6AwsIpdDom4mLw6bIAboDCgiXj7OCiPfQ41y6AwoI4P7S5tLDh4k3ugMJCMfo1sHg_pgIugMLCJbvrufEt8TQ1wG6AwoI-qWf3oPEupNQugMLCJHn2e6Fh5WroAG6AwoIxeCuxdSjkdl2u
			 */
			temp=temp.substring(temp.indexOf("=")+1,temp.indexOf("\""));
			result=temp;
			break;
		}
		return result;
	}
}
/*
 *   프로그램 
 *     => 데이터 수집 
 *     => 데이터를 메모리 저장 => 프로그램 종료후 사라진다 => 파일 
 *        --------------- 모든 메소드에서 사용이 가능 => 전역변수 / 멤버변수 
 *     => 사용 요청하는 모든 내용 => 메소드 (수정 , 추가) => 재사용 
 *       
 *     
 */
public class MusicMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MelonMusic gm=new MelonMusic();
        gm.musicList();
        System.out.println("=========================================");
        Scanner scan=new Scanner(System.in);
        //System.out.print("1~200사이의 번호 선택:");
        //int no=scan.nextInt();
        //gm.musicDetail(no);
        System.out.print("검색어 입력:");
        String title=scan.next();
        gm.musicTitleFind(title);
        String singer=scan.next();
        gm.musicSingerFind(singer);
        /*try
        {
        	String url="http://youtube.com/embed/ImuWa3SJulY\\u0026pp=ygUM6rOg66-87KSR64-F";
        	Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+url);
        }catch(Exception ex) {}*/
	}

}

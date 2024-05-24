package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Set_5 {
   public Set<String> genieData()
   {
	   Set<String> genie=new HashSet<String>();
	   try
	   {
		   Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		   // 문서저장 => HTML문서를 저장 
		   // 태그의 값 => Element 
		   Elements title=doc.select("table.list-wrap a.title");
		   for(int i=0;i<title.size();i++)
		   {
			   genie.add(title.get(i).text());
		   }
	   }catch(Exception ex){}
	   return genie;
   }
   public Set<String> melonData()
   {
	   Set<String> melon=new HashSet<String>();
	   try
	   {
		   Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
		   // 문서저장 => HTML문서를 저장 
		   // 태그의 값 => Element 
		   Elements title=doc.select("div.wrap_song_info div.rank01 a");
		   for(int i=0;i<title.size();i++)
		   {
			   melon.add(title.get(i).text());
		   }
	   }catch(Exception ex){}
	   return melon;
   }
}

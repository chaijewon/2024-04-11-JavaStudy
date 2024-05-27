package com.sist.io;
// 파일 읽기 => FileInputStream / FileReader 
//           => 1byte (한글 깨짐) => 2byte (한글 정상적으로)
//           => 한글을 읽을때 1byte => 2byte 변경해서 읽기 => BufferedReader
import java.io.*;
public class 라이브러리_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileInputStream fis=null;
        try
        {
        	// 읽을 파일을 설정 
        	fis=new FileInputStream("c:\\java_data\\seoul_location.txt");
        	// 영문 , 숫자 , 특수문자는 상관이 없다 => 영어가 아닌 다른 언어는 다 깨진다 
        	/*int i=0;
        	String data="";
        	while((i=fis.read())!=-1) //파일이 끝날때까지 읽는다 
        	{
        		data+=(char)i;
        	}
        	
        	System.out.println(data);*/
        	BufferedReader br=new BufferedReader(new InputStreamReader(fis));
        	//                                       -----------------
        	//                                           1byte    2byte => 1=>2byte로 읽어 온다 
        	String data="";
        	long start=System.currentTimeMillis();
        	while(true)
        	{
        		String s=br.readLine(); // 한줄씩 읽기 
        		if(s==null) break; // 문장이 끝나면 
        		data+=s+"\n";
        	}
        	long end=System.currentTimeMillis();
        	System.out.println(data);
        	System.out.println("걸린 시간:"+(end-start));
        }catch(Exception ex)
        {
        	ex.printStackTrace();// 에러 확인 => 복구 
        }
        finally
        {
        	// 파일 => 서버 => 데이터베이스 연결 => 에러,정상 => 반드시 닫는다 
        	try
        	{
        		fis.close();
        	}catch(Exception ex) {}
        }
        	
	}

}

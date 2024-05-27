package com.sist.io;
// => inputStream / outputStream => 도스 
// => HTML/Window => 입력할 수 있는 창을 만든다 
// 파일 입출력 , 객체 단위 입출력 
// FileInputStream / FileOutputStream 
// => 파일 복사 / 파일 다운로드 
// FileReader / FileWriter
// => 크롤링후 파일 저장 , 파일을 이용해서 관리 프로그램 
// => 파일을 읽어서 화면에 출력 
// ObjectInputStream / ObjectOutputStream 
/*
 *    ArrayList => 파일 읽어서 저장 
 *                 --------
 *    -------------------------
 *       |
 *    자체 저장 
 */
import java.io.*;
/*
 *    파일 
 *     => 모드 
 *        r => 읽기 => FileReader 
 *        w => 쓰기 => FileWriter fw=new FileWriter("경로명") => w
 *        -------------> 파일 Create 
 *        a => append => 파일에 연속해서 출력 
 *        -----------------------------
 *                    FileWriter fw=new FileWriter("경로명",true)
 */
public class 라이브러리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null; // 초기화 
		FileOutputStream fos=null;
		// 파일 업로드 / 다운로드 / 파일 복사 
		// 파일 제어 => 읽기/쓰기 => 한글이 가능 => FileReader / FileWriter
        try
        {
        	fis=new FileInputStream("c:\\javaDev\\back.jpg");
        	fos=new FileOutputStream("c:\\java_data\\back.jpg");
        	int i=0;
        	byte[] buffer=new byte[1024];
        	/*
        	 *   파일 읽기 
        	 *   => read() => 한글자씩 읽기 
        	 *   => read(byte[] buffer,int s,int e) => 지정된 갯수만큼 읽기 
        	 */
        	while((i=fis.read(buffer, 0, 1024))!=-1)
        	{
        		// i=> 읽은 바이트수 
        		fos.write(buffer, 0, i); // 클라이언트에서 서버로 파일을 전송 
        		// => TCP : 1024 , UDP : 521 
        		// => 프로그래바가 증가 ... (업로드 / 다운로드를 동시에 사용) 
        		
        	}
        	System.out.println("파일 복사 완료!!"); // 업로드 
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        finally
        {
        	try
        	{
        		fis.close();
        		fos.close();
        	}catch(Exception ex) {}
        }
	}

}

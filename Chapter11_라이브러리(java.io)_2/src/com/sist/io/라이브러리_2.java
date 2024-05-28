package com.sist.io;
// 데이터 읽기 
import java.util.*;
import java.io.*;
// 파일 입출력 => 프로젝트 
// ObjectInputStream / ObjectOutputStream => 사용빈도가 많이 없어진다 
// => SQL (오라클 연동) 
// => 개인 정보 저장 => 네트워크가 연결이 안되면 => 파일 
// => 대비 (에러) => 오라클이 정지 => 파일 
// => JSON / CVS / XML => 파싱 (필요한 데이터 읽기) => 오픈 API (라이브러리가 따로 있다) 
//    ***jackon CVSReader/CSVWriter , ***DOM/SAX 
//           => 파이썬 (공공데이터) => CSV 
public class 라이브러리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ObjectInputStream ois=null;
        try
        {
        	// 객체 생성 
        	FileInputStream fis=new FileInputStream("c:\\java_data\\std.txt");
        	ois=new ObjectInputStream(fis);
        	ArrayList<Student> list=(ArrayList<Student>)ois.readObject();
        	// readObject():Object => 형변환 
        	// 제네릭까지 데이터형 
        	for(Student s:list)
        	{
        		System.out.println(s.getHakbun()+" "
        				  +s.getName()+" "
        				  +s.getKor()+" "
        				  +s.getMath()+" "
        				  +s.getEng());
        	}
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        finally
        {
        	try
        	{
        		ois.close();
        	}catch(Exception ex) {}
        }
	}

}

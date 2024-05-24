package com.sist.main;
/*
 *    ArrayList / HashSet / HashMap 
 *    ---------- --------   -------
 *                          | 두가지 동시에 저장 (id:admin) (pwd:1234)...
 *               | 중복이 없는 경우 
 *    | 중복이 있는 경우
 *    
 *    ====> 자료 구조 : 데이터 저장 , 데이터 수정 , 데이터 추가 , 데이터 삭제 ,데이터 검색 
 *                   --------   --------  ---------  --------  --------
 *                                 |                    |         |
 *                                 --------------------------------
 *                                              |
 *                                            데이터를 찾을 수 있는 구분자
 *                    => ArrayList : 인덱스 번호 (중복이 있다)
 *                    => Set       : 데이터 자체 (중복없다) 
 *                    => Map       : key(중복없다) ,value(중복이 가능) 
 *                    -------------------------------------------
 *                     배열 보완 => 고정(가변) 
 *                               -------- 삭제,추가기능이 불가능 
 *                   ---------------------------------------------------
 *                    => 자바 : 컬렉션 (여러개 수집 => 관리) 
 *                    
 *             Collection 
 *                |
 *       --------------------------
 *       |          |             |
 *     List       Set           Map
 *       |
 *    ArrayList  HashSet       HashMap
 *    LinkedList TreeSet       Hashtable
 *    Vector
 *    ===> List : MyBatis , JPA 
 *                -------------
 *    => 개발자 선호 
 *       --------
 *       ArrayList<String> list=new ArrayList<String>() ==> X
 *       
 *       List<String> list=new ArrayList<String>();  ==> O
 *       List<String> list=new Vector<String>();
 *       List<String> list=new LinkedList<String>();
 *       
 *       Set<String> list=new HashSet<String>()
 *       Set<String> list=new TreeSet<String>()
 *       
 *       프로그램 단점 
 *         => 개발자마다 다르다 
 *            ------------
 *            for => while = do~while 
 *            -----------------------
 *            
 */
import java.util.*;
public class Set_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Vector<String> list=new Vector<String>();
		List<String> list=new LinkedList<String>();
        list.add("홍길동");
        list.add("박문수");
        
        for(int i=0;i<list.size();i++)
        {
        	String name=list.get(i);
        	System.out.println(name);
        }
	}

}

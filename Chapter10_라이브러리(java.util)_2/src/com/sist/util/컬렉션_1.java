package com.sist.util;
/*
 *      Collection : 배열을 대처 => 가변형 (저장갯수를 지정하지 않는다) 
 *                                    -------------------- 신축성 
 *      1. 컬렉션 프레임워크
 *         = 다수의 데이터를 쉽고 효율적으로 처리할 수 있게 만든 표준화된 클래스의 집합 
 *                          -----------           ----- 모든 개발자가 동일하게 사용 
 *         = 자료구조 : 데이터 수정 , 삭제 , 추가 , 읽기가 가능 
 *                              --------- 배열은 불가능하다 (고정)
 *         = 동적 메모리 할당 (가변형) 
 *           필요시마다 데이터를 추가, 삭제가 편리하다 
 *           => 웹 , 모바일 => 컬렉션을 이용해서 데이터 전송 
 *         = 단점 : 모든 데이터를 저장이 가능하게 => Object로 되어 있다 => 객체 형변환 
 *           // 메소드 => 리턴형/매개변수 => Object => 제네릭스(프로그램 맞게 데이터형 변경해서 사용)  
 *      2. 336page : 컬렉션의 종류 
 *      
 *                      Collection : interface 
 *                          |
 *                ------------------------------------
 *                |                 |                |
 *              List               Set              Map => interface 
 *                |                 |                |
 *            **ArrayList         **HashSet          Hashtable  ==> interface 구현한 클래스 
 *            LinkedList          TreeSet          **HashMap
 *            Vector 
 *         
 *            List => 데이터 중복 허용 
 *                    순서를 가지고 있다 (인덱스)
 *                    
 *            Set  => 데이터 중복을 허용하지 않는다 
 *                    순서가 존재하지 않는다 
 *                    
 *            Map  => (key , value) => 동시에 저장 
 *                     key는 중복이 불가능 => value는 중복이 가능 
 *                     
 *            --------------------- 추가 , 수정 , 삭제 , 읽기 => CRUD => 자료 구조 
 *            
 *            ArrayList : 비동기 , 데이터베이스 연결 
 *                               ------------ 
 *            LinkedList : C언어와 호환 
 *            Vector : 동기 , 네트워크 접속자 정보 저장 => 보완 => ArrayList
 *            
 *            ArrayList => 337page 
 *            ---------
 *            1) 가장 많이 사용되는 컬렉션 
 *            2) 인덱스를 이용해서 데이터를 저장하고 관리 => 배열과 유사 
 *               ------------------
 *            3) 기본형 , 클래스를 첩부해서 사용이 가능 
 *            4) 접근 속도가 빠르다 
 *            5) 단점 : 추가 , 삭제시에 속도가 늦다 
 *                    ----------
 *                    
 *                    0 A
 *                    1 => E
 *                    2 B
 *                    3 C
 *                    4 D
 *                   -------
 *                    0 A
 *                    1 B => 삭제 
 *                    1 C
 *                    2 D
 *                   ------- 추가,삭제 => 자동으로 순차적으로 조절 
 *                   => 가급적으로 마지막에 데이터 추가 
 *               => 저장은 어떤 데이터든 상관없이 가능 
 *                           ------------ Object    
 *             
 *   
 */
import java.util.*;
public class 컬렉션_1 {
    // CObList 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList list=new ArrayList(); // 가변형 => 데이터저장 갯수를 지정하지 않는다
        /*
         *   접근 속도가 늦다 , 추가,삭제가 빠르다 
         *   ------------  
         */
        // 1. 저장 => add() => 마지막에 추가  
        list.add("홍길동"); // 0
        // 박문수 추가       // 1
        list.add("심청이"); // 2
        list.add("이순신"); // 3
        list.add("강감찬"); // 4
        list.add("김두한"); // 5
        // 2. 저장 => add() => 원하는 위치 저장 
        list.add(1,"박문수");
        
        // 3.출력 => 저장된 위치에서 값을 읽기 => get(index) 
        // 4.저장된 갯수 => size()
        for(int i=0;i<list.size();i++)
        {
        	String name=(String)list.get(i);
        	System.out.println(name);
        }
        System.out.println("==== 배열/컬렉션 출력 (for-each) ====");
        for(Object name:list)
        {
        	System.out.println(name);
        }
        // 5. 수정 => set()
        list.set(1, "을지문덕");
        System.out.println("===== 수정후 =====");
        for(Object name:list)
        {
        	System.out.println(name);
        }
        // 6. 삭제 => remove()
        list.remove(1);
        System.out.println("===== 삭제후 =====");
        for(Object name:list)
        {
        	System.out.println(name);
        }
        // 7. 전체 삭제 => clear()
        list.clear();
        System.out.println("현재 인원:"+list.size());
	}

}

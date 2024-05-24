package com.sist.util;
/*
 *    ArrayList 
 *       => add(),remove(),set(),size(),get(),isEmpty(),clear()
 *          -----                ------ -----           -------
 *       => ArrayList에는 한개만 저장 
 *         --------------------------------------------------
 *          ArrayList 두개 이상인 경우 => JOIN
 *          retainAll() => 두개의 List에서 같은 값을 읽어 오는 경우 
 *                         ------------------------------
 *                         장바구니 => 중복 구매 
 *          addAll() => 전체를 데이터 복사 
 *          removeAll() => 한쪽에 없는 데이터만 출력 
 *          subList() => 부분복사 
 *          asList() => 배열 => ArrayList로 변경 
 *        --------------------------------------------------- 교재에 없는 내용
 */
import java.util.*;
public class 컬렉션_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> list=new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        // addAll() => Set => 복사가 가능 
        for(String s:list)
        	System.out.println(s);
        
        // asList는 클래스는 첨부가 불가능 => 기본형 / String만 
        ArrayList<String> list2=new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
        for(String s:list2)
        	System.out.println(s);
	}

}

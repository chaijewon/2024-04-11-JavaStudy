package com.sist.util;
// StringTokenizer : 문자열 분리 
/*
 *    nextToken() => 분리된 데이터를 가지고 오는 경우 
 *    hasMoreTokens() => 분리된 데이터만큼 루프 
 *    countTokens() => 분리된 갯수 
 */
import java.util.*;
public class 라이브러리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String colors="red,green,blue,black,white,yellow,magenta,pink,gray";
        StringTokenizer st=new StringTokenizer(colors,",");
        //  new StringTokenizer(colors) => 공백 
        System.out.println("color의 갯수:"+st.countTokens());
        /*System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());*/
        while(st.hasMoreTokens())
        {
        	System.out.println(st.nextToken());
        }
        
        /*
         *    hasMoreTokens() => 329page => 이미지 => 전체 분리된 데이터를 가지고 올때 
         *    
         cursor-----------------------
         *     before / first
         *    -----------------------
         *     red  => st.nextToken() => true
         *    -----------------------
         *     green => st.nextToken() => true
         *    -----------------------
         *     blue => st.nextToken() => true
         *    -----------------------
         *    
         *    ....
         *    -----------------------
         *     after / last  st.nextToken() => false => 종료 
         *    -----------------------
         */
        
	}

}

package com.sist.util;
/*
 *    라이브러리 
 *      => 클래스 : 하는 역할 
 *         -----
 *          => 메소드 : 원형 (리턴형/매개변수) 
 *             ----- 어떤 기능을 수행하는지 ...
 *                  -------------
 *                   프로그램에서 사용하는 위치 
 *     ----------------------------------
 *      => 사용처 
 *      ------------- 프로그램 : 라이브러리+사용자 정의(메소드,클래스) 
 *                            ------- -------- 
 *                              50%     50%
 *                             -------------
 *      java.lang / java.util / java.text / java.io / java.net / java.sql
 *      ---------   ---------   ---------   -------   --------  ---------
 *                                                     URL       Connection/Statement/ResultSet
 *                                                     URLEncoder 
 *                                           FileInputStream/FileOutputStream 
 *                                           File 
 *                                           FileReader / FileWriter
 *                                           BufferedReader
 *                               SimpleDateFormat / DecimalFormat 
 *                   Date / StringTokenizer / ArrayList / Map
 *       Object / String / StringBuffer / Math / Wrapper 
 *                                               Integer/Double/Boolean 
 *      -----------------------------------------------------------------
 */
public class 컬렉션_정리_1 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		// public static String format(String s,Object...arg)
		// String java.lang.String.format(String format, Object... args)
        //String s=String.format("%5d%5d%5d%5d%5s", 10,20,30,40,"aaa");
        //System.out.println(s);
		String[] strArray = { "10" , "2a" };
        int value = 0;
        for(int i = 0; i <= 2; i++ ){
        	try{
            	value = Integer.parseInt(strArray[i]);
            } catch(ArrayIndexOutOfBoundsException e){
            	System.out.println("인덱스를 초과했음");
            } catch(NumberFormatException e) {
            	System.out.println("숫자로 변환할 수 없음");
            } finally {
            	System.out.println(value);
            }

	}
	}

}

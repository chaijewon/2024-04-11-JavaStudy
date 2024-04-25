/*
 *   7. 임의의 문자 5개를 저장하고 정렬해서 출력하시오 
       A C D H J
     A C D H J
     J H D C A

 */

import java.util.*;
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[] alpha=new char[5];
        for(int i=0;i<alpha.length;i++)
        {
        	alpha[i]=(char)((Math.random()*26)+65);
        }
        System.out.println("변경전:");
        System.out.println(Arrays.toString(alpha));
        System.out.println("변경후:");
        Arrays.sort(alpha);//ASC=> 올림차순
        System.out.println(Arrays.toString(alpha));
        for(int i=alpha.length-1;i>=0;i--) // DESC => 내림차순 
        {
        	System.out.print(alpha[i]+" ");
        }
        // => 선택정렬 / 버블정렬 => 이차 for
	}

}

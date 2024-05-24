package com.sist.util;
import java.text.*;
import java.util.*;
public class 라이브러리_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double[] limit={59,60,70,80,90};
        String[] grade={"F","D","C","B","A"};
        
        int[] score=new int[10];
        Random r=new Random();
        for(int i=0;i<score.length;i++)
        {
        	score[i]=r.nextInt(101);
        }
        System.out.println(Arrays.toString(score));
        ChoiceFormat cf=new ChoiceFormat(limit,grade);
        
        for(int i:score)
        {
        	System.out.println(i+":"+cf.format(i));
        }
	}

}

package com.sist.set;
import java.util.*;
public class Set_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(("심청이"+20).hashCode());
        //System.out.println(("심청이"+20).hashCode());
        // 변수값이 같은 경우 => 같은 객체 => hashCode()를 이용해서 처리 
		Set<Integer> set=new HashSet<Integer>();
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			int k=r.nextInt(100)+1;
			set.add(k);
			System.out.print(k+" ");
		}
		//System.out.println("저장된 갯수:"+set.size());
		TreeSet<Integer> set2=new TreeSet<Integer>();
		set2.addAll(set);
		// => 50이상 
		System.out.println("\n====== 50이상 =======");
		
		System.out.println(set2.tailSet(50));
		/*for(int i:set)
		{
			if(i>=50)
				System.out.print(i+" ");
		}*/
		System.out.println("\n====== 50이하 =======");
		System.out.println(set2.headSet(50));
		/*for(int i:set)
		{
			if(i<50)
				System.out.print(i+" ");
		}*/
		
	}

}

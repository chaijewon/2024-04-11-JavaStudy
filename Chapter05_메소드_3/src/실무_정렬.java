import java.util.*;
public class 실무_정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
        for(int i=0;i<arr.length;i++)
        {
        	arr[i]=(int)(Math.random()*100)+1; // 배열 초기화 
        }
        System.out.println("변경 전:");
        for(int i:arr)
        {
        	System.out.print(i+" ");
        }
        Arrays.sort(arr);
        System.out.println("\n변경 후:");
        for(int i:arr)
        {
        	System.out.print(i+" ");
        }
        
        int num=10;
        System.out.println(Integer.toBinaryString(num));
	}

}

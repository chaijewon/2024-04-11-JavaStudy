// 알파벳 10개 난수 => 버블 정렬 (DESC)
// 중복없는 알파벳..
import java.util.*;
public class 중첩_for_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // => 알파벳 10개를 저장 공간을 만든다
		char[] alpha=new char[10];
		// 가독성 => 최적화 
		// => 예약일 
		for(int i=0;i<alpha.length;i++)
		{
			alpha[i]=(char)((Math.random()*26)+65);
			for(int j=0;j<i;j++)
			{
				if(alpha[i]==alpha[j])
				{
					i--;// 원상복귀 
					break;
				}
			}
		}
		System.out.println(Arrays.toString(alpha));
		for(int i=0;i<alpha.length-1;i++)
        {
        	for(int j=0;j<alpha.length-1-i;j++)
        	{
        		// 0 1   1 2  2 3
        		if(alpha[j]>alpha[j+1])
        		{
        			char temp=alpha[j];
        			alpha[j]=alpha[j+1];
        			alpha[j+1]=temp;
        		}
        		
        	}
        }
        System.out.println(Arrays.toString(alpha));
	}

}

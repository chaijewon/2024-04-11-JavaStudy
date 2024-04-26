// 알파벳 10개를 임의로 추출한후에 정렬해서 출력 => ASC/DESC
import java.util.*;
public class 중첩_for_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[] alpha=new char[10];
        for(int i=0;i<alpha.length;i++)
        {
        	alpha[i]=(char)((Math.random()*26)+65);
        }
        System.out.println("정렬 전:");
        System.out.println(Arrays.toString(alpha));
        // ASC => 올림차순 
        for(int i=0;i<alpha.length-1;i++)
        {
        	for(int j=i+1;j<alpha.length;j++)
        	{
        		if(alpha[i]>alpha[j])
        		{
        			char temp=alpha[i];
        			alpha[i]=alpha[j];
        			alpha[j]=temp;
        		}
        	}
        }
        System.out.println(Arrays.toString(alpha));
        // DESC => 내림차순 
        for(int i=0;i<alpha.length-1;i++)
        {
        	for(int j=i+1;j<alpha.length;j++)
        	{
        		if(alpha[i]<alpha[j])
        		{
        			char temp=alpha[i];
        			alpha[i]=alpha[j];
        			alpha[j]=temp;
        		}
        	}
        }
        System.out.println(Arrays.toString(alpha));
	}

}

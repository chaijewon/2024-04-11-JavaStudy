/*
 *   6. 0~9사이의 난수를 100개 발생해서 
   빈도를 구해서 출력하시오 
   예)
   0의 개수: 1
   1의 개수: 1
   ..
   9의 개수: 0
   
   arr[0] => ++
   arr[1] => ++
   arr[2]

 */
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr=new int[100];
        for(int i=0;i<arr.length;i++)
        {
        	arr[i]=(int)(Math.random()*10);//0~9
        }
        
        int[] result=new int[10];
        for(int i=0;i<arr.length;i++)
        {
        	result[arr[i]]++;
        }
        
        // 출력
        for(int i=0;i<result.length;i++)
        {
        	System.out.println(i+"=>"+result[i]);
        }
	}

}

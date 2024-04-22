// 빈도수 => 0,1 
public class 자바제어문_반복문_10 {
    /*
     *    int i=1;
     *    while(i<=5)
     *    {
     *       System.out.println(i);
     *       i++;
     *    }
     *    
     *    i=1 i<=5 i출력 i++
     *    i=2 i<=5 i출력 i++
     *    i=3 i<=5 i출력 i++
     *    i=4 i<=5 i출력 i++
     *    i=5 i<=5 i출력 i++
     *    
     *    i=6 i<=5 => 종료
     *       ------ false => 종료 
     *    
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 0,1의 갯수 
		int cnt0=0;
		int cnt1=0;
		int i=1;
		while(i<=100)
		{
			//// 반복 문장 => 난수 발생 => 0,1
			int num=(int)(Math.random()*2);
			if(num==0)
				cnt0++;
			if(num==1)
				cnt1++;
			i++;
		}
		System.out.println("0이 나올 경우:"+cnt0);
		System.out.println("1이 나올 경우:"+cnt1);
	}

}

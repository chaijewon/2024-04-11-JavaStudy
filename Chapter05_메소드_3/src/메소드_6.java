/*
 *    5개 정수 => 넘겨주면 => 정렬 
 *                         ASC (올림차순)
 *                         DESC (내림차순) 
 *    = 선택정렬 : 1개를 선택해서 변경 
 *    = 버블정렬 : 인접한 데이터끼리 변경 
 *    ----------------------------- sort reserve , 오라클 : ORDER BY 
 *    .. 로직 (프로그램 => 2차 for)
 *    
 *    1) 이차 for    | false일 경우 => 종료
 *            1 ==> 2
 *       for(초기값;조건식;증가식)
 *       {          | true일 경우
 *       -----------------------------
 *                     | ==> 1차 for 증가식으로 이동
 *                     |false  --------
 *               1 ==> 2  <==|       |
 *          for(초기값;조건식;증가식)    |
 *          {          | true        |
 *                     |             |
 *              반복 출력 문장 -------- 
 *          }
 *        ----------------------------
 *       }
 *       
 *       예)
 *           for(int i=1;i<=5;i++)
 *           {
 *              for(int j=1;j<=5;j++)
 *              {
 *                  반복 출력 문장 => 25번 
 *              }
 *           }
 *           
 *           i=1  i<=5 ------------ j=1 j<=5 문장수행 j++
 *                false면 종료       j=2 j<=5 문장수행 j++
 *                                 j=3 j<=5 문장수행 j++
 *                                 j=4 j<=5 문장수행 j++
 *                                 j=5 j<=5 문장수행 j++
 *                                 -------------------- i++
 *           i=2  i<=5 ------------ j=1 j<=5 문장수행 j++
 *                false면 종료       j=2 j<=5 문장수행 j++
 *                                 j=3 j<=5 문장수행 j++
 *                                 j=4 j<=5 문장수행 j++
 *                                 j=5 j<=5 문장수행 j++
 *                                 -------------------- i++
 *           i=3 i<=5 ------------ j=1 j<=5 문장수행 j++
 *                false면 종료       j=2 j<=5 문장수행 j++
 *                                 j=3 j<=5 문장수행 j++
 *                                 j=4 j<=5 문장수행 j++
 *                                 j=5 j<=5 문장수행 j++
 *                                 -------------------- i++
 *           i=4 i<=5 ------------ j=1 j<=5 문장수행 j++
 *                false면 종료       j=2 j<=5 문장수행 j++
 *                                 j=3 j<=5 문장수행 j++
 *                                 j=4 j<=5 문장수행 j++
 *                                 j=5 j<=5 문장수행 j++
 *                                 -------------------- i++
 *           i=5 i<=5 ------------ j=1 j<=5 문장수행 j++
 *                false면 종료       j=2 j<=5 문장수행 j++
 *                                 j=3 j<=5 문장수행 j++
 *                                 j=4 j<=5 문장수행 j++
 *                                 j=5 j<=5 문장수행 j++
 *                                 -------------------- i++
 *           i=6 i<=5false => for전체 종료 
 *      선택 정렬 => 앞에서부터 => 고정 
 *      -------
 *       i  i+1
 *       30 20 40 10 50
 *       == ==
 *       20 30
 *       ==    ==
 *       20    40
 *       ==       ==
 *       10       20
 *       ==          ==
 *       10          50
 *       --------------------------- for 한바쿼
 *       10 30 40 20 50 
 *       -- == ==
 *          30 40
 *          ==    ==
 *          20    30 
 *          ==       ==
 *          20       50
 *       ---------------------------- for (2)
 *       10 20 40 30 50
 *       ----- == ==
 *             30 40 50
 *             ==    ==
 *             30    50
 *       ---------------------------- for (3)
 *       10 20 30 40 50
 *       -------- == ==
 *                40 50
 *       ---------------------------- for (4)
 *       10 20 30 40 50 
 *                   --
 *       
 */
public class 메소드_6 {
    static int[] sort(String type,int[] arr)
    {
    	boolean bCheck=false;
    	for(int i=0;i<arr.length-1;i++)
        {
        	for(int j=i+1;j<arr.length;j++)
        	{
        		if(type.equals("DESC"))
        			bCheck=arr[i]<arr[j];
        		else
        			bCheck=arr[i]>arr[j];
        			
        		if(bCheck)
        		{
        			int temp=arr[i];
        			arr[i]=arr[j];
        			arr[j]=temp;
        		}
        	}
        }
    	return arr;//  정렬된 배열을 전송 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr=new int[5];
        for(int i=0;i<arr.length;i++)
        {
        	// 초기화 
        	arr[i]=(int)(Math.random()*100)+1;
        }
        System.out.println("===== 변경 전 =====");
        for(int i:arr) // for-each구문 (출력 전용) => Front-End
        {
        	System.out.print(i+" ");
        }
        System.out.println("\n===== 변경 후 =====");
        arr=sort("DESC",arr);
        for(int i:arr) // for-each구문 (출력 전용) => Front-End
        {
        	System.out.print(i+" ");
        }
        System.out.println();
        arr=sort("ASC",arr);
        for(int i:arr) // for-each구문 (출력 전용) => Front-End
        {
        	System.out.print(i+" ");
        }
        
	}

}

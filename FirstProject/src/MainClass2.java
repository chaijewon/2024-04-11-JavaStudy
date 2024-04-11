// 출력 형식 
/*
 *    = System.out.println()
 *                     ===== ln() => new Line
 *      System.out.println("Hello ")
 *      System.out.println("Java")
 *      Hello
 *      Java
 *    = System.out.print() ==> 옆으로 출력 
 *      System.out.print("Hello ")
 *      System.out.print("Java")
 *      Hello Java
 *    = System.out.printf()
 *      서식이 있는 출력 
 *      %d => 정수
 *      %f => 실수 
 *      %c => 문자
 *      %s => 문자열 
 *    = 자바에서 표현법
 *      정수표현법 
 *         = 10진법(0~9)  10 , 20 .....  
 *         = 8진법(0~7)   010
 *                       -
 *         = 16진법  -> 0x10 => 16
 *                     -- ===========> 색상 
 *         = 2진법   -> 0b10
 *                     --
 *         ==================================
 *            10  ,  10L => 64bit long
 *            int
 *            => 32bit 
 *      실수표현법   => 10.5 , 10.5F
 *                   -----  ------ 32bit (4byte)  1byte=>8bit
 *                   저장하는 메모리 크기 => 64bit
 *      문자표현법   => 'A' => 한글자만 사용이 가능 
 *      문자열표현법 => "Hello" => 여러 문자 사용이 가능 
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println("\"홍길동\""); // "홍길동" => 명령문이 종료하는 반드시 ;
        //System.out.println("c:\\javaDev\\movie.txt");
		// 홍길동  
		// 남자  
		//System.out.println("홍길동\n남자");
        // 홍길동 남자 26
		//System.out.print("홍길동\t");
		//System.out.print("남자\t");
		//System.out.print("26");
		/*
		 *   ★
		 *   ★★
		 *   ★★★
		 *   ★★★★
		 *   ★★★★★
		 *   
		 *   *
		 *   ** 
		 *   ***
		 *   ****
		 *   *****
		 *   i     j     i=j  ==>j=i
		 *   줄수  별표
		 *   1     1
		 *   2     2
		 *   3     3
		 *   4     4
		 *   5     5 
		 *   
		 *    i    j     ==> 역순이면 +
		 *   줄수  별표
		 *    1    5    i+j=6  ==> j=6-i
		 *    2    4
		 *    3    3
		 *    4    2
		 *    5    1
		 *   
		 */
		/*for(int i=0;i<=5;i++)
		{
			for(int j=0;j<=5-i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}*/
		System.out.println("10 20 30 40 50");
		System.out.printf("%-3d%-3d%-3d%-3d%-3d",10,20,30,40,50);
		// ooo
		//  10 => +
		// 10  => -
		
	}

}

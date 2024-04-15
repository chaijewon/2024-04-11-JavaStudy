/*
 *   단항연산자 
 *     =증감연산자 : ++ , -- => 1개 증가,1개 감소
 *      int a=10;
 *      a++  ==> (a+1) ==> 11
 *      int a=10;
 *      a--  ==> (a-1) ==> 9
 *      
 *       ==>  전치 연산 : 먼저 증가후에 대입  
 *            ++a 
 *            --a
 *       ==>  후치 연산 : 대입후에 나중에 증가 
 *            a++
 *            a-- 
 *            
 *       int a=10;
 *       int b  =  ++a;
 *                 --
 *                  1
 *              --
 *              2
 *       1) a값을 증가 
 *       2) 증가값을 b에 대입
 *       --------------------- a=11 , b=11
 *       int a=10;
 *       int b  =  a++;
 *              --  ---
 *               1   2
 *       1) a값을 b에 대입 
 *       2) a값 1개 증가 
 *       ** a는 전치/후치 상관없이 무조건 1개 증가 
 *       --------------------- a=11 , b=10
 *       
 *       1) 예제
 *          int a=10;
 *          int b=++a + ++a + a++  
 *                ---   ---   ---
 *                 11    12   12 => 35
 *          a=> 13
 *          b=> 35
 *          
 *          int a=10;
 *                  => a+1   a+1
 *          int b= a++ + a++ + a++;
 *                 ---   ---   ---
 *                  10   11     12 => 33
 *          
 *          int a=10;
 *          int b= ++a + ++a + ++a 
 *                  11    12    13  ==> 36
 *                  
 *          int a=10;
 *                     a+1
 *          int b= a++ + ++a + a++
 *                 ---   ----  ---
 *                 10     12    12
 *          => 누적 , 제어문 (반복문) , 총알 
 *          
 *          int a=10;
 *          int b=++a => 먼저 증가 나중에 대입 
 *                --
 *                1
 *               --
 *               2   => a=11 , b=11
 *          
 *          int a=10;
 *          int b=a++ => 대입후에 나중에 증가 
 *              ---
 *               1
 *                ---
 *                 2  => a=11 , b=10
 *          
 *          
 *     =부정연산자
 *     =형변환연산자 => boolean제외 
 */
public class 연산자_단항연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int a=10; int b= ++a + ++a + a++; System.out.println("a="+a+",b="+b);
		 */
		int a=10;
		a++;
		a++;
		a++;
		System.out.println("a="+a); //3번 증가(1씩) 
		
		int b=10;
		b--; // b-1 = 9
		b--; // b-1 = 8
		b--; // b-1 = 7
		System.out.println("b="+b);
		
		int c=10;
		++c;
		++c;
		++c;
		System.out.println("c="+c);
		
		int d=10;
		--d;
		--d;
		--d;
		System.out.println("d="+d);
	}

}

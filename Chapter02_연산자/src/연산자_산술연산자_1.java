/*
 *    + 
 *    ---
 *     1) 산술연산자 (더하기 연산자)
 *        10+10=20 
 *     2) 문자열 결합 
 *        "7"+7 ==> "77"
 *        7+"7" ==> "77"
 *        7+7+"7" ==> "147"
 *        ---
 *         1 
 *           ---
 *            2
 *        14+"7"
 *        
 *        7+"7"+7+7
 *        -----
 *         "77"
 *             +7
 *         -------
 *           "777"
 *             -----
 *             "7777"
 *         7+"7"+7*7 ==> "7749"
 *               ---
 *                1
 *         -----
 *           2
 *             ------
 *                3
 *        ===> () => 우선순위 변경 
 *        / => 정수/정수 = 정수 
 *        % => 나머지는 왼쪽 부호를 따라간다 
 *        *** 같은 데이터형끼리 연산이 된다 
 *        int + long 
 *        ---
 *        long 
 *        => long+long 
 *        
 *        double + int 
 *                 ---
 *                 double 
 *        => double + double = double 
 *        => 최종 결과값은 가장 큰 데이터형을 결과값으로 처리된다 
 */
public class 연산자_산술연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // char + int 
		char c='A';
		int i=10;
		System.out.println(c+i);
		//     c=65 => 연산 
		// double + int => double 
		double d=10.5;
		System.out.println(d+i);
		//       i=10.0
		
		// byte + byte = int 
		byte b1=10;
		byte b2=20;
		int b3=b1+b2; // int이하 데이터형은 연산 결과는 int 
		System.out.println(b3);
		
		// char + char = int 
		char c1='A';
		char c2='B';
		int c3=c1+c2;
		System.out.println(c3);
		
		// char + byte + double + float => double
		char d1='A'; //65
		byte d2=100;
		double d3=10.5;
		float d4=10.5F;
		System.out.println(d1+d2+d3+d4);
		// int + long + float => float 
		int e1=100;
		long e2=100L;
		float e3=10.5F;
		System.out.println(e1+e2+e3);
		// byte < char < int < long < float < double
		// 자동 변경 => 데이터형이 다른 경우 
	}

}

/*
 *    논리연산자 ==> 결과값은 true/false 
 *    && => 직렬연산자 => 범위,기간 포함 
 *          jumsu>=0 && jumsu<=100  0~100사이에 있는지 
 *    || => 병렬연산자 => 범위,기간을 벗어난 경우 
 *          jumsu<0 || jumsu>100 ==> 오류처리 
 *    
 *    false    ==> false
 *    (조건) && (조건)
 *    ----     ----
 *      |       |
 *      ---------
 *          |
 *        결과값 
 *     true   ==> true ==> 최적화 연산 
 *    (조건) || (조건)
 *    ----     ----
 *      |       |
 *      ---------
 *          |
 *        결과값 
 *        
 *     -------------------------------------
 *                      &&          ||
 *     -------------------------------------
 *      true true      true         true
 *     -------------------------------------
 *      true false     false        true
 *     -------------------------------------
 *      false true     false        true
 *     -------------------------------------
 *      false false    false       false 
 *     -------------------------------------
 *     
 *      
 */
public class 연산자_논리연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int x=10;
        int y=9;
        
        boolean bCheck= x==y && ++y==x;
        //              ---- false 
        //                   ||
        //              ---- true => 효율적인 연산 
        System.out.println("bCheck="+bCheck);
        System.out.println("x="+x);
        System.out.println("y="+y);
	}

}

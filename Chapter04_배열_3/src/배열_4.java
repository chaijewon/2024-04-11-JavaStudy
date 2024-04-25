// 1. 배열의 범위를 벗어나면 => 오류 발생 => 0번 ~ 갯수-1
// 2. 프로그래머의 실수가 가장 많은 곳 => 실행시에 오류발생 
// => ArrayIndexOutOfBoundsException => 93page => 크롤링 
/*
 *  영화 => 2000  => [2000] => 1936 => 가변 => List
 */
/*
 *   에러 => 에러 처리 
 */
public class 배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {1,2};
        // 0,1
        System.out.println(arr[2]);
	}

}

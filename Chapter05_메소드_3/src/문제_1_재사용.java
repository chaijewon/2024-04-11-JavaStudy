
public class 문제_1_재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num=문제_1.input();
        // num=>이진법 제작 메소드로 전송 
        int[] binary=문제_1.binaryCheck(num);
        // binary[]을 넘겨준다 => 출력 요청 
        문제_1.print(binary);
	}

}

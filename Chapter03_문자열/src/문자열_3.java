
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String msg="Hello Java";
        System.out.println(msg.replace("a", "b"));
        msg="홍길동 Hong Gil Dong";
        System.out.println(msg.replaceAll("[A-Za-z]",""));
        // 한글 => [가-힣]
        // 알파벳 => [A-Z] [a-z]
        // 숫자 => [0-9] =>  크롤링 
	}

}

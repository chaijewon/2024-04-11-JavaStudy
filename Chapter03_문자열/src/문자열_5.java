// 자몽:grapefruit
public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String f="자몽:grapefruit";
        System.out.println("자몽의 영어는?");
        System.out.println("영어는 "+f.substring(f.indexOf(":")+1));
        
        /*
         *  substring : 문자열을 자르는 경우에 사용
         *  Hello Java
         *  0123456789
         *  substring(1) => 
         *  substring(3,8)
         *  substring(int startIndex)
         *  substring(int startIndex,int endIndex) 
         *                           => endIndex-1
         */
        String msg="Hello Java";
        System.out.println(msg.substring(0,7)+"...");
        // 
	}

}

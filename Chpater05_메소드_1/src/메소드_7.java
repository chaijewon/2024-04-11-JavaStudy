// char 리턴 ==> 알파벳을 전송 => 대문자 => 소문자 , 소문자 => 대문자 
public class 메소드_7 {
    static char upper(char c)
    {
    	return (char)(c-32); // 'a' => 'A' 
    	//                      97     65   => 32
    }
    static char lower(char c)
    {
    	return (char)(c+32);
    }
    static char upperLower(char c)
    {
    	char res=' ';// 결과값이 여러개인 경우 => 변수 => 경우 수 
    	if(c>='A' && c<='Z')
    		res=(char)(c+32);
    	else 
    		res=(char)(c-32);
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*char c=upper('m');
        System.out.println(c);
        c=lower('M');
        System.out.println(c);*/
		char c=upperLower('A');
		System.out.println(c);
		c=upperLower('a');
		System.out.println(c);
        // 메소드명 => 기능 
		// 매개변수 => 리턴형 
		// 70% => 암기 , 30% 조립 
	}

}

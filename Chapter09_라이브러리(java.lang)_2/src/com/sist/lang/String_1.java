package com.sist.lang;
/*
 *   String : 문자열 관리 => char[]을 제어 
 *            => 오버라이딩이 불가능하다 (제공한 그대로 사용한다) 
 *            => 종단 클래스 (final) => 상속이 불가능한 클래스 
 *               ----------------
 *               Math,System,StringBuffer,Wrapper 
 *            => 암기용 
 *   => String에 문자열을 저장하는 방법 
 *      일반 기본형처럼 사용
 *      String s="";  => 일반 데이터형처럼 사용하는 기본이다 ...
 *      객체 생성 
 *      String s=new String("") => 한글 코드 변환 
 *      *** 문자열은 자체가 메모리 주소 
 *          -------------------
 *          "Hello" => 메모리 주소  => {'H','e'....}
 *      String s1="Hello"
 *      String s2="Hello" 
 *      
 *      s1==s2 => 같다 ======> ==는 메모리 주소값을 비교 
 *                           equals() : 실제 저장된 문자열을 비교 
 *                           
 *   => 기능 (메소드)
 *      1. public char charAt(int index) : 원하는 위치의 문자 한개를 가지고 올때 사용 
 *         문자열은 char[] => index번호는 0번부터 시작한다 
 *         "Hello Java"
 *          0123456789
 *          
 *          chatAt(6) ==> 'J'
 *       ***2. length() : 문자의 갯수를 가지고 온다 
 *          => public int lenght()
 *          => "Hello Java" 
 *              0123456789  => 10 => 영문 / 한글 => 글자수 (공백을 포함한다) 
 *                                                     --- space문자 
 *          => ..., 비밀번호확인 / MMS
 *       3. toUpperCase() / toLowerCase()
 *          대문자변환 / 소문자변환 
 *          public String toUpperCase()
 *          public String toLowerCase()
 *          => 한글 사용 
 *       ------------------------------------------
 *       검색 
 *       4. startsWith() : 시각문자열이 같은 경우
 *          public boolean startsWith(String start)
 *           => 서제스트를 만드는 경우에 주로 사용 
 *              ------ 자동완성기 
 *           => cookie저장 => cookie 읽기 
 *              => 문자열만 저장이 가능 
 *              => 방문 맛집 , 레시피 
 *                 ------   ----
 *                 food_    recipe_
 *           => ^A (정규식) => A% (오라클)
 *              --- CSS
 *              img[src^='http']
 *       5. endsWith(): 끝나는 문자열이 같은 경우 
 *          public boolean endsWith(String end)
 *          => 확장자 찾기 
 *          => 그림파일 => gif / jpg / png / bmp ....
 *          => A$ (정규식) => %A (오라클)
 *          => img[src$='jpg|gif|png']
 *       ***6. contains(): 포함된 단어 
 *          => 검색 
 *          public boolean contains(String s)
 *          => 사이트에 나오는 모든 검색 
 *          => [A](정규식) , %A%(오라클)
 *          => img[src*='A']
 *       ***7. equals() : 문자열이 같을 때
 *          public boolean equals(String s)
 *          => 주로 사용 : 로그인 , 아이디 찾기 , 비밀번호 
 *          ** equalsIgnoreCase()
 *          ** equals() , equalsIgnoreCase()
 *             --------   ------------------
 *                        | 대소문자를 구분하지 않는다 (검색)
 *             | 대소문자를 구분 (로그인 , 아이디찾기..)
 *       ***8. indexOf() : 앞에서부터 찾기 (일반문자열)
 *             public int indexOf(찾는 문자,찾는 문자열)
 *       ***9. lastIndexOf() : 뒤에서부터 찾기 (경로명 , 확장자)
 *             public int lastIndexOf(찾는 문자,찾는 문자열)
 *       변경 
 *       ***10. replace() : 문자나 문자열을 변경할때 사용 
 *              => 크롤링 => 오라클에 저장할때 자주 사용 
 *                 ------------
 *                  => || , & ... ==> 이미지가 있는 경우 
 *                     --   --
 *                          Scanner
 *                     문자열 결합 
 *              => 오버로딩 
 *              public String replace(char c1,char c2)
 *                                    ------- --------
 *                                             변경할 문자
 *                                    변경해야되는 문자(대상)
 *              public String replace(String s1,String s2)
 *       ***11. replaceAll(): 정규식 이용 => 빅데이터 
 *                           ------ 문자 형태 
 *              맛있다 맜있고 맛있는 ... 
 *              맛있+
 *              데이터 
 *              ----- 
 *                = 정형화된 데이터 => 프로그램에 필요한 데이터만 수집 (데이터베이스안에 저장)
 *                = 반정형화 데이터 => 구분 => HTML/XML/JSON
 *                = 비정형화 데이터 => 구분이 없는 데이터 (트위터 , facebook) 
 *                  ----------> 정형화 (빅데이터) => 통계 , 분석 
 *              public String replaceAll(String regex,String 변경문자열)
 *              
 *              ABCDEFG한글입니다 
 *              [A-Z], ""
 *              [가-힣],""
 *              [0-9],""
 *        ***12. substring() : 문자열을 자르는 경우에 사용 
 *               public String substring(int start)
 *               "Hello Java"
 *                      ----
 *                0123456789
 *                      ----  6
 *               public String substring(int start,int end) => end는 포함이 안된다 
 *               "Hello Java"
 *                  ---
 *                0123456789
 *                  ---
 *                ******* end-1 
 *         ***13. valueOf() : 모든 데이터형을 문자열로 변환 
 *                public static String valueOf(Object o)
 *                       -------
 *                public static String valueOf(int o)
 *                public static String valueOf(double o)
 *                public static String valueOf(float o)
 *                public static String valueOf(boolean o)
 *                
 *         => String s="Hello Java";
 *            s.length()
 *            s.substring()...
 *            String.valueOf(10) => "10"
 *         ****** 웹은 모든 데이터가 String,윈도우 String 
 *                입력창 : JTextField 
 *                        ----
 *                      <input type=text>
 *                      "10" => 변경이 가능하게 클래스를 지원 => Wrapper 
 *                      
 *         ***14. split() => 구분자별로 문자열을 잘라서 배열에 저장 
 *            public String[] split(String regex) => 정규식을 이용한다 
 *         ***15. trim() => 좌우의 공백 제거 
 *            public String trim()
 *         ------------------------------------------- 자바스크립트가 동일 
 *       
 */
public class String_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 문자열 저장 공간 만들기 
		String s1="Hello";
		String s2="Hello"; 
		// 같은 문장열 다른 메모리에 저장한다 
		String s3=new String("Hello");
		if(s1==s2) // ==는 객체일때 => 메모리 주소값을 비교한다 => 실제 문자열만 비교할때는 equals
		{
			System.out.println("s1와 s2는 같다");
		}
		else
		{
			System.out.println("s1과 s2는 다르다");
		}
		if(s1==s3)
		{
			System.out.println("s1와 s3는 같다");
		}
		else
		{
			System.out.println("s1과 s3는 다르다");
		}
	}

}

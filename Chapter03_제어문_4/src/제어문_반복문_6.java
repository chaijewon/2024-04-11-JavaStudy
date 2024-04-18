
public class 제어문_반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1. A~Z까지 출력 
		for(char c='A';c<='Z';c++) // c+=2 , c+=3....
		{
			System.out.print(c+" ");// -----  
			/*
			 *  System.out.println(c+" ");
			 *  --
			 *  --
			 *  --
			 */
		}
		System.out.println();// 다음 줄에 출력 
		for(char c='a';c<='z';c++)
		{
			System.out.print(c+" ");
		}
		// 정수 / 문자 
		System.out.println();
		for(char c='Z';c>='A';c--)
		{
			System.out.print(c+" ");
		}
	}

}

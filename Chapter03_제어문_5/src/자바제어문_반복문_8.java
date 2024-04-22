
public class 자바제어문_반복문_8 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char c='A';
		// 설정하는 변수=> for안에서만 가능 
		// 변수 => 범위지정 => {} => scope => 사용범위 => 결과값 추출이 가능 
        for(int i=1;i<=5;i++)
        {
        
        	char c='A'; // for => 1: 생성 => 2: c삭제 => 생성 
        	
        	System.out.print(c+" ");
        	c++;
        	//c변수는 여기까지만 사용이 가능
        }// c변수는 사라진다 
	}

}

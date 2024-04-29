// 매개변수 => 메소드안에 사용이 가능 => 지역변수 
// 메소드 호출시에 메모리 저장 => 메소드 종료되는 자동으로 해제가 된다 
public class 메소드_3 {
	//static int i=1;// 전역변수 => 프로그램 종료시에 메모리 해제 
    static void increment()// 호출시마다 => 변수는 자동 삭제 => 다시 생성 
    {
    	// 지역변수 우선순위 
    	int i=1; // 지역변수 
    	System.out.println("i="+i);
    	++i;
    	
    	// 밤색 => 지역변수 
    	// 파란색 => 클래스 변수 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        increment(); // {} => 선언된 모든 변수는 메모리에서 사라진다 (지역변수)
        increment();
        increment();
	}

}

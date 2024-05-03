/*
 *    class ClassName
 *    {
 *      -------------------
 *      
 *      -------------------
 *      
 *      -------------------
 *        int a;
 *        void display()
 *        {
 *           ----------
 *            변수 선언 => 지역변수  => 메소드가 종료하면 사라진다 => 사용하려면 리턴형 
 *            int a=100;
 *           ----------
 *           
 *           
 *        }
 *        void print()
 *        {
 *           
 *        }
 *      -------------------
 *    }
 */
import java.util.*;
class Sawon{
	String name;
	String dept;
	String loc;
	String job;
	int pay;
}
public class 멤버변수_초기화_활용 {
    // 사원 등록 
	static Sawon s=new Sawon();
	static void sawonInsert()
	{
		//Sawon s=new Sawon();// 지역변수 
		s.name="홍길동";
		s.dept="개발부";
		s.loc="서울";
		s.job="대리";
		s.pay=3600;
	   
	}
	// 사원 목록 
	static void sawonList()
	{
		
		System.out.println("이름:"+s.name);
		
	}
	// 사원 상세 보기 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        sawonInsert();// Sawon => s는 사라진다
        sawonList();
	}

}

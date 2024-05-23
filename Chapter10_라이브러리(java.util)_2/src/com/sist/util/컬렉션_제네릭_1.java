package com.sist.util;
/*
 *   제네릭 
 *   ClassName<클래스명>
 *            -------- Object => 클래스명으로 변경한다 
 *   A<Integer> 
 *      
 *      = 데이터형을 통일화 : 리턴형 / 매개변수를 한번 변경 => 프로그램에 맞게 => 변경해서 사용 
 *      = ArrayList는 이미 만들어져 있는 상태 
 *                   ------------------
 *                    프로그래머가 어떤 데이터를 저장해서 사용할 지 모른다 
 *                    ------------------------------------- 아무 데이터나 관리 => Object
 *                    리턴형 / 매개변수 => Object
 *                    => Object일때 데이터 사용시 => 형변환을 하고 사용 
 *      = 소스가 간결해진다(형변환을 하지 않는다) 
 *      = 가독성 => 어떤 데이터를 저장했는지 확인이 가능 
 *      = 컬렉션에서 주로 사용 
 *      
 *      = ArrayList => ArrayList<String>
 *      = ArrayList<Music>
 *      = ArrayList<Movie>
 *      
 *      ---------------------------------------------------------
 *      데이터형을 변경할 수 있는 제네릭 
 *      <T> type => class 
 *      <E> element => class
 *      <K> <V> => value 
 *      --- key
 *      
 *      class Box<T>
 *      {
 *         T t;
 *         public void setT(T t)
 *         {
 *            this.t=t;
 *         }
 *         public T getT()
 *         {
 *             return t;
 *         }
 *      }
 *      
 *      ==> Box box=new Box() => T(Object)
 *      ==> Box<String> box=new Box<String>()
 *        T => String
 */
class Box<E>
{
	E e;
	public void setE(E e)
	{
		this.e=e;
	}
	public E getE()
	{
		return e;
	}
}
public class 컬렉션_제네릭_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Box<String> box=new Box<String>();
        // E=>String
        
	}

}

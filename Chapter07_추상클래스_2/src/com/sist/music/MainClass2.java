package com.sist.music;
class A
{
	private void disp() {
		System.out.println("A:disp() Call...");
	}
}
class B extends A
{
	public void disp() {
		System.out.println("B:disp() Call...");
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new B();
        
	}

}

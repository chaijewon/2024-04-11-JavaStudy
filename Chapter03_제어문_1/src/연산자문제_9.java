/*
 *  int num1 = 2;
    int num2 = 7;
    int num3; 
    int num4; 
    num1++; // 증가안됨 
    // num1=3
    num3 = --num1; // num3=2
    --num2; // num2=6
    num4 = num2++; // num4=6
    System.out.printf("%d\n", num3);//2
    System.out.printf("%d\n", num4);//6

 */
public class 연산자문제_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 2;
	    int num2 = 7;
	    int num3; 
	    int num4; 
	    num1++; // 증가안됨 
	    // num1=3
	    num3 = --num1; // num3=2
	    --num2; // num2=6
	    num4 = num2++; // num4=6
	    System.out.printf("%d\n", ++num3);//2
	    System.out.printf("%d\n", num4);//6
	}

}

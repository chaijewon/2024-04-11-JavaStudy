/*
 * 9.	1~1000까지에서 7의 배수의 합 ,9의 배수의 합
 */
public class 문제_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum7=0;
        int sum9=0;
        for(int i=1;i<=1000;i++)
        {
        	if(i%7==0)
        		sum7+=i;
        	if(i%9==0)
        		sum9+=i;
        }
        System.out.println("1~1000까지에서 7의 배수의 합:"+sum7);
        System.out.println("1~1000까지에서 9의 배수의 합:"+sum9);
        
        System.out.println("====== while ======");
        sum7=0;
        sum9=0;
        int i=1;
        while(i<=1000)
        {
        	if(i%7==0)
        		sum7+=i;
        	if(i%9==0)
        		sum9+=i;
        	i++;
        }
        System.out.println("1~1000까지에서 7의 배수의 합:"+sum7);
        System.out.println("1~1000까지에서 9의 배수의 합:"+sum9);
        
        System.out.println("========== do~while =======");
        sum7=0;
        sum9=0;
        i=1;
        do
        {
        	if(i%7==0)
        		sum7+=i;
        	if(i%9==0)
        		sum9+=i;
        	i++;
        }while(i<=1000);
        System.out.println("1~1000까지에서 7의 배수의 합:"+sum7);
        System.out.println("1~1000까지에서 9의 배수의 합:"+sum9);
        
	}

}

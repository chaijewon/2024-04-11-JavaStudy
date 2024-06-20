package com.sist.client;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String msg="커피세레모니(COFFEE CEREMONY)";
        int a=msg.indexOf("(");
        if(a>0)
        {
        	System.out.println(msg.substring(0,msg.indexOf("("))+"\n"+msg.substring(msg.lastIndexOf("(")));
        }
        else
        {
        	System.out.println(msg);
        }
	}

}

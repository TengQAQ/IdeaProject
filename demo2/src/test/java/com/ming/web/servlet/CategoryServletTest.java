package com.ming.web.servlet;

import static org.junit.Assert.*;

public class CategoryServletTest {
	public static String output="";

	public static void foo(int i){
		try{
			if(i==1){
				throw new Exception();
			}
			output += "1";
		}catch(Exception e){
			output +="2";
			return;
		}finally{
			output+="3";
		}
		output +="4";
	}

	public static void main(String[] args){
		foo(0);
		foo(1);
		System.out.println(output);
		String a = "5";
		a += 1;
		a += 3;
		System.out.println(a);
	}

}
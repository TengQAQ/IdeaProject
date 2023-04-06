package com.ming.util;


import java.util.Arrays;

public interface toIntArray {

	public default int[] toIntArray(String[] chars) {
		int[] ints= new int[chars.length];
		//把字符创数组转为数字数组
		for(int i=0;i<chars.length;i++){
			ints[i]=Integer.parseInt(chars[i]);
		}
		return Arrays.copyOfRange(ints,1,ints.length-1);
	}
}

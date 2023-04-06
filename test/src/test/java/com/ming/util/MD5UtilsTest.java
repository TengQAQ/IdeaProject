package com.ming.util;

import junit.framework.TestCase;

public class MD5UtilsTest extends TestCase {

	public void testGetSaltMD5() {
		String saltMD5 = MD5Utils.getSaltMD5("123456");
		System.out.println(saltMD5);
	}

	public void testGetSaltverifyMD5() {
	}
}
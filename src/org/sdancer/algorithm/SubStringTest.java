package org.sdancer.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubStringTest {

	@Test
	public void testSubstring() {
		SubString sub = new SubString();
		boolean res = sub.substring("foo", "oo");
		assertEquals("res",res,true);
		
		res = sub.substring("AAAATTTTAAAAA", "TTTAAATT");
		assertEquals("res",res,false);
	}
	
	

}

package org.sdancer.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestMonoIncSubTest {

	@Test
	public void test() {
		int[] num = {1,5,8,2,3,4};
		LongestMonoIncSub s = new LongestMonoIncSub(num);
		int len = s.getMaxLength();
		assertEquals("Max Length",len,4);
	}

}

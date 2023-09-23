package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test
	void test() {
//		fail("Not yet implemented");
		MyMath myMat = new MyMath();
		int[] nums = { 1, 2, 3 };
		int result = myMat.calculateSum(nums);
		int expectedAssert = 6;
		assertEquals(expectedAssert, result);
	}

}

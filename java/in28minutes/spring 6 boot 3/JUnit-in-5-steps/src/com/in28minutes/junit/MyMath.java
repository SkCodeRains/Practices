package com.in28minutes.junit;

public class MyMath {

	public MyMath() {
		// TODO Auto-generated constructor stub
	}

	public int calculateSum(int[] numbers) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}

}

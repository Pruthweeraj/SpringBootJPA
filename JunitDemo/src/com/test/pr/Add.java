package com.test.pr;

public class Add {

	public int sum(int[] i) {
		int sum=0;
		for (int j : i) {
			sum= sum + j;
		}
		return sum;
	}
	
}

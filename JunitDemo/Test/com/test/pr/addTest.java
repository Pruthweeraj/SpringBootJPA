package com.test.pr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class addTest {

	Add add = new Add();
	
	@Test
	void test() {
		assertEquals(60, add.sum(new int[] {10,20,30}));
		
	}
	
	@Test
	void test2() {
		assertEquals(174, add.sum(new int[] {144,30}));
		
	}

}

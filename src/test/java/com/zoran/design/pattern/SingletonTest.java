package com.zoran.design.pattern;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void test() {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(":" +(singleton1==singleton2));
		
	}

}

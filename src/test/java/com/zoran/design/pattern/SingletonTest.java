package com.zoran.design.pattern;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void test() {
		Singleton singleton1 = Singleton.getSingleton();
		Singleton singleton2 = Singleton.getSingleton();
		System.out.println(":" +(singleton1==singleton2));
		
	}

}

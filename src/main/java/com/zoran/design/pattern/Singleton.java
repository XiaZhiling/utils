package com.zoran.design.pattern;

public class Singleton {
	
	private static Singleton singleton;
	
	private Singleton() {
		singleton = new Singleton();
	}
	
	public static Singleton getSingleton(){
		return singleton;
	}

}

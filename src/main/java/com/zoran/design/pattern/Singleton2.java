package com.zoran.design.pattern;

/**
 * 单例模式  之懒汉模式
 * 类第一次调用的时候生成实例  后面就不生成了
 *
 */

public class Singleton2 {
	//1.将构造方法私有化,不允许外部直接创建对象
	private Singleton2() {
	}
	
	//2.创建类的唯一实例
	private static Singleton2 instance ;

	//3.提供一个用于获取实例的方法
	public static Singleton2 getInstance() {
		if(instance ==null){
			instance = new Singleton2();
		}
		return instance;
	}

}

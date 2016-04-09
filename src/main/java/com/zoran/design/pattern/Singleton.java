package com.zoran.design.pattern;

/**
 * 单例模式Singleton
 * 应用场景：有些对象只需要一个就足够了
 * 作用：保证整个应用程序中某个实例有且只有一个
 * 类型：饥饿模式  和懒汉模式
 * 
 * 饥饿模式 ：
 * 实例在类加载的时候就已经生成
 * 懒汉模式：Singleton2  
 * 
 * 饥饿模式和懒汉模式的比较
 * 饥饿模式：加载类是比较慢，运行时获取对象比较快，线程安全的
 * 懒汉模式：加载类是比较快，运行时获取对象比较慢，线程不安全的
 */


//饥饿模式
public class Singleton {
	
	//1.将构造方法私有化,不允许外部直接创建对象
	private Singleton() {
	}
	
	//2.创建类的唯一实例
	private static Singleton instance = new Singleton();
	
	
	//3.提供一个用于获取实例的方法
	public static Singleton getInstance(){
		return instance;
	}

}

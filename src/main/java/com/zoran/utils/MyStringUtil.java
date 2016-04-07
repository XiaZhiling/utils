package com.zoran.utils;

public class MyStringUtil {
	
	private static int sequence = 1;
	private static final int ROTATION = 99999;  
	
	/**
	 * 利用String.format同步生成字符串
	 * @param n
	 * @return 范围n位字符  不足补0
	 */
	public static synchronized String getSequence(int n) {
		String format = "%1$0"+n+"d";
		if (sequence > ROTATION) sequence = 1;
		return String.format(format, sequence++);
	}
}

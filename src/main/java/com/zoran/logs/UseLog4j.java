package com.zoran.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UseLog4j {
	
	private static Log logger = LogFactory.getLog(UseLog4j.class);
	
	public static void main(String[] args) {
		logger.debug("Debug");
	}

}

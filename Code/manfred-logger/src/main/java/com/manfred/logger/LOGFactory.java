package com.manfred.logger;

public enum LOGFactory {
	INSTANCE;

	private final Logger logger;

	LOGFactory() {
		logger = new Logger();
	}

	public static LOGFactory getInstance() {
		return INSTANCE;
	}

	public Logger getLogger() {
		return logger;
	}
}
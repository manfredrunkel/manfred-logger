package com.manfred.logger.properties;

import java.util.Properties;

import com.manfred.framework.app.io.properties.PropertiesReader;

public enum LoggerProperties {
	INSTANCE;

	private final LoggerPropertiesData propertiesData;

	private LoggerProperties() {
		Properties readPropertiesFromFile = PropertiesReader.readPropertiesFromFile("logger.properties");
		String applicatonName = (String) readPropertiesFromFile.get("applicationName");
		String loggerURL = (String) readPropertiesFromFile.get("loggerURL");
		propertiesData = new LoggerPropertiesData(applicatonName, loggerURL);
	}

	public static LoggerProperties getInstance() {
		return INSTANCE;
	}

	public LoggerPropertiesData getProperties() {
		return propertiesData;
	}

}

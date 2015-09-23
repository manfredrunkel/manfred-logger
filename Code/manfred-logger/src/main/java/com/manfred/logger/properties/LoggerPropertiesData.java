package com.manfred.logger.properties;

public class LoggerPropertiesData {

	private String applicationName;
	private String loggerURL;

	public LoggerPropertiesData(String applicationName, String loggerURL) {
		super();
		this.applicationName = applicationName;
		this.loggerURL = loggerURL;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getLoggerURL() {
		return loggerURL;
	}

	public void setLoggerURL(String loggerURL) {
		this.loggerURL = loggerURL;
	}

}

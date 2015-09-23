package com.manfred.logger.types;

import com.manfred.framework.app.ApplicationTypes;
import com.manfred.framework.app.LogTypes;
import com.manfred.logger.properties.LoggerProperties;
import com.manfred.logger.properties.LoggerPropertiesData;
import com.manfred.producer.Sender;

public final class LogRemote implements ILogExecute {

	public void log(String message, LogTypes logType) {
		LoggerPropertiesData properties = LoggerProperties.getInstance().getProperties();
		Sender sender = new Sender(message, properties.getApplicationName(), logType, properties.getLoggerURL(),
				ApplicationTypes.APPLICATION);
		Thread thread = new Thread(sender);
		thread.setDaemon(false);
		thread.start();
	}

}

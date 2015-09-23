package com.manfred.logger;

import com.manfred.framework.app.LogTypes;
import com.manfred.logger.types.ILogExecute;
import com.manfred.logger.types.LogRemote;

public class Logger {

	private final ILogExecute logExecution;

	public Logger() {
		logExecution = new LogRemote();
	}

	public void info(String message) {
		logIt(message, LogTypes.INFO);
	}

	public void debug(String message) {
		logIt(message, LogTypes.DEBUG);
	}

	public void warn(String message) {
		logIt(message, LogTypes.WARN);
	}

	public void trace(String message) {
		logIt(message, LogTypes.TRACE);
	}

	private void logIt(String message, LogTypes logType) {
		logExecution.log(message, logType);
	}

}

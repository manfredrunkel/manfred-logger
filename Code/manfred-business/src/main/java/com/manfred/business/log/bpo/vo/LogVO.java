package com.manfred.business.log.bpo.vo;

import java.io.Serializable;
import java.util.Date;

import com.manfred.framework.app.LogTypes;

public class LogVO implements Serializable {

	private static final long serialVersionUID = -147893355403107132L;

	private LogTypes logType;
	private String message;
	private Date executedTime;
	private String application;

	public LogVO(String message, String application, Date executedTime, LogTypes logType) {
		this.message = message;
		this.executedTime = executedTime;
		this.logType = logType;
		this.application = application;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getExecutedTime() {
		return executedTime;
	}

	public void setExecutedTime(Date executedTime) {
		this.executedTime = executedTime;
	}

	public LogTypes getLogType() {
		return logType;
	}

	public void setLogType(LogTypes logType) {
		this.logType = logType;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}
}

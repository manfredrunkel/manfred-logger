package com.manfred.producer.session;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public enum ConnectionManagement {
	INSTANCE;

	private String MESSAGE_PROTOCOL = "tcp";

	private javax.jms.Connection connection;
	private ActiveMQConnectionFactory connectionFactory;
	private boolean started = false;

	private ConnectionManagement() {
		connectionFactory = new ActiveMQConnectionFactory();
	}

	public static ConnectionManagement getActiveConnection() throws JMSException {
		return INSTANCE;
	}

	public javax.jms.Connection getConnection(String url) {
		if (!started) {
			connectionFactory.setBrokerURL(MESSAGE_PROTOCOL + "://" + url);
			try {
				connection = connectionFactory.createConnection();
				connection.start();
				started = true;
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}

package com.manfred.receiver.broker;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public final class BrokerConnection {

	private BrokerConnection() {
	}

	public static Connection getConnection(String port) throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				Broker.MESSAGE_BROKER_URL + ":" + port);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		return connection;
	}

}

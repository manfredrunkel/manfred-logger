package com.manfred.receiver.broker;

import org.apache.activemq.broker.BrokerService;

public final class Broker {

	public static String MESSAGE_BROKER_URL = "tcp://localhost";
	private BrokerService broker = new BrokerService();
	private String port = "61616";

	public Broker(String port) {
		this.port = port;
	}

	public void startBroker() throws Exception {
		broker.setPersistent(true);
		broker.setUseJmx(false);
		broker.addConnector(MESSAGE_BROKER_URL + ":" + port);
		broker.start();
	}
}

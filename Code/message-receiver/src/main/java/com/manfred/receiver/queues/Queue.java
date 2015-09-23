package com.manfred.receiver.queues;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.log4j.Logger;

import com.manfred.framework.app.ApplicationTypes;

public abstract class Queue implements MessageListener, Runnable {

	protected Logger logger = Logger.getLogger("ApplicationQueue");

	protected final Session session;
	protected final ApplicationTypes queueType;
	protected MessageProducer replyProducer;

	public Queue(Session session, ApplicationTypes queueType) {
		this.session = session;
		this.queueType = queueType;
	}

	public void run() {
		try {
			listen();
		} catch (Exception e) {
			System.err.println("Problem occured while trying to instantiate Queue. Error: " + e.getMessage());
		}
	}

	private void listen() throws JMSException {
		Destination adminQueue = this.session.createQueue(queueType.name() + ".>");
		this.replyProducer = this.session.createProducer(null);
		this.replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		MessageConsumer consumer = this.session.createConsumer(adminQueue);
		consumer.setMessageListener(this);
	}

	public abstract void onMessage(Message message);
}
package com.manfred.receiver.queues.custom;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import com.manfred.framework.app.ApplicationTypes;
import com.manfred.receiver.queues.Queue;

public class ECommerceQueue extends Queue implements Runnable {

	public ECommerceQueue(Session session) {
		super(session, ApplicationTypes.ECOMMERCE);
	}

	@Override
	public void onMessage(Message message) {
		try {
			logger.info("Message received. It's Log Ecommerce Message. Id:" + message.getJMSMessageID());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		super.run();
		System.out.println("Ecommerce Queue Started");
	}

}

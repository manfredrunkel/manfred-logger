package com.manfred.producer;

import java.util.Date;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.manfred.business.log.bpo.vo.LogVO;
import com.manfred.framework.app.ApplicationTypes;
import com.manfred.framework.app.LogTypes;
import com.manfred.producer.session.ConnectionManagement;

public class Sender implements Runnable {
	private MessageProducer producer;

	private String message;
	private String appName;
	private LogTypes logType;
	private String url;
	private ApplicationTypes applicationType;

	public Sender(String message, String appName, LogTypes logTypes, String url, ApplicationTypes applicationType) {
		super();
		this.message = message;
		this.appName = appName;
		this.logType = logTypes;
		this.url = url;
		this.applicationType = applicationType;
	}

	public void run() {
		sendMessage();
	}

	public void sendMessage() {

		if (applicationType == null) {
			applicationType = ApplicationTypes.APPLICATION;
		}

		try {
			Connection connection = ConnectionManagement.getActiveConnection().getConnection(url);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination adminQueue = session.createQueue(applicationType + "." + appName);

			this.producer = session.createProducer(adminQueue);
			this.producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			Destination tempDest = session.createTemporaryQueue();
			MessageConsumer responseConsumer = session.createConsumer(tempDest);
			responseConsumer.setMessageListener(new MessageAcknowledge());

			LogVO logVO = new LogVO(message, appName, new Date(), logType);

			ObjectMessage createObjectMessage = session.createObjectMessage(logVO);
			createObjectMessage.setJMSReplyTo(tempDest);

			String correlationId = this.createRandomString();
			createObjectMessage.setJMSCorrelationID(correlationId);
			this.producer.send(createObjectMessage);
		} catch (JMSException e) {
		}
	}

	private String createRandomString() {
		Random random = new Random(System.currentTimeMillis());
		long randomLong = random.nextLong();
		return Long.toHexString(randomLong);
	}
}
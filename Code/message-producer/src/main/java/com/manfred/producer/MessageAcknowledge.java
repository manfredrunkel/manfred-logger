package com.manfred.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message acknowledge that message was received
 * 
 */
public class MessageAcknowledge implements MessageListener {

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String messageText = textMessage.getText();
				if (messageText.equalsIgnoreCase("ACK")) {
					System.out.println("Message received!" + message.getJMSMessageID());
				}
			}
		} catch (JMSException e) {
		}
	}

}

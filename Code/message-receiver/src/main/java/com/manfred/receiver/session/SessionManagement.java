package com.manfred.receiver.session;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

public class SessionManagement {

	public static Session createSession(Connection connection) throws JMSException {
		return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

}

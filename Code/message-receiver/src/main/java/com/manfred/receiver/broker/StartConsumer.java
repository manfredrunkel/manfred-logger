package com.manfred.receiver.broker;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.log4j.Logger;

import com.manfred.receiver.queues.Queue;
import com.manfred.receiver.queues.custom.ApplicationQueue;
import com.manfred.receiver.queues.custom.ECommerceQueue;
import com.manfred.receiver.session.SessionManagement;

public class StartConsumer {

	private static Logger log = Logger.getLogger("StartConsumer");

	public static void main(String[] args) {

		String port = System.getProperty("port");
		log.info("Port Defined: " + port);

		Session session;
		try {
			Broker broker = new Broker(port);
			broker.startBroker();
			session = SessionManagement.createSession(BrokerConnection.getConnection(port));
			System.out.println("Creating queues...");
			Queue appQueue = new ApplicationQueue(session);
			Queue ecommerceQueue = new ECommerceQueue(session);

			new Thread(appQueue).start();
			new Thread(ecommerceQueue).start();

			System.out.println("Queues created...");

		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

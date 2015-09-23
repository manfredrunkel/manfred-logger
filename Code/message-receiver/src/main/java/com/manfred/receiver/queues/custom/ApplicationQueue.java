package com.manfred.receiver.queues.custom;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.manfred.business.log.bpo.ISaveLogBPO;
import com.manfred.business.log.bpo.SaveLogBPOImpl;
import com.manfred.business.log.bpo.vo.LogVO;
import com.manfred.framework.app.ApplicationTypes;
import com.manfred.receiver.queues.Queue;

public class ApplicationQueue extends Queue implements Runnable {

	public ApplicationQueue(Session session) {
		super(session, ApplicationTypes.APPLICATION);
	}

	@Override
	public void onMessage(Message message) {
		{
			try {
				TextMessage response = this.session.createTextMessage();
				if (message instanceof ObjectMessage) {
					ObjectMessage objMessage = (ObjectMessage) message;
					LogVO log = (LogVO) objMessage.getObject();

					ISaveLogBPO saveLog = new SaveLogBPOImpl();
					saveLog.persistLog(ApplicationTypes.APPLICATION, log);
					logger.info("Message received. It's Log Application Message. Id:" + objMessage.getJMSMessageID());
				}
				response.setText("ACK");
				response.setJMSCorrelationID(message.getJMSCorrelationID());
				this.replyProducer.send(message.getJMSReplyTo(), response);
			} catch (JMSException e) {
			}
		}
	}

	@Override
	public void run() {
		super.run();
		System.out.println("ApplicationQueue Started");
	}

}

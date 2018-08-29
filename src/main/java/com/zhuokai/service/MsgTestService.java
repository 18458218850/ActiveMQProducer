package com.zhuokai.service;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.zhuokai.model.User;

/**
 * 生产者
 * @author Administrator
 *
 */
@Service
public class MsgTestService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	/**
	 * 生产消息
	 * @param destinationName 放入的队列名
	 * @param User 消息
	 * @throws JMSException 
	 */
	public void sendQueue(String destinationName,User u) throws JMSException{
		//生成一个队列
		ActiveMQQueue q = new ActiveMQQueue(destinationName);
		//序列化并发送消息
		jmsMessagingTemplate.convertAndSend(q, u);
		
		/*//完整的过程
		//创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello!test-queue");
        //8、发送消息
        producer.send(textMessage);
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();*/
   
		
	}

	public void sendTopic(String name, User u) {
		//生成一个topic
		ActiveMQTopic topic = new ActiveMQTopic(name);
		//序列化并发送消息
		jmsMessagingTemplate.convertAndSend(topic, u);
	}
}

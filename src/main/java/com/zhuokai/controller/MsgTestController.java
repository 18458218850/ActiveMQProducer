package com.zhuokai.controller;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhuokai.model.User;
import com.zhuokai.service.MsgTestService;

@RestController
@RequestMapping(value="/MsgProducer")
public class MsgTestController {

	@Autowired
	private MsgTestService msgTestService;
	
	@RequestMapping(value="/sendQueue")
	public String sendQueue(String name, User u) throws JMSException{
		msgTestService.sendQueue(name, u);
		return name+" 消息生成成功!";
	}
	
	@RequestMapping(value="/sendTopic")
	public String sendTopic(String name,User u) throws JMSException{
		msgTestService.sendTopic(name, u);
		return name+"消息生成成功!";
	}
}

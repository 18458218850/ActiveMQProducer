package com.zhuokai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import com.zhuokai.util.MsgTest;

/**
 * CommandLineRunner 接口里面的run方法是在程序启动后就会执行的方法
 * JmsTemplate 是用来操作JMS消息的操作类
 *
 */

@SpringBootApplication

public class ApplicationStart /*implements CommandLineRunner*/{

	@Autowired
	JmsTemplate  jmsTemplate;  
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(ApplicationStart.class, args);
		
	}

	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("zzz");
		jmsTemplate.send("my-destination",new MsgTest());
	}*/
	
}

package com.microservice.service;

import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservice.model.Customer;

@Service
public class CustomerSender {
	
	@Autowired
	private AmqpTemplate rabbitMQTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingKey;	
	
	public void send(Customer customer) {
		//using convertAndSend to convert customer to message type
		
		System.out.println("Sending to queue the message : " + customer);
		//rabbitMQTemplate.send(exchange, routingKey, customer); 
		rabbitMQTemplate.convertAndSend(exchange, routingKey, customer); 
	}
}
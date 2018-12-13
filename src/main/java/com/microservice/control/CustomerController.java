package com.microservice.control;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.service.CustomerSender;
import com.microservice.model.Customer;

@RestController
@RequestMapping(value = "/")
public class CustomerController {

	@Autowired
	CustomerSender customerSender;

	@GetMapping(value = "/customer")
	public String sender(@RequestParam("cName") String custName, @RequestParam("cId") String custId) {
	
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setName(custName);;
		customerSender.send(customer);
	
		return "Message sent to the RabbitMQ Successfully";
	
	}

}
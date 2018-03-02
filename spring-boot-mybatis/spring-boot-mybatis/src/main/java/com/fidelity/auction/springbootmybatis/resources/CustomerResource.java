package com.fidelity.auction.springbootmybatis.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.auction.springbootmybatis.mapper.CustomerMapper;
import com.fidelity.auction.springbootmybatis.model.Customer;

@RestController
@RequestMapping("/rest/customers")
public class CustomerResource {
	
	private CustomerMapper customerMapper;
	
	
	public CustomerResource(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}


	@GetMapping("/all")
	public List<Customer> getAllCustomers(){
		return customerMapper.findAll();
		
	}
	
	public List<Customer> updateCustomer(){
		Customer customer = new Customer();
		customer.setEmail("mike@gmail.com");
		customerMapper.insertUser(customer);
	}

}

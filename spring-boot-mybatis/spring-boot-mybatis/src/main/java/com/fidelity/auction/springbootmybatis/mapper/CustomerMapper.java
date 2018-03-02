package com.fidelity.auction.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fidelity.auction.springbootmybatis.model.Customer;

@Mapper
public interface CustomerMapper {

	@Select("select * from customer")
	List<Customer> findAll();

	void insertUser(Customer customer);

}

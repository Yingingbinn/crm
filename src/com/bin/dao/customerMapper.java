package com.bin.dao;

import java.util.List;

import com.bin.pojo.Customer;
import com.bin.pojo.QueryVo;

public interface customerMapper {
	 public List<Customer>findcusByVo(QueryVo vo);
	 public Integer findCustomerByVoCount (QueryVo vo);
		public Customer findCustomerById(Long id);
	 public void updateCustomerById(Customer customer);
		
		public void delCustomerById(Long id);
}

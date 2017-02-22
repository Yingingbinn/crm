package com.bin.service;

import java.util.List;

import com.bin.pojo.BaseDict;
import com.bin.pojo.Customer;
import com.bin.pojo.QueryVo;

public interface customerService {
	public List<BaseDict> findDictBycode (String code);
	
	 public List<Customer>findcusByVo(QueryVo vo);
	 public Integer findCustomerByVoCount (QueryVo vo);
	 
	 	public Customer findCustomerById(Long id);
		
		public void updateCustomerById(Customer customer);
		
		public void delCustomerById(Long id);
}

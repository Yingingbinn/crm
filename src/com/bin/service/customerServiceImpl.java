package com.bin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bin.dao.DictMapper;
import com.bin.dao.customerMapper;
import com.bin.pojo.BaseDict;
import com.bin.pojo.Customer;
import com.bin.pojo.QueryVo;
@Service("customerServiceImpl")
public class customerServiceImpl implements customerService {

	@Autowired
	private DictMapper dicMapper;
	@Autowired
	private customerMapper cusMapper;
	@Override
	public List<BaseDict> findDictBycode(String code) {
		 List<BaseDict> list =dicMapper.findDictBycode(code);
		return list;
	}
	@Override
	public List<Customer> findcusByVo(QueryVo vo) {
		 List<Customer> list =cusMapper.findcusByVo(vo);
		return list;
	}
	@Override
	public Integer findCustomerByVoCount(QueryVo vo) {
		Integer count =cusMapper.findCustomerByVoCount(vo);
		return count;
	}
	@Override
	public Customer findCustomerById(Long id) {
		Customer customer = cusMapper.findCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomerById(Customer customer) {
		cusMapper.updateCustomerById(customer);
	}

	@Override
	public void delCustomerById(Long id) {
		cusMapper.delCustomerById(id);
	}
}

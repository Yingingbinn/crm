package com.bin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bin.dao.DictMapper;
import com.bin.pojo.BaseDict;
@Service
public class customerServiceImpl implements customerService {

	@Autowired
	private DictMapper dicMapper;
	@Override
	public List<BaseDict> findDictBycode(String code) {
		 List<BaseDict> list =dicMapper.findDictBycode(code);
		return list;
	}

}

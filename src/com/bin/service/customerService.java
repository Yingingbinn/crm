package com.bin.service;

import java.util.List;

import com.bin.pojo.BaseDict;

public interface customerService {
	public List<BaseDict> findDictBycode (String code);
}

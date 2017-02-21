package com.bin.dao;

import java.util.List;
import com.bin.pojo.BaseDict;

public interface DictMapper {
	public List<BaseDict> findDictBycode (String code);
}

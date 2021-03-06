package com.alan.cake.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.cake.admin.dao.SysDictMapper;
import com.alan.cake.admin.model.SysDict;
import com.alan.cake.admin.service.SysDictService;
import com.alan.cake.core.page.MybatisPageHelper;
import com.alan.cake.core.page.PageRequest;
import com.alan.cake.core.page.PageResult;

@Service
public class SysDictServiceImpl implements SysDictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	@Override
	public int save(SysDict record) {
		if (record.getId() == null || record.getId() == 0) {
			return sysDictMapper.insertSelective(record);
		}
		return sysDictMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDict record) {
		return sysDictMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for (SysDict record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysDict findById(Long id) {
		return sysDictMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParam("label");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
		}
		return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
	}

	@Override
	public List<SysDict> findByLabel(String label) {
		return sysDictMapper.findByLabel(label);
	}

}

package com.alan.cake.admin.service;

import java.util.List;

import com.alan.cake.admin.model.SysDict;
import com.alan.cake.core.service.CurdService;

public interface SysDictService extends CurdService<SysDict>{

	List<SysDict> findByLabel(String label);

}

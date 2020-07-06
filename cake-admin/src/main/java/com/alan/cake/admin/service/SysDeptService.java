package com.alan.cake.admin.service;

import java.util.List;

import com.alan.cake.admin.model.SysDept;
import com.alan.cake.core.service.CurdService;

public interface SysDeptService extends CurdService<SysDept> {

	List<SysDept> findTree();
}
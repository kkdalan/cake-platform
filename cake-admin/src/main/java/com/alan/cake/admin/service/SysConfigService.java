package com.alan.cake.admin.service;

import java.util.List;

import com.alan.cake.admin.model.SysConfig;
import com.alan.cake.core.service.CurdService;

public interface SysConfigService extends CurdService<SysConfig> {

	List<SysConfig> findByLable(String lable);
}
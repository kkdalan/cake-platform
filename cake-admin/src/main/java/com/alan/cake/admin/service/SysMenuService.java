package com.alan.cake.admin.service;

import java.util.List;

import com.alan.cake.admin.model.SysMenu;
import com.alan.cake.core.service.CurdService;

public interface SysMenuService extends CurdService<SysMenu> {

	List<SysMenu> findTree(String userName, int menuType);

	List<SysMenu> findByUser(String userName);
	
}

package com.alan.cake.admin.service;

import java.util.List;

import com.alan.cake.admin.model.SysMenu;
import com.alan.cake.admin.model.SysRole;
import com.alan.cake.admin.model.SysRoleMenu;
import com.alan.cake.core.service.CurdService;

public interface SysRoleService extends CurdService<SysRole> {

	List<SysRole> findAll();

	List<SysMenu> findRoleMenus(Long roleId);

	int saveRoleMenus(List<SysRoleMenu> records);

	List<SysRole> findByName(String name);

}

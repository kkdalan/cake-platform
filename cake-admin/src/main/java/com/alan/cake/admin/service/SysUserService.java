package com.alan.cake.admin.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.alan.cake.admin.model.SysUser;
import com.alan.cake.admin.model.SysUserRole;
import com.alan.cake.core.page.PageRequest;
import com.alan.cake.core.service.CurdService;

public interface SysUserService extends CurdService<SysUser> {

	List<SysUser> findAll();

	SysUser findByName(String name);

	Set<String> findPermissions(String userName);
	
	List<SysUserRole> findUserRoles(Long userId);

	File createUserExcelFile(PageRequest pageRequest);

}

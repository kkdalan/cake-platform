package com.alan.cake.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alan.cake.admin.model.SysRoleMenu;
import com.alan.cake.admin.model.SysRoleMenuExample;

public interface SysRoleMenuMapper {
	long countByExample(SysRoleMenuExample example);

	int deleteByExample(SysRoleMenuExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysRoleMenu record);

	int insertSelective(SysRoleMenu record);

	List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

	SysRoleMenu selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

	int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

	int updateByPrimaryKeySelective(SysRoleMenu record);

	int updateByPrimaryKey(SysRoleMenu record);

	List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

	List<SysRoleMenu> findAll();

	int deleteByRoleId(@Param(value = "roleId") Long roleId);
}
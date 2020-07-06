package com.alan.cake.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alan.cake.admin.model.SysMenu;
import com.alan.cake.admin.model.SysMenuExample;

public interface SysMenuMapper {
	long countByExample(SysMenuExample example);

	int deleteByExample(SysMenuExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysMenu record);

	int insertSelective(SysMenu record);

	List<SysMenu> selectByExample(SysMenuExample example);

	SysMenu selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

	int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

	int updateByPrimaryKeySelective(SysMenu record);

	int updateByPrimaryKey(SysMenu record);

	List<SysMenu> findPage();

	List<SysMenu> findPageByName(@Param(value = "name") String name);

	List<SysMenu> findAll();

	List<SysMenu> findByUserName(@Param(value = "userName") String userName);

	List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
}
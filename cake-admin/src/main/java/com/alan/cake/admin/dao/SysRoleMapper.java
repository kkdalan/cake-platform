package com.alan.cake.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alan.cake.admin.model.SysRole;
import com.alan.cake.admin.model.SysRoleExample;

public interface SysRoleMapper {
	long countByExample(SysRoleExample example);

	int deleteByExample(SysRoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	List<SysRole> selectByExample(SysRoleExample example);

	SysRole selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

	int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);

	List<SysRole> findPage();

	List<SysRole> findAll();

	List<SysRole> findPageByName(@Param(value = "name") String name);

	List<SysRole> findByName(@Param(value = "name") String name);
}
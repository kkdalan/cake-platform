package com.alan.cake.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alan.cake.admin.model.SysLog;
import com.alan.cake.admin.model.SysLoginLog;
import com.alan.cake.admin.model.SysLoginLogExample;

public interface SysLoginLogMapper {
	long countByExample(SysLoginLogExample example);

	int deleteByExample(SysLoginLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysLoginLog record);

	int insertSelective(SysLoginLog record);

	List<SysLoginLog> selectByExample(SysLoginLogExample example);

	SysLoginLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

	int updateByExample(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

	int updateByPrimaryKeySelective(SysLoginLog record);

	int updateByPrimaryKey(SysLoginLog record);

	List<SysLog> findPage();

	List<SysLog> findPageByUserName(@Param(value = "userName") String userName);

	List<SysLog> findPageByStatus(@Param(value = "status") String status);

}
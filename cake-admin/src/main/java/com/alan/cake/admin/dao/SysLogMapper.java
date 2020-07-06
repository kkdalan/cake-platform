package com.alan.cake.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alan.cake.admin.model.SysLog;
import com.alan.cake.admin.model.SysLogExample;

public interface SysLogMapper {
	long countByExample(SysLogExample example);

	int deleteByExample(SysLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysLog record);

	int insertSelective(SysLog record);

	List<SysLog> selectByExample(SysLogExample example);

	SysLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByPrimaryKeySelective(SysLog record);

	int updateByPrimaryKey(SysLog record);

	List<SysLog> findPage();

	List<SysLog> findPageByUserName(@Param(value = "userName") String userName);
}
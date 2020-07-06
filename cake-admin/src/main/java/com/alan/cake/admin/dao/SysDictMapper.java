package com.alan.cake.admin.dao;

import com.alan.cake.admin.model.SysDict;
import com.alan.cake.admin.model.SysDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictMapper {
	long countByExample(SysDictExample example);

	int deleteByExample(SysDictExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysDict record);

	int insertSelective(SysDict record);

	List<SysDict> selectByExample(SysDictExample example);

	SysDict selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

	int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

	int updateByPrimaryKeySelective(SysDict record);

	int updateByPrimaryKey(SysDict record);

	List<SysDict> findPage();

	List<SysDict> findByLabel(@Param(value = "label") String label);

	List<SysDict> findPageByLabel(@Param(value = "label") String label);
}
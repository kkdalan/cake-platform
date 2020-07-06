package com.alan.cake.admin.dao;

import com.alan.cake.admin.model.SysDept;
import com.alan.cake.admin.model.SysDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDeptMapper {
	long countByExample(SysDeptExample example);

	int deleteByExample(SysDeptExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysDept record);

	int insertSelective(SysDept record);

	List<SysDept> selectByExample(SysDeptExample example);

	SysDept selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

	int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

	int updateByPrimaryKeySelective(SysDept record);

	int updateByPrimaryKey(SysDept record);

	List<SysDept> findPage();

	List<SysDept> findAll();
}
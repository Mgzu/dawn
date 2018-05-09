package org.dawn.mapper;

import java.util.List;

import org.dawn.entity.SysUser;
import org.springframework.stereotype.Component;

@Component
public interface SysUserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Integer userId);
	
	List<SysUser> selectAll();

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);
}
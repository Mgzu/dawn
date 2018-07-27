package org.dawn.mapper;

import java.util.List;

import org.dawn.entity.SysUser;
import org.springframework.stereotype.Component;

/**
 * 用户 Mapper
 *
 * @author mgzu
 * @date 2018/5/9
 */
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
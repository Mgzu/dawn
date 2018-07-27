package org.dawn.Repository;

import java.io.Serializable;

import org.dawn.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户 Repository
 *
 * @author mgzu
 * @date 2018/5/9
 */
public interface SysUserRepository extends Serializable, JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {
}
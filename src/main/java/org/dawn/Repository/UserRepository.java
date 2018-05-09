package org.dawn.Repository;

import java.io.Serializable;

import org.dawn.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends Serializable, JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {
}
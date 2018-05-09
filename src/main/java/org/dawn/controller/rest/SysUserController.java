package org.dawn.controller.rest;

import org.dawn.Repository.UserRepository;
import org.dawn.dto.RestDto;
import org.dawn.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	UserRepository userDao;
	@Autowired
	SysUserMapper userMapper;

	@RequestMapping("home")
	public Object home() {
		return new RestDto("Hello oneself");
	}

	@RequestMapping("setting")
	public Object setting() {
		return new RestDto(userDao.findById(1).get().getUserName());
	}

	@RequestMapping("dao")
	public Object dao() {
		return new RestDto(userDao.findById(1).get().getNickName());
	}

	@RequestMapping("mapper")
	public Object mapper() {
		return new RestDto(userMapper.selectByPrimaryKey(1).getUserName());
	}

	@RequestMapping("name/{id}")
	public Object name(@PathVariable Integer id) {
		return new RestDto(userDao.findById(id).get().getNickName());
	}

	@RequestMapping("all")
	public Object name() {
		return new RestDto(userMapper.selectAll());
	}
}

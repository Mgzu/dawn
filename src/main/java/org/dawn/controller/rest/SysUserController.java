package org.dawn.controller.rest;

import java.util.List;

import org.dawn.Repository.SysUserRepository;
import org.dawn.dto.RestDto;
import org.dawn.entity.SysUser;
import org.dawn.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户 Controller
 *
 * @author mgzu
 * @date 2018/7/10
 */
@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    SysUserRepository userDao;
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
    public Object all() {
        return new RestDto(userMapper.selectAll());
    }

    @RequestMapping("page")
    public Object page(Integer pageNum, Integer pageSize) {
        pageNum = pageNum != null ? pageNum : 1;
        pageSize = pageSize != null ? pageSize : 10;
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> list = userMapper.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        return new RestDto(pageInfo);
    }
}

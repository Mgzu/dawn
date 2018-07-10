package org.dawn;

import org.dawn.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DawnApplicationTests {

	@Autowired
	SysUserMapper userMapper;

	@Test
	public void contextLoads() {
		Page<Object> page = PageHelper.startPage(1, 5).doSelectPage(() -> userMapper.selectAll());
		System.out.println(page);
	}

}

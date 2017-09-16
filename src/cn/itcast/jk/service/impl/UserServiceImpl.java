package cn.itcast.jk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.mapper.UserMapper;
import cn.itcast.jk.service.UserService;
import cn.itcast.jk.utils.Encrypt;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	public User findUserByNameAndPwd(String name, String pwd) {
		String password=Encrypt.md5(pwd, name);
		User user = userMapper.findUserByNameAndPwd(name, password);
		return user;
	}

}

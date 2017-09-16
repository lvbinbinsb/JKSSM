package cn.itcast.jk.service;

import cn.itcast.jk.domain.User;

public interface UserService {

	User findUserByNameAndPwd(String name, String pwd);

}

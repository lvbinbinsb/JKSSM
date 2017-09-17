package cn.itcast.jk.service;

import java.util.List;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.vo.UserAndInfoVo;

public interface UserService {

	User findUserByNameAndPwd(String name, String pwd);

	void findByPage(Page page);

	User findUserById(String userId);

	List<UserAndInfoVo> findAllUser();

	void insertUser(UserAndInfoVo uinfo);

}

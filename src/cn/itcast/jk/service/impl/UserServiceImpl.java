package cn.itcast.jk.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserInfo;
import cn.itcast.jk.mapper.UserInfoMapper;
import cn.itcast.jk.mapper.UserMapper;
import cn.itcast.jk.service.UserService;
import cn.itcast.jk.utils.ConstantSession;
import cn.itcast.jk.utils.Encrypt;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.vo.UserAndInfoVo;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public User findUserByNameAndPwd(String name, String pwd) {
		String password=Encrypt.md5(pwd, name);
		User user = userMapper.findUserByNameAndPwd(name, password);
		return user;
	}

	public void findByPage(Page page) {
		int totalRecord=userMapper.findTotalCount();
		page.setTotalRecord(totalRecord);
		
		List<User> list = userMapper.findUser((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
		page.setResults(list);
	}

	public User findUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	//列表查询
	public List<UserAndInfoVo> findAllUser() {
		List<UserAndInfoVo> userList=userMapper.findAllUser();
		return userList;
	}

	public void insertUser(UserAndInfoVo uinfo) {
		String uuid=UUID.randomUUID().toString();
		User record=new User();
		record.setUserId(uuid);
		record.setDeptId(uinfo.getDeptId());
		record.setUserName(uinfo.getUserName());
		record.setPassword(Encrypt.md5("123456", uinfo.getUserName()));  //初始密码123456
		record.setCreateTime(new Date());
		record.setState(1);
		
		ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		HttpSession session = attrs.getRequest().getSession();
		
		User u=(User) session.getAttribute(ConstantSession.USER_SESSION);
		//获取session
		
		
		UserInfo userInfo=new UserInfo();
		userInfo.setUserInfoId(uuid);
		userInfo.setName(uinfo.getUserInfo().getName());
		userInfo.setManagerId(uinfo.getUserInfo().getManagerId());
		userInfo.setJoinDate(uinfo.getUserInfo().getJoinDate());
		userInfo.setSalary(uinfo.getUserInfo().getSalary());
		userInfo.setDegree(uinfo.getUserInfo().getDegree());
		userInfo.setGender(uinfo.getUserInfo().getGender());
		userInfo.setStation(uinfo.getUserInfo().getStation());
		userInfo.setTelephone(uinfo.getUserInfo().getTelephone());
		userInfo.setEmail(uinfo.getUserInfo().getEmail());
		userInfo.setBirthday(uinfo.getUserInfo().getBirthday());
		userInfo.setOrderNo(uinfo.getUserInfo().getOrderNo());
		userInfo.setRemark(uinfo.getUserInfo().getRemark());
		userInfo.setCreateTime(new Date());
		userInfo.setUpdateTime(new Date());
		userInfoMapper.insert(userInfo);
		userMapper.insert(record);
		
		
	}

}

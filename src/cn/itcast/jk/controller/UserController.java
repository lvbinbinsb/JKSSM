package cn.itcast.jk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.UserService;
import cn.itcast.jk.utils.ConstantSession;

@Controller
@RequestMapping("/login")
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String tologin(){
		return "sysadmin/login/login";
	}
	
	@RequestMapping("/denglu")
	public String denglu(User u,HttpSession session){
		String name=u.getUserName();
		String pwd=u.getPassword();
		User user=userService.findUserByNameAndPwd(name,pwd);
		if(user!=null){
			//登录成功
			session.setAttribute(ConstantSession.USER_SESSION, user);
			return "home/fmain";
		}
		
		return "sysadmin/login/login";
	}
	
	@RequestMapping("/homeAction_title")
	public String homeAction_title(String moduleName){
		return moduleName+"/title";
	}
	
	@RequestMapping("/homeAction_toleft")
	public String homeAction_toleft(String moduleName){
		return moduleName+"/left";
	}
	
	@RequestMapping("/homeAction_tomain")
	public String homeAction_tomain(String moduleName){
		return moduleName+"/main";
	}
	
}

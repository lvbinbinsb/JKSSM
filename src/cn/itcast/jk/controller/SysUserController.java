package cn.itcast.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.service.UserService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.vo.DeptVo;
import cn.itcast.jk.vo.UserAndInfoVo;

@Controller
@RequestMapping("/sysadmin")
public class SysUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/userAction_list")
	public String list(Model model,Page page){
		userService.findByPage(page);
		page.setUrl("userAction_list.action");

		model.addAttribute("page", page);
		
		return "sysadmin/user/jUserList";
	}
	
	
	@RequestMapping("/userAction_toview")
	public String view(Model model,User u){
		User user=userService.findUserById(u.getUserId());
		model.addAttribute("user", user);
		DeptVo deptVo = deptService.findById(user.getDeptId());
		model.addAttribute("deptVo", deptVo);
		return "sysadmin/user/jUserView";
	}
	
	//新增角色
	
	@RequestMapping("/userAction_tocreate")
	public String tocreate(Model model){
		List<Dept> deptList = deptService.selAllDept();
		model.addAttribute("deptList", deptList);
		
		List<UserAndInfoVo> userList=userService.findAllUser();
		model.addAttribute("userList", userList);
		return "sysadmin/user/jUserCreate";
	}
	
	//新增User
	@RequestMapping("/userAction_insert")
	public String insert(Model model,UserAndInfoVo uinfo){
		//保存用户以及用户详细信息
		userService.insertUser(uinfo);
		return "redirect:/sysadmin/userAction_list.action";
	}
}

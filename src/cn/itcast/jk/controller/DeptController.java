package cn.itcast.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;

@Controller
@RequestMapping("/sysadmin")
public class DeptController {
	
	  private Page<Dept> page=new Page<Dept>();
	
	@Autowired
	private DeptService deptService;
	
	
	@RequestMapping("/deptAction_list")
	public String deptList(Model model,Page page){
		deptService.findByPage(page);
		page.setUrl("deptAction_list");
		
		model.addAttribute("page", page);
		return "sysadmin/dept/jDeptList";
	}
}

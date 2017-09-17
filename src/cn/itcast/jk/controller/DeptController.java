package cn.itcast.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.vo.DeptVo;

@Controller
@RequestMapping("/sysadmin")
public class DeptController {

	private Page page = new Page();

	@Autowired
	private DeptService deptService;

	@RequestMapping("/deptAction_list")
	public String deptList(Model model, Page page) {
		deptService.findByPage(page);
		page.setUrl("deptAction_list.action");

		model.addAttribute("page", page);
		return "sysadmin/dept/jDeptList";
	}

	
	
	@RequestMapping("/deptAction_toview")
	public String toview(String id, Model model) {
		DeptVo dept = deptService.findById(id);
		model.addAttribute("dept", dept);
		return "sysadmin/dept/jDeptView";
	}

	@RequestMapping("/deptAction_tocreate")
	public String tocreate(Model model) {
		// 查出所有部门集合
		List<Dept> list = deptService.selAllDept();
		model.addAttribute("list", list);
		return "sysadmin/dept/jDeptCreate";
	}

	@RequestMapping("/deptAction_insert")
	public String insert(String deptName, String parentId) {
		deptService.insertDept(deptName, parentId);
		return "redirect:/sysadmin/deptAction_list.action";
	}

	@RequestMapping("/deptAction_toupdate")
	public String toupdate(String id, Model model) {
		DeptVo dept = deptService.findById(id);
		model.addAttribute("dept", dept);

		// 查出所有部门集合
		List<Dept> list = deptService.selAllDept();
		model.addAttribute("list", list);
		return "sysadmin/dept/jDeptUpdate";
	}
	
	
	@RequestMapping("/deptAction_update")
	public String update(Dept dept, Model model) {
		deptService.updateDept(dept);
		return "redirect:/sysadmin/deptAction_list.action";
	}
	
	
	@RequestMapping("/deptAction_delete")
	public String delete(String id, Model model) {
		deptService.deleteById(id);
		return "redirect:/sysadmin/deptAction_list.action";
	}
}

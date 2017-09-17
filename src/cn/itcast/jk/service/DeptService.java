package cn.itcast.jk.service;

import java.util.List;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.vo.DeptVo;

public interface DeptService {

	void findByPage(Page page);

	DeptVo findById(String id);

	List<Dept> selAllDept();

	void insertDept(String deptName, String parentId);

	void updateDept(Dept dept);

	void deleteById(String id);

}

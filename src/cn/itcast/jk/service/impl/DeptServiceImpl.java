package cn.itcast.jk.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.domain.DeptExample;
import cn.itcast.jk.mapper.DeptMapper;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.vo.DeptVo;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptMapper deptMapper;

	public void findByPage(Page page) {
			int totalRecord=deptMapper.findTotalCount();
			page.setTotalRecord(totalRecord);
			
			List<DeptVo> list = deptMapper.findDeptVo((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
			page.setResults(list);
	}

	public DeptVo findById(String id) {
		DeptVo dept = deptMapper.findDeptVoById(id);
		return dept;
	}

	public List<Dept> selAllDept() {
		DeptExample example=new DeptExample();
		List<Dept> list = deptMapper.selectByExample(example);
		return list;
	}

	public void insertDept(String deptName, String parentId) {
		Dept record=new Dept();
		record.setDeptName(deptName);
		record.setParentId(parentId);
		record.setState(1);
		record.setDeptId(UUID.randomUUID().toString());
		deptMapper.insert(record);
		
	}

	public void updateDept(Dept dept) {
		deptMapper.updateByPrimaryKey(dept);
	}

	public void deleteById(String id) {
		deptMapper.deleteByPrimaryKey(id);
	}
	
	
}

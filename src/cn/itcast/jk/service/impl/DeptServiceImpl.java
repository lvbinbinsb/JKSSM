package cn.itcast.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.mapper.DeptMapper;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptMapper deptMapper;

	public void findByPage(Page page) {
			int totalRecord=deptMapper.findTotalCount();
			page.setTotalRecord(totalRecord);
			
			List<Dept> list = deptMapper.findList((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
			page.setResults(list);
	}
	
	
}

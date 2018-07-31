package com.atguigu.cloud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atguigu.cloud.empty.Dept;
import com.atguigu.cloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
//	@Autowired
//	private DeptDao dao;

	@Override
	public boolean add(Dept dept) {
//		return dao.addDept(dept);
		return true;
	}

	@Override
	public Dept get(Long id) {
//		return dao.findById(id);
		return new Dept("Test", "db_source02");
	}

	@Override
	public List<Dept> list() {
//		return dao.findAll();
		return null;
	}

}

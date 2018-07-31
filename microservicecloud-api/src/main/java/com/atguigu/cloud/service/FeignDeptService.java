package com.atguigu.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.cloud.empty.Dept;

@FeignClient(value="microservicecloud-dept")
public interface FeignDeptService {

	@RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
	public String add(@RequestBody Dept dept);
	
	@RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
	public Object discovery();
}

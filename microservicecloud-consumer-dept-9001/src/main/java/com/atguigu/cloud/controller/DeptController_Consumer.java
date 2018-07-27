package com.atguigu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.cloud.empty.Dept;

@RestController
public class DeptController_Consumer {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
	public String add(@RequestBody Dept dept)
	{
		return restTemplate.postForObject("http://localhost:8001/test/dept/add", dept, String.class);
	}
	
	@RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return restTemplate.getForObject("http://localhost:8001/test/dept/get/" + id, Dept.class);
	}
	
	@RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		return restTemplate.getForObject("http://localhost:8001/dept/discovery", Object.class);
	}
}

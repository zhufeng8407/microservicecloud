package com.atguigu.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.cloud.empty.Dept;
import com.atguigu.cloud.service.DeptService;


@RestController
public class DeptController
{
	@Autowired
	private DeptService service;
//	@Autowired
//	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}
	
	@RequestMapping(value = "/test/dept/add", method = RequestMethod.POST)
	public String addTest(@RequestBody Dept dept)
	{
		return "Add Test";
	}
	

	@RequestMapping(value = "/test/dept/get/{id}", method = RequestMethod.GET)
	public Dept getTest(@PathVariable("id") Long id)
	{
		return new Dept("dept01", "db_source03");
	}

	@RequestMapping(value = "/test/dept/list", method = RequestMethod.GET)
	public String listTest()
	{
		return "List Test";
	}
	
	

	
	@Autowired
	private DiscoveryClient client;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}

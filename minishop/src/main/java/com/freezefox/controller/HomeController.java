package com.freezefox.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freezefox.entity.Employee;

@Controller
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	public String viewHome() {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		Employee employee = (Employee) context.getBean("employee");
		employee.getMessage();
		return "this is the home";
	}
}

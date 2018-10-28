package com.example.student.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.student.domain.Student;

@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	private Map<String, Object> studentDetails = new HashMap<>();
	
	@RequestMapping(path= {"/","/home"})
	public String home() {
		return "home";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView showAddStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("add");
		
		return mav;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute @Valid Student student, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			logger.warn("Có lỗi xác thực");
			List<ObjectError> allErr = bindingResult.getAllErrors();
			for (ObjectError objectError : allErr) {
				logger.debug("ERROR: "+objectError);
			}
			
			return "add";
		}
		
		studentDetails.put(student.getName(), student);
		
		logger.debug("Đang hiển thị danh sách sinh viên...");
		return "redirect:view";
	}
	
	@RequestMapping("/view")
	public ModelAndView showStudentDetails() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("students", studentDetails.values());
		mav.setViewName("view");
		
		return mav;
	}

}

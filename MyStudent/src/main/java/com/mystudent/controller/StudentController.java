package com.mystudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Student;
import com.mystudent.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(path= {"/", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping(path = {"/student"})
	public String index(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "list";
	}

	@GetMapping("/student/create")
	public String create(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

	@GetMapping("/student/edit-id={id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("student", studentService.findOne(id));
		return "form";
	}

	@PostMapping("/student/save")
	public String save(@Valid Student student, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		studentService.save(student);
		redirect.addFlashAttribute("success", "Saved student successfully!");
		return "redirect:/student";
	}

	@GetMapping("/student/{id}/delete")
	public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
		studentService.delete(id);
		redirect.addFlashAttribute("success", "Deleted student successfully!");
		return "redirect:/student";
	}

	@GetMapping("/student/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/student";
		}

		model.addAttribute("students", studentService.search(s));
		return "list";
	}
}
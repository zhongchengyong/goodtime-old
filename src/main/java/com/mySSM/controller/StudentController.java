package com.mySSM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mySSM.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String getStudentList(ModelMap model){
		model.addAttribute("list", studentService.getStudentList());
		System.out.println(studentService.getStudentList());
		return "list";
	}
}

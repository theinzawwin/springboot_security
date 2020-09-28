package com.springboot.best.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.best.dto.TeacherDTO;
import com.springboot.best.services.DepartmentService;
import com.springboot.best.services.TeacherService;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeacherService teacherService;
	@GetMapping("/list")
	public String index(Model model,@RequestParam(value="departmentId",required = false)Long departemntId) {
		if(departemntId==null)
		model.addAttribute("teacherList", teacherService.getTeacherList());
		else {
			model.addAttribute("teacherList", teacherService.getTeacherListByDepartment(departemntId));
		}
		model.addAttribute("departmentList", departmentService.getDepartmentList());
		return "teachers/list";
	}
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("departmentList", departmentService.getDepartmentList());
		model.addAttribute("teacher", new TeacherDTO());
		return "teachers/create";
	}
	@PostMapping("/create")
	public String createPost(@ModelAttribute(value="teacher")TeacherDTO teacher,Model model) {
		teacherService.save(teacher);
		return "redirect:/teacher/list";
	}
}

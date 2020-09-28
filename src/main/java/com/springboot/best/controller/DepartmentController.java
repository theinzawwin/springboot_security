package com.springboot.best.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.best.dto.DepartmentDTO;
import com.springboot.best.services.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@GetMapping("/list")
	public String index(Model model) {
		model.addAttribute("departmentList", departmentService.getDepartmentList());
		return "departments/list";
	}
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("department", new DepartmentDTO());
		return "departments/create";
	}
	@PostMapping("/create")
	public String createPost(@ModelAttribute(value="department") DepartmentDTO dept,Model model) {
		departmentService.saveDepartment(dept);
		
		return "redirect:/department/list";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		if(id==null) {
			
		}
		DepartmentDTO dto=departmentService.findById(id);
		model.addAttribute("department", dto);
		return "departments/edit";
	}
	@PostMapping("/edit")
	public String editDepartment(@ModelAttribute(value="department") DepartmentDTO dept,Model model) {
		departmentService.saveDepartment(dept);
		return "redirect:/department/list";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		departmentService.delete(id);
		return "redirect:/department/list";
	}
}

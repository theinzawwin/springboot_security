package com.springboot.best.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.best.dao.PrivilegeRepository;
import com.springboot.best.dao.UserHasPrivilegeRepository;
import com.springboot.best.dto.ManagePrivilegeDTO;
import com.springboot.best.model.User;
import com.springboot.best.services.PrivilegeService;
import com.springboot.best.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PrivilegeService privilegeService;
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private UserHasPrivilegeRepository userHasPrivilegeRepository;
	@GetMapping("/register")
	public String userRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute(value="user") User user) {
		userService.saveUser(user);
		return "register";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
	 @RequestMapping(value="/logout", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/login";  
	     } 
	 @PreAuthorize("isAuthenticated()") 
	 @GetMapping("/info")
	 public String info(Model model) {
		 return "info";
	 }
	 @GetMapping("/admin_info")
	 public String admin_info(Model model) {
		 return "admin_info";
	 }
	 @GetMapping("/admin/manage_permission")
	 public String manage_permission(Model model) {
		 model.addAttribute("privilegeList", privilegeRepository.findAll());
		 model.addAttribute("userList", userService.findAllUser());
		 model.addAttribute("dto", new ManagePrivilegeDTO());
		 return "manage_permission";
	 }
	 @PostMapping("/admin/manage_permission")
	 public String save_manage_permission(@ModelAttribute(value="dto") ManagePrivilegeDTO dto ,Model model) {
		 privilegeService.savePrivilegeForUser(dto);
		 model.addAttribute("privilegeList", privilegeRepository.findAll());
		 model.addAttribute("userList", userService.findAllUser());
		 model.addAttribute("dto", new ManagePrivilegeDTO());
		 return "redirect:/admin/user_list";
	 }
	 @GetMapping("/admin/user_list")
	 public String userList(Model model) {
		 model.addAttribute("userList", userService.findAllUser());
		 return "userList";
	 }
	 
	 @GetMapping("/admin/privilege/{id}")
	 public String showUserPrivilegeDetail(@PathVariable Long id,Model model) {
		 model.addAttribute("user", userService.findById(id));
		 model.addAttribute("userPrevilgeList", userHasPrivilegeRepository.findByUserId(id));
		 return "user_privilege_detail";
	 }
	 @GetMapping("/accessdenied")
	 public String accessDenied() {
		 return "403";
	 }
	 
	 
}

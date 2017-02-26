package com.samsung.spring.security.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.spring.security.Entity.User;
import com.samsung.spring.security.Service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {

		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "This is welcome page!");

		return "main";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		
		return "register";
	}

	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public String registerUserAccount(Model model, @ModelAttribute("user") @Valid User user, BindingResult result,
			WebRequest request, Errors errors) {

		if (result.hasErrors()) {
			return "register";
		}
		
		User oldUser = userService.getUserByName(user.getUsername());
		if (null != oldUser) {
			model.addAttribute("userexist", "User Exists!");
			return "register";
		}
		
		userService.insertUser(user);

		return "redirect:/login";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(Model model) {

		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "This is protected page!");

		return "admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Invalid username or password!");
		} else if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		} else {
			model.addAttribute("wlkmsg", "Welcome to SPay Vas Admin Portal.");
		}

		return "login";
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(Model model) {

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		}

		return "403";
	}
}

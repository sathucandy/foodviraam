package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;
import com.example.demo.model.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private UserRepo userRepo;

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/")
	public String checkMVC() {
		return "login";
	}

	@RequestMapping("/login")
	public String loginHomePage(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model) {
		User user;
		try {
			user = userRepo.findByName(userName);
		} catch (Exception e) {
			System.out.println("User wasnt found");
			return "login";
		}
		if (user != null) {
			model.addAttribute("UserName", userName);
			return "home";
		}
		return "login";
	}

	@RequestMapping("/register")
	public String goToRegister() {
		return "register";
	}

	@RequestMapping("/setUser")
	public String goToRegisterMicroService(@PathVariable("userName") String userName,
			@PathVariable("password") String password1, @PathVariable("password") String password2, Model model) {
		if (password1.equals(password2)) {
			restTemplate.getForObject("http://localhost:8081/register-user/" + userName + "/" + password1,
					String.class);
			model.addAttribute("registerSuccess", "Successfully registered");
		} else {
			model.addAttribute("registeration error", "Password not same");
		}
		return "login";
	}

}

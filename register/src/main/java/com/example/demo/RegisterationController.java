package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.model.UserRepo;

@Controller
public class RegisterationController {

	@Autowired
	private UserRepo userRepo;

	@RequestMapping("/register-user/{userName}/{password}")
	public String registerUser(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		User user = new User();
		user.setId(2);
		user.setName(userName);
		user.setPassword(password);

		userRepo.save(user);
		return "Successfully registered";
	}

}

package com.geetha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geetha.model.User;
import com.geetha.service.UserService;

@org.springframework.web.bind.annotation.RestController


public class RestController {
	
	@Autowired
	private UserService userService;

@GetMapping("/hello")
public String hello()
{
	return " this is from restcontroller hello method";
}


@GetMapping("/saveuser")
public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password)
{

	User user=new User(username,firstname,lastname,age,password);
	userService.saveMyUser(user);
	return "User saved";
}
}

package com.geetha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geetha.model.User;
import com.geetha.repository.UserRepository;

@Service
@Transactional

public class UserService {



	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) 
	{
		this.userRepo = userRepo;
	}

	public void saveMyUser(User user) {

		userRepo.save(user);
	}

	
	public List<User> showAllUsers(){
		List<User> users=new ArrayList<User>();
		for(User user:userRepo.findAll()) {
			users.add(user);
		}
			
		return users;
	}
	
	public void deleteMyUser(int id) {
		userRepo.deleteById(id);
	}

	public User editUser(int id) {
		return userRepo.findById(id).orElseThrow();
		}
	
	public User findByUsernameAndPassword(String username,String password)
	{
		return userRepo.findByUsernameAndPassword(username, password);
	}
}

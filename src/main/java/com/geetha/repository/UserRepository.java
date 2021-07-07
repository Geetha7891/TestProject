package com.geetha.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.geetha.model.User;


@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

	
	public User findByUsernameAndPassword(String username,String password);
}

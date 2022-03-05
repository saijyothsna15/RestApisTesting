package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo oUserRepo;

	@Override
	public User saveUser(User user) {
		return oUserRepo.saveUser(user);
	}

	@Override
	public User getUser(int userId) {
		return oUserRepo.getUser(userId);
	}

}

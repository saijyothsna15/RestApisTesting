package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
	public User saveUser(User user);
	public User getUser(int userId);
}

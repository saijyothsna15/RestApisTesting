package com.example.demo.dao;

import com.example.demo.model.User;

public interface UserRepo {
	public User saveUser(User user);
	public User getUser(int userId);
}

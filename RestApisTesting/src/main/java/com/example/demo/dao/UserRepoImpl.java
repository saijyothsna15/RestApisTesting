package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository
public class UserRepoImpl implements UserRepo{
	private static int userId=1;
	List<User> users = new ArrayList<User>();

	@Override
	public User saveUser(User user) {
		user.setUserId(userId++);
		boolean result = users.add(user);
		if(result==true)
			return user;
		return null;
	}

	@Override
	public User getUser(int userId) {
		
		for(User user : users) {
			if(user.getUserId()==userId)
				return user;
		}
		return null;
	}

}

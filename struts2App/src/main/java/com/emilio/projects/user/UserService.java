package com.emilio.projects.user;

import com.emilio.projects.model.User;

public interface UserService {
	
	public User getUserByEmail(String email);
	public void persistUser(User user);

}

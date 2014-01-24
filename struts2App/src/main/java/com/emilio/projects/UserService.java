package com.emilio.projects;

import com.emilio.projects.model.User;

public interface UserService {
	
	public User getUserByEmail(String email);
	public void persistUser(User user);

}

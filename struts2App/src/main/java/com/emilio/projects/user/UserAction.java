package com.emilio.projects.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.emilio.projects.model.*;

public class UserAction extends ActionSupport implements ModelDriven<User>, Preparable {
	
	private User user;
	private String emailId;
	private UserService service;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public User getModel() {
		return user;
	}
	public void prepare() throws Exception {
		if( emailId==null || "".equals(emailId) ) {
			user = new User();
		} else {
			user = service.getUserByEmail(emailId);
		}
	}
	public String find() {
		return INPUT;
	}
	public String update() {
		service.persistUser(user);
		return SUCCESS;
	}

}

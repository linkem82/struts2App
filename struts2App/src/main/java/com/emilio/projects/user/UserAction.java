package com.emilio.projects.user;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.springframework.web.util.UriUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.emilio.projects.Utils;
import com.emilio.projects.model.*;


@Validation
public class UserAction extends ActionSupport implements ModelDriven<User>, Preparable {
	
	private User user;
	private String emailId;
	private UserService service;
	private File upload;
	private String uploadFileName;
	
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
		//user = service.getUserByEmail(emailId);
		return INPUT;
	}
	
	@Validations( visitorFields = {
									@VisitorFieldValidator(
									message = "Default message", key = "i18n.key",
									fieldName= "model", appendPrefix = false) 
								  }
				)
	public String update() {
		if(uploadFileName!=null && !"".equals(uploadFileName)) {
			user.setPortrait(Utils.getBytesFromFile(upload));
			}
		service.persistUser(user);
		return SUCCESS;
	}
	public InputStream getInputStream() {
		if( user==null || user.getPortrait()==null) {
			return Utils.getNoImageInputStream(getText("text.noImage"));
		} else {
			return new ByteArrayInputStream(user.getPortrait());
		}
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String fileName) {
		this.uploadFileName = fileName;
	}
}

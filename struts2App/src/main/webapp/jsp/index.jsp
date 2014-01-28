<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Home</title>
</head>
<body>
	<s:if test="#session['user']==null">
		<s:url id="register" action="findUser" namespace="/user" />
		<s:a href="%{register}">Register</s:a>
	</s:if>
	<s:else>
		<s:url id="update" action="findUser" namespace="/user" >
			<s:param name="emailId" value="#session['user'].email" />
		</s:url>
		<s:a href="%{update}">Update Profile</s:a>
	</s:else>
</body></html>
	
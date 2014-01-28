<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>User Information</title>
</head>
<body>
	<s:form action="updateUser" namespace="/user" >
		<s:textfield label="First Name" name="firstName" />
		<s:textfield label="Last Name" name="lastName" />
		<s:textfield label="Email Address" name="email" />
		<s:password label="Password" name="password" />
		<s:hidden name="emailId" />
		<s:if test="email==null">
			<s:submit value="Register" />
		</s:if>
		<s:else>
			<s:submit value="Update" />
		</s:else>
	</s:form>
</body>
</html>
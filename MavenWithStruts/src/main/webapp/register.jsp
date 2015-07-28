<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Register Here</h2>
	<html:form action="/register.do" method="post">

		<div align="center" style="color: red">
			<html:errors />
			<br>
		</div>

		<table align="center">
			<tr>
				<td align="right"><bean:message key="label.username.value" />
					:</td>
				<td align="left"><html:text property="username"
						styleId="userid" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="label.password.value" />
					:</td>
				<td align="left"><html:password property="password"
						styleId="password" maxlength="15" /></td>
			</tr>

			<tr>
				<td align="right"><html:submit styleId="loginButton">
						<bean:message key="label.button.submit" />
					</html:submit></td>

				<td align="left"><html:reset>
						<bean:message key="label.button.reset" />
					</html:reset></td>
			</tr>
		</table>
	</html:form>




</body>
</html>
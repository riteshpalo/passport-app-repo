<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">Passport Application</h1>
	<h2>Person Details Form</h2>
	<form:form action="handleNextBtn" method="post" modelAttribute="personDetails">
	<form:hidden path="personId"/>
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<form:radiobutton path="gender" value="male" checked="checked"/>Male
					<form:radiobutton path="gender" value="female"/>Female
				</td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><form:input path="dob" type="date"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type="submit" value="Next"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
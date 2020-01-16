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
	<h1>Application Review Form</h1>
	<form:form action="handleConfirmBtn" method="post" modelAttribute="passportAppDtls">
	<form:hidden path="personId"/>
		<h3><u>Person details:</u></h3>
		<table>
			<tr>
				<td>First Name:</td>
				<td>${personDetails.firstName }</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>${personDetails.lastName }</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${personDetails.email}</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${personDetails.gender}</td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td>${personDetails.dob}</td>
			</tr>
		</table>
		
		<h3><u>Educational Details:</u></h3>
		<table>
			<tr>
				<td>Highest Degree:</td>
				<td>${educationalDetails.highestDegree }</td>
			</tr>
			<tr>
				<td>University:</td>
				<td>${educationalDetails.university }</td>
			</tr>
			<tr>
				<td>Passed Out Year:</td>
				<td>${educationalDetails.passedYear }</td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
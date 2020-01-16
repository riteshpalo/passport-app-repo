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
	<h1>Educational Details Form</h1>
	<form:form action="handleEduNextBtn" method="post" modelAttribute="educationalDetails">
		<form:hidden path="personId"/>
		<table>
			<tr>
				<td>Highest Degree</td>
				<td>
					<form:select path="highestDegree">
						<form:option value="">--select degree--</form:option>
						<form:options items="${degrees }"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>University</td>
				<td>
					<form:select path="university">
						<form:option value="">--select university--</form:option>
						<form:options items="${universities }"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Passed Out Year</td>
				<td>
					<form:select path="passedYear">
						<form:option value="">--select year--</form:option>
						<form:options items="${years }"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><a href="/?personId=${pid }">Previous</a></td>
				<td><input type="submit" value="Next"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
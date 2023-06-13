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
<h1 align="center">item form</h1>
<form:form method="post" modelAttribute="items"> <!-- lowercase pojo class name for form binding -->
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Item Name</td>
				<td><form:input path="itemName" /></td><!-- path value needs to match with property/variable name of pojo -->
			</tr>
			<tr>
				<td>Enter Item Price</td>
				<td><form:input path="price" /></td>
			</tr>
			
			<tr>
				<td>Enter Stock</td>
				<td><form:input type="number" path="stock" /></td>
			</tr>
			<tr>
				<td>Enter per unit (KG/GM)</td>
				<td><form:input path="perUnit" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add item" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
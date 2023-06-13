<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>${requestScope.message}</h5>
<h2>Welcome ${sessionScope.user_details.userName}</h2>
<br>
<a href="<spring:url value='/item/addItem'/>">add a item</a>
<br>
<h3>List of items!!</h3>
<table>
	<c:forEach var="item" items="${requestScope.item_list}">
	<tr>
	<td>Name: ${item.itemName}</td>
	<td>Price: ${item.price}</td>
	<td>Stock: ${item.stock}</td>
	<td>Name of Vendor:${item.vendor}
	<td>Item id: ${item.itemId}	
	<td><a href="<spring:url value='/item/update?id=${item.itemId}'/>">update</a></td>
	<td><a href="<spring:url value='/item/delete?id=${item.itemId}'/>">delete</a></td>
	</tr>
	</c:forEach>
	</table>
	<a href="<spring:url value='/user/logout'/>">logout</a>
</body>
</html>
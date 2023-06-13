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
<h3>List of items!!</h3>
<a href="<spring:url value='/user/goToCart'/>">show cart</a>
<a href="<spring:url value='/user/orders'/>">show orders</a>
<table>
	<c:forEach var="item" items="${requestScope.item_list}">
	<tr>
	<td>Name: ${item.itemName}</td>
	<td>Price: ${item.price}</td>
	
	<td>Name of Vendor:${item.vendor}
	<td>Quantity:<input type="number" placeholder="please enter the quantity">
	<td><a href="<spring:url value='/user/addToCart?itemId=${item.itemId}'/>">add to cart</a></td>
	
	</tr>
	</c:forEach>
	</table>
	<a href="<spring:url value='/logout'/>">logout</a>
</body>
</html>
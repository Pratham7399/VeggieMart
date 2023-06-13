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
<h5>${requestScope.message}${requestScope.msg}</h5>
<h2>Welcome ${sessionScope.user_details.userName}</h2>
<h3>your cart!!</h3>
${sessionScope.cart_details}
<a href="<spring:url value='/user/checkout'/>">checkout</a>
<%-- 
<table>
	<c:forEach var="item" items="${sessionScope.cart_details.orderList}">
	<tr>
	<td>Quant: ${item.quantity}</td>
	<td>Name: ${item.Orderitem.itemName}</td>
	<td>Price: ${item.orderList.price}</td>
	
	<td>Name of Vendor:${item.orderList.vendor}
	
	<td><a href="<spring:url value='/user/addToCart?itemId=${item.itemId}'/>">remove from cart</a></td>
	
	</tr>
	</c:forEach>
	</table>
	 --%>
	 <a href="<spring:url value='/user/logout'/>">logout</a>
</body>
</html>
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
<h3>Payment details</h3>
<a href="<spring:url value='/user/order_placed'/>">Pay</a>
<a href="<spring:url value='/user/list'/>">continue shopping</a>
<a href="<spring:url value='/user/logout'/>">logout</a>
</body>
</html>
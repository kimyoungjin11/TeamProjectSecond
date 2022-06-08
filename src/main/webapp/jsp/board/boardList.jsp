<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String id = null;
	
%>
<div class="container">
	<div class="row">
		<table class="table table-striped" style="text-align:center; border:1px solid">
			<thead>
				<tr>
					<th style="baclground-clolr:#eeeeee; text-align:center;">번호</th>
					<th style="baclground-clolr:#eeeeee; text-align:center;">번호</th>
					<th style="baclground-clolr:#eeeeee; text-align:center;">번호</th>
					<th style="baclground-clolr:#eeeeee; text-align:center;">번호</th>
					<th style="baclground-clolr:#eeeeee; text-align:center;">번호</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${productList}" var="productList">
				<tr>
					<td>${productList.productId}</td>
					<td>${productList.userId}</td>
					<td>${productList.productTitle}</td>
					<td>${productList.productId}</td>
					<td>${productList.productId}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
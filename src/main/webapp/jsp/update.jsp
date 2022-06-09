<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.kosta.project.member.vo.Member"%>
<body style="text-align: center;">
<%
	// session에 있는 info객체를 불러들여서 변수 info에 저장
	Member info = (Member) session.getAttribute("info");
%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<!-- Wrapper -->
	<div id="wrapper">
			<!-- Menu -->
				<nav id="Update">	
				<form action="${path }/MemberUpdateService" method="post"> <%--절대경로 --%>
					
						<h4>회원정보수정</h4></br>
							
								<input name="pw" type="password" placeholder="PW를 입력하세요" style="width: 500px; margin: 0 auto;"></br>
								<input name="tel" type="text" placeholder="전화번호를 입력하세요" style="width: 500px; margin: 0 auto;"></br>
								<input type="submit" value="회원정보수정" class="button fit" style="width: 500px; margin: 0 auto;"></br>
					</form>
				<h4>회원정보삭제</h4><form action="${path }/MemberDeleteService" method="post">
				<input type="text" name="id" placeholder="ID를 입력하세요"style="width: 500px; margin: 0 auto;"><br>
				<input type="password" name="pw" placeholder="PW를 입력하세요" style="width: 500px; margin: 0 auto;"><br>
				<input type="submit" value="회원삭제" style="width: 500px; margin: 0 auto;"><br>
				</form>
				</nav>			
		</div>

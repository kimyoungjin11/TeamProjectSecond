<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 플랫폼, N분의1</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel=stylesheet href="../css/reset.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
* { 
	text-align:center;
	font-family: 'Nanum Gothic', sans-serif;
}
body {
	background-color: #ffea00;
}
#wrap {
	padding-top : 300px;
	width: 100%;
	margin: 0 auto;
}


h1 {
	font-size: 42px;
	font-weight: 900;
	margin-bottom: 15px;
}

p {
	font-size: 18px;
	margin-bottom: 30px;
}

.input_login {

	font-size: 16px;
	padding-left: 18px;
	text-align: left;
	letter-spacing: -1px;
	display: block;
	width: 331px; height: 45px;
	background-color: white;
	border-radius: 15px;
	border: none;
	margin : 0 auto;
	margin-bottom : 10px;
}

.btn_login{
	font-size: 16px;
	letter-spacing: -1px;
	display: block;
	width: 350px; height: 45px;
	background-color: white;
	border-radius: 15px;
	border: none;
	margin : 0 auto;
	margin-bottom : 10px;
	background-color: black;
	color: white;
}
a {
	text-decoration: none;
	color: black;
}
#link a:hover {
	text-decoration: underline;
}
#link a:first-of-type {
	margin-right: 150px;
}
</style>

</head>
<body>
	<div id="wrap">
		<a href="index.jsp"><h1>N분의1</h1></a>
		<p>함께하면 가벼운 소비,<br>세상의 모든 소비를 나눠보세요.</p>
		<c:set var= "path" value="${pageContext.request.contextPath }"/>
		<form  method="post" action="${path}/member/login">
				<input class="input_login" type="text" name="userId" id="userId" placeholder="이메일주소를 입력하세요.">
				<input class="input_login" type="password" name="password" id="password" placeholder="비밀번호를 입력하세요.">
				<input class="btn_login" type="submit" value="로그인">
		</form>
		<div id="link">
			<a href="">아이디/비밀번호 찾기</a>
			<a href="${path}/member/memberEnroll">회원가입</a>
		</div>
	</div>
</body>
</html>
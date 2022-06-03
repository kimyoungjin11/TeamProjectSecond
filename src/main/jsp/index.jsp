<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 플랫폼, N분의1 </title>
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

.land_button {

	font-size: 16px;
	letter-spacing: -1px;
	display: block;
	width: 350px; height: 45px;
	background-color: white;
	border-radius: 15px;
	border: none;
	margin : 0 auto;
	margin-bottom : 10px;
}

.land_button:hover {
	background-color: black;
	color: white;
}

a {
	text-decoration: none;
}

</style>

</head>
<body>
	<div id="wrap">
		<h1>N분의1</h1>
		<p>함께하면 가벼운 소비,<br>세상의 모든 소비를 나눠보세요.</p>
		<form>
			<a href="login.jsp"><input class="land_button" type="button" value="로그인"></a>
			<a href="signup.jsp"><input class="land_button" type="button" value="회원가입"></a>
		</form>
	</div>
</body>
</html>
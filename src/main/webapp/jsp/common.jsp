<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel=stylesheet href="../css/reset.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
header {
	width: 100%;
	height: 100px;
	background-color: #ffea00;
}
#wrap {
	padding-top : 25px;
	width: 1024px;
	margin: 0 auto;
}
#btn_menu img {
display:inline; 
width: 30px; 
margin-right: 140px;
}
#logo img {
display:inline; 
width: 50px;
margin-right: 10px;
}
#logo {
color:black;
font-size: 30px;	
}

#search input {

display:inline;
width: 500px;
height: 30px;
}
</style>
</head>
<body>
	<header>
		<div id="wrap">
			<a href="" id="btn_menu"><img src="../img/header/btn_menu.png" alt="menu"></a>
			<a href="" id="logo"><img src="../img/header/pie.png" alt="logo">N분의1</a>
			<div id="search">
				<form action="search">
					<input type="text" placeholder="검색어를 입력하세요." name="input_search"> 
				</form>
			</div>
		</div>
		
	</header>
</body>
</html>
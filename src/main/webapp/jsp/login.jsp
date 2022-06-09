<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 플랫폼, N분의1</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com"  >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel=stylesheet href="../css/reset.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 
 <script type="text/javascript">
    
    $(function(){
    	var aa = "${msg}";
    	if(aa != "")  	alert(aa);
    });
 </script>
 
 
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
	display :inline-block;
	text-decoration: none;
	color: black;
}
#link a:hover {
	text-decoration: underline;
}
/* #link a:last-of-type {
	margin-left: 150px;
} */

#look_box{
	align-cotent: left;
	display:inline-block;
	margin-right:100px;
}
/* #imgNaver{
	display:block;
	width:10px;
	height:10px;
} */
</style>

</head>
<body>
  <%-- <%
    String clientId = "eqagp0fQve1EtqpGZsux";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://192.168.3.1/TeamProjectSecond/jsp/common.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
  <a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a> --%>
  <!--여기까지.네이버  -->
	<div id="wrap">
		<a href="index.jsp"><h1>N분의1</h1></a>
		<p>함께하면 가벼운 소비,<br>세상의 모든 소비를 나눠보세요.</p>
		<c:set var= "path" value="${pageContext.request.contextPath}"/>
		<script type="text/javascript">
		</script>
		<form  method="post" action="${path}/member/login">
				<input class="input_login" type="text" name="userId" id="userId" placeholder="이메일주소를 입력하세요.">
				<input class="input_login" type="password" name="password" id="password" placeholder="비밀번호를 입력하세요.">
				<div id="imgNaver" >
				<input type="image" class="btn_login" alt="" src="../img/header/btnG_완성형2.png"  height=40px; >
				</div>
				<input class="btn_login" type="submit" value="로그인">
		</form>
		<div id="link">
			<div id="look_box">
			<a href="${path}/member/IdFindCheck"  >아이디</a>
			<a>/비밀번호찾기</a>
			</div>
			<a href="${path}/member/memberEnroll" > 회원가입</a>
		</div>
	</div>
</body>
</html>
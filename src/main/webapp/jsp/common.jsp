<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께하면 가벼운 소비, N분의1</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel=stylesheet href="../css/reset.css">
<link rel=stylesheet href="../css/common.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <%
    String clientId = "eqagp0fQve1EtqpGZsux";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "24NR69ONml";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    System.out.println("code: "+code);
    String state = request.getParameter("state");
    System.out.println("state: "+state);
    String redirectURI = URLEncoder.encode("http://localhost:9090/TeamProjectSecond/jsp/common.jsp", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
/*         out.println(res.toString()); */
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  %>
</head>
<body>


	<!-- TOP버튼 -->

	<span id="tothetop"><img src="../img/header/top.png" alt="top"></span>
	<div id="wrap">
<%@ include file="/jsp/header.jsp"%>
	
		<!-- SECTION -->
		
		<section>
			<h1>물품등록</h1>
		
		
		</section>
		
		
<%@ include file="/jsp/footer.jsp"%>
	</div>
</body>
</html>
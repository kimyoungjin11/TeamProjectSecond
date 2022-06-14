<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께하면 가벼운 소비, N분의1</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel=stylesheet href="../css/reset.css">
<link rel=stylesheet href="../css/common.css?after">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%
String clientId = "eqagp0fQve1EtqpGZsux";//애플리케이션 클라이언트 아이디값";
String clientSecret = "24NR69ONml";//애플리케이션 클라이언트 시크릿값";
String code = request.getParameter("code");
System.out.println("code: " + code);
String state = request.getParameter("state");
System.out.println("state: " + state);
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
System.out.println("apiURL=" + apiURL);
try {
	URL url = new URL(apiURL);
	HttpURLConnection con = (HttpURLConnection) url.openConnection();
	con.setRequestMethod("GET");
	int responseCode = con.getResponseCode();
	BufferedReader br;
	System.out.print("responseCode=" + responseCode);
	if (responseCode == 200) { // 정상 호출
		br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	} else { // 에러 발생
		br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	}
	String inputLine;
	StringBuffer res = new StringBuffer();
	while ((inputLine = br.readLine()) != null) {
		res.append(inputLine);
	}
	br.close();
	if (responseCode == 200) {
		/*         out.println(res.toString()); */
	}
} catch (Exception e) {
	System.out.println(e);
}
%>
</head>
<style>
body {
	background-color: #f9f9f9;
}
</style>
<body>

	<div id="section-body"text-align:center;>
		<%@ include file="/jsp/header.jsp"%>

		<br> <br> <br> <br> <br> <br> <br>
		<br>
		<!-- SECTION -->
		<div class="searchbody">

			<div class="form_group">
				<label>카테고리</label> <select name="category_id" id="category_id">
					<option>전체</option>
					<c:forEach items="${clist}" var="category">
						<option value="${category.category_id}">${category.category_name}</option>
					</c:forEach>
				</select>


				<fieldset style="display: inline;">
					<input type="radio" name="productSort" value="desc"
						checked="checked">최신순 <input type="radio"
						name="productSort" value="asc">과거순
				</fieldset>
			</div>
		</div>
		<br> <br>
		<div class="container">
			<div id="here">

				<div class="row">
					<ul class="list-wrapper">

						<c:forEach items="${productList}" var="productList">
							<li>
								<div id="product-img">
									<span
										id="/TeamProjectSecond/product/view.do?productId=${productList.productId}">${productList.productStatus}</span>
									<a href=""> <!-- <img src="#" /> -->
									</a>
								</div>

								<div id="product-info">
									<a
										href="/TeamProjectSecond/product/view.do?productId=${productList.productId}"
										id="title">${productList.productTitle}</a> <span id="price">${productList.price}원</span>
									<%-- <span id="userid">${productList.userId}</span> --%>
									<span id="date">${productList.reg_date}</span>

								</div>
							</li>
						</c:forEach>

					</ul>
				</div>
			</div>
		</div>

		<br> <br> <br>

		<script>
			$(function() {

				$.ajax({
					url : "../listProduct.do",
					data : {
						"category_id" : "%",
						"keyword" : "%",
						"sort" : "desc"
					},
					type : "post",
					success : function(responseData) {

						$("#here").html(responseData);
					}
				});

				$("#input_search").on("keydown", function(event) {

					if (event.keyCode == 13) {
						$.ajax({
							url : "../listProduct.do",
							data : {
								"category_id" : "%",
								"keyword" : $(this).val(),
								"sort" : "desc"
							},
							type : "post",
							success : function(responseData) {

								$("#here").html(responseData);
							}
						});
					}
				});
			});
		</script>


		<%@ include file="/jsp/footer.jsp"%>
	</div>

</body>
</html>
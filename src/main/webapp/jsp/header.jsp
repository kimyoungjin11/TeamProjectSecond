<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function(){
		/* TOP버튼 */
		$("#tothetop").click(function(){
			$('body, html').animate({scrollTop:0}, 400);
			return false;
		});
		
        /*category hover*/      
        $(".dropdown").mouseenter(function(){
  		  $(this).children(".dropdown-content").stop().slideDown(400);
  		});
  		$(".dropdown").mouseleave(function(){
  		  $(this).children(".dropdown-content").stop().slideUp(100);
  		});
	});
</script>
	<!-- TOP버튼 -->
	<span id="tothetop"><img src="../img/header/top.png" alt="top"></span>
	<!-- 글 작성 버튼 -->
	<c:set var= "path" value="${pageContext.request.contextPath}"/>
	<span id="insertBtn"><a href="${path}/jsp/productInsert.do"><img src="../img/header/insertBtn.png" alt="insert"></a></span>
	<!-- HEADER -->
		<header>
			<div id="header_wrap">
				<div id="header_left">
					<div class="dropdown">
						<p class="dropbtn" id="btn_menu"><img src="../img/header/btn_menu.png"
						alt="menu"></p>
						<div class="dropdown-content" id="category" class="skip">
							<ul>
								<li><a href="">OTT구독</a></li>
								<li><a href="">여행상품</a></li>
								<li><a href="">생활용품</a></li>
								<li><a href="">식품</a></li>
								<li><a href="">여성의류</a></li>
								<li><a href="">남성의류</a></li>
							</ul>
						</div>
					</div>
					<a href="../jsp/index.jsp" id="logo"><img src="../img/header/logo.png" alt="logo"></a>
				</div>
				<div id="header_center">
					<div id="search">
						<form action="search.do">
							<input type="text" placeholder="검색어를 입력해주세요." name="input_search">
							<a href="" id="btn_search"><img src="../img/header/search.png"
								alt="search"></a>
						</form>
					</div>
				</div>
				<div id="header_right">

					<c:if test="${loginMember != null}">
					<c:set var= "path" value="${pageContext.request.contextPath}"/>
					<a id="btn_mypage" href="#"><img src="../img/header/mypage.png" alt="mypage">마이페이지</a> 
					
					<a href="${path}/member/logout" id="btn_logout"><img src="../img/header/logout.png" alt="logout">로그아웃</a>
				   </c:if>
	
				</div>
			</div>
		</header>

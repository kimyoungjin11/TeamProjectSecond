<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>boardList_jsp</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel=stylesheet href="css/reset.css">
<link rel=stylesheet href="css/boardList.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
body {
  background-color: #f9f9f9;
}
</style>

</head>
<body>
<div id="wrap">
<%-- <%@ include file = "../header.jsp" %> --%>
	<div class="container">

		<div class="form_group">
			<label>카테고리</label> 
			<select name="category_id" id="category_id">
				<option>전체</option>
				<c:forEach items="${clist}" var="category">
					<option value="${category.category_id}">${category.category_name}</option>
				</c:forEach>
			</select>

			<input type="search" name="keyword"  id="keyword"> SORT:
			<fieldset style="display: inline;">
				<input type="radio" name="productSort" value="desc"
					checked="checked">최신순 
				<input type="radio"
					name="productSort" value="asc">과거순
			</fieldset>
			<button id="btnSearch">검색</button>
			<br> <br>


		</div>
		<div id="here">
			<div class="row">
				<ul class="list-wrapper">


					<c:forEach items="${productList}" var="productList">
						<li>
							<div id="product-img">
								<span id="/TeamProjectSecond/product/view.do?productId=${productList.productId}" >${productList.productStatus}</span> 
								<a href=""> <!-- <img src="#" /> -->
								</a>
							</div>

							<div id="product-info">
								<a href="/TeamProjectSecond/product/view.do?productId=${productList.productId}" id="title">${productList.productTitle}</a> <span
									id="price">${productList.price}원</span> 
									<%-- <span id="userid">${productList.userId}</span> --%>
								<span id="date">${productList.reg_date}</span>
								<span class="godd" id="viewCount">조회수:${productList.viewCount}</span>

							</div>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
	</div>
	

	<script>
	  $(function(){
		  $('#btnSearch').click(function(){
			 //
			 var category_id = $("#category_id").val();
			 var keyword = $("#keyword").val();
			 var sort = $("input[name='productSort']:checked").val();
			 //alert(category_id + ":" + keyword + ":" + sort);
			 $.ajax({
				 url:"listProduct.do",
				 data:{"category_id":category_id,
						"keyword":keyword, "sort":sort},
				 type:"post",
				 success:function(responseData){
					 
					 $("#here").html(responseData);
				 }
			 });
		  });
	  });
	
	
	</script>
	
<%-- <%@ include file = "../footer.jsp" %> --%>
</div>
</body>
</html>
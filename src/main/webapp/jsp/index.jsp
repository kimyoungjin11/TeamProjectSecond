<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께하면 가벼운 소비, N분의1</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel=stylesheet href="../css/reset.css">
<link rel=stylesheet href="../css/common.css?after">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 
</head>
<body>
	<div id="wrap">
		<%-- <%@ include file="/jsp/header.jsp"%> --%>
		<jsp:include page="header.jsp"></jsp:include>
			
			<!-- SECTION -->
			
		<section>
			<div id="here">
			</div>
		</section>
				
		<%-- <%@ include file="/jsp/footer.jsp"%> --%>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script>

		  $(function(){
			  
			  
			  $.ajax({
					 url:"../listProduct.do",
					 data:{"category_id":"%",
							"keyword":"%", "sort":"desc"},
					 type:"post",
					 success:function(responseData){
						 
						 $("#here").html(responseData);
					 }
				 });
			  

			  $("#input_search").on("keydown", function(event){
				  
				  if(event.keyCode == 13) {  
						 $.ajax({
							 url:"../listProduct.do",
							 data:{"category_id":"%",
									"keyword":$(this).val(), "sort":"desc"},
							 type:"post",
							 success:function(responseData){
								 
								 $("#here").html(responseData);
							 }
						 });
				  }
			  });
		  });
		
		</script>
</body>
</html>
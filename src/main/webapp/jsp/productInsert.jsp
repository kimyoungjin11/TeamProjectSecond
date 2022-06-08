<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="../css/productInsert.css">
<title>조인 만들기</title>
<script>
	/* $(function(){
		
	}); */
</script>
</head>
<body>
	<%
        String userId = null;
        if(session.getAttribute("userId") != null) {
            userId = (String) session.getAttribute("userId"); //로그인한 사람들은 해당아이디가 userID에 저장
        }
    %>
	<section>
		<h1>조인 만들기</h1>
		<form action="InsertProduct.do" method="post" enctype="multipart/form-data">
			<div class="form_group">
				<label>카테고리</label>
				<select name="category_id">
					<c:forEach items="${clist}" var="category">
		   				<option value="${category.category_id}" >${dept.category_name}</option>
		 			</c:forEach>
				</select>
			</div>
			<div class="form_group">
				<label>제목</label>
				<input type="text" name="title" maxlength="50">
			</div>
			<div class="form_group">
				<label>총액</label>
				<input type="text" name="price">
			</div>
			<div class="form_group">
				<label>조인인원</label>
				<input type="number" name="join_number">
			</div>
			<div class="form_group">
				<label>예상 1/N가격</label>
			</div>
			<div class="form_group">
				<label>사진1</label>
				<input type="file" name="imgs">
			</div>
			<div class="form_group">
				<label>사진2</label>
				<input type="file" name="imgs">
			</div>
			<div class="form_group">
				<label>사진3</label>
				<input type="file" name="imgs">
			</div>
			<div class="form_group">
				<label>사진4</label>
				<input type="file" name="imgs">
			</div>
			<div class="form_group">
				<label>사진5</label>
				<input type="file" name="imgs">
			</div>
			<div class="form_group">
				<label>내용</label>
				<input type="text" name="context" class="form_context">
			</div>
			<div class="insert_btn">
				<input type="submit" value="등록">
				<input class="btn btn-secondary" type="reset" value="취소">	
			</div>
			
		</form>
	</section>
	
</body>
</html>
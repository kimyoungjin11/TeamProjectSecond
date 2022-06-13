<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel=stylesheet href="../css/reset.css">
<link rel=stylesheet href="../css/boardDetail.css">

</head>
<body>
	<div class=board-wrapper>
		<div class=category></div>
		<div class=title-wrapper>
			<div id=item-img>
				<div id=img-bag>
					<img src="../img/testimg/gogood.jpg" alt="상품">
				</div>
			</div>
			<div id=item-info>
				<div id=item-title>
					<span>${productView.productTitle}</span> <span id=item-date>${productView.userId}</span>
					<div>
						<span id=item-price>${productView.price}</span> <span
							id=join-number>/${productView.joinNumber}</span>
					</div>
				</div>
				<div id=item-ect>
					<span class=item-ect-class> <img
						src="../img/testimg/eye-outline.svg" alt="조회수">${productView.viewCount}
					</span> <span class=item-ect-class> <img
						src="../img/testimg/heart-outline.svg" alt="조회수">${productView.wishCount}
					</span>
				</div>
				<div id=item-sssss>${productView.productContent}</div>
				<div id=item-buy>

					<button id=heart>
						<img src="../img/testimg/heart.svg" alt="조회수">${productView.wishCount}</button>
					<button id=buy>구매하기</button>
				</div>


			</div>

		</div>

		<div class=board-contents>
			내용 </br> </br> </br> </br>
		</div>


		<div class="card">
			<form method="POST">
				<input type="hidden" id="userId" value="${principal.user.id}" /> <input
					type="hidden" id="boardId" value="${board.id}" />
				<div class="card-body">
					<textarea style="width:90%; display:inline-block;" id="reply-content" class="form-control" rows="1"></textarea>
					<button type="button" style="float:right; " id="btn-reply" class="btn btn-primary">댓글등록</button>
				</div>
			
			</form>
		</div>

		<div class=board-reply-wrapper>
			<div class="card">
				<div class="card-header">댓글 리스트</div>
				<ul id="reply--box" class="list-group">
					<c:forEach var="reply" items="${board.replys}">
						<li id="reply-${reply.id}"
							class="list-group-item d-flex justify-content-between">
							<div>aaaaaa</div>
							<div class="d-flex">
								<div class="font-italic">
									작성자 : ${reply.user.nickname} <br /> ${reply.createDate} &nbsp;
								</div>
								<c:if test="${board.user.id == principal.user.id}">
									<button onclick="index.replyDelete(${board.id}, ${reply.id})"
										class="btn btn-warning badge">삭제</button>
								</c:if>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	<script>
	$("#btn-reply").on(click, function() {
		let data = {
			userId: $("userId").val(),
			boardId: $("boardId").val(),
			content: $("reply-content").val()
		};
		$.ajax({
			url: '<%=request.getContextPath() %>/reply.do',
			type: 'POST',
			data: JSON.stringify(data),
			dataType: 'json'
		}).done(function(resp) {
			alert("댓글작성이 완료되었습니다.");
			location.href = `<%=request.getContextPath() %>/reply.do`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	});
	</script>
	

</body>
</html>
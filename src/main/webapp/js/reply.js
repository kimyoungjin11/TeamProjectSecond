$("#btn-reply-save").click(function() {
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
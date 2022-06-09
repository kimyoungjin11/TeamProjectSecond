<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입 화면 샘플 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>
    body {
      min-height: 100vh;

      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
    }

    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
</head>

<body>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
  <div class="container">
       
       
       
      
  
  
  
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원가입</h4>
        <c:set var= "path" value="${pageContext.request.contextPath }"/>
        <form class="validation-form" method="post" action="${path}/member/memberEnroll" novalidate>
        
         <div class="mb-3">
            <label for="email">아이디</label>
            <input type="email" class="form-control" id="userId" name="userId" placeholder="이메일형식" required >@
            <select id="select" class="form-control" id="userId">
            <option value="" disabled selected>E-Mail 선택</option>
            <option value="naver.com" id="naver.com">naver.com</option>
            <option value="hanmail.net" id="hanmail.net">hanmail.net</option>
            <option value="gmail.com" id="gmail.com">gmail.com</option>
            <option value="nate.com" id="nate.com">nate.com</option>
            <option value="directly" id="textEmail">직접 입력하기</option>
        </select>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>
       
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="userName" name="userName" placeholder="" value="" required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            
            <div class="col-md-6 mb-3">
              <label for="nickname">별명</label>
              <input type ="button"style="padding:1px 1px; font-size:15px;" id="duplicateCheckBtn" value="중복체크">
              <span id="message"></span>
              <input type="text" class="form-control" id="nickName" name="nickName" placeholder="" value="" required>
              <div class="invalid-feedback">
                별명을 입력해주세요.
              </div>
            </div>
          </div>

    

          <div class="mb-3">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="userPassword" name="userPassword"  required>
            <div class="invalid-feedback">
       
            </div>
          </div>

		<div>
		<label for="phone" >휴대폰번호</label>
		<input type="text" id="phone" name="phone" class="form-control" style="width:100px;height:30px;font-size:30px; display:inline-block;margin-left:10px; ">
		<input type="text" id="phone" name="phone" class="form-control" style="width:100px;height:30px;font-size:30px; display:inline-block;margin-left:10px;">
		<input type="text" id="phone" name="phone" class="form-control" style="width:100px;height:30px;font-size:30px; display:inline-block;margin-left:10px;">
		</div>
          <!-- div class="mb-3">
            <label for="address2">비밀번호 확인<span class="text-muted">&nbsp;(필수 아님)</span></label>
            <input type="text" class="form-control" id="address2" placeholder="상세주소를 입력해주세요.">
          </div -->
		
         
           </select>
         
      
            </div>
          </div>
          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 YD</p>
    </footer>
  </div>
  <script>
    $(function() {
        $('#select').change(function() {
            if ($('#select').val() == 'directly') {
                $('#textEmail').attr("disabled", false);
                $('#textEmail').val("");
                $('#textEmail').focus();
            } else {
                $('#textEmail').val($('#select').val());
            }
        })
    });
</script>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  
    
   $(function (){
    	$("#duplicateCheckBtn").click(function(){
    		var nickName = $("#nickName").val();
    		alert(nickName);
    		if(nickName==""||nickName==null){
    			alert("별명은 필수입력입니다.");
    			$("#nickName").focus();
    			return;
    		}
    		$.ajax({
    			url:"${path}/member/nickname",
    			data:{"nickname":$("#nickName").val() },
    			type:"get",
    			success: function(responseData){
    				//중복:1, 중복안됨:0
    				$("#message").html(responseData==1?"이미 존재하는 별명입니다.":"사용가능합니다.");
    			},
    			fail:function(){}
    		});
    	});
    });
    
    
    
    
  </script>
</body>

</html>

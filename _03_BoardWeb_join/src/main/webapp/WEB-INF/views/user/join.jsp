<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="C:\Users\USER\Desktop\project_togaether\BIT_TOGAETHER\5조(김예지, 조유미, 성문식, 이기쁨, 박준현)\css" rel="stylesheet" type="text/css">
<style>
	.form-wrapper {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	#joinForm {
		width: 250px;
		text-align: center;
	}
	
	#joinForm .label-wrapper {
		margin-top: 20px;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	#joinForm input {
		width: 100%;
	}
	
	#joinForm div {
		display: flex;
		align-items: center;
	}
	
	#btnIdCheck {
		width: 50px;
	}
</style>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div class="form-wrapper">
		<form id="joinForm" action="/user/join.do" method="post">
			<h3>회원가입</h3>
			<div class="label-wrapper">
				<label for="userId">아이디</label>
			</div>
			<div>
				<input type="text" id="userId" name="userId" required style="width: auto;">
				<button type="button" id="btnIdCheck" style="width: 70px">중복체크</button>
			</div>
			<div class="label-wrapper">
				<label for="userPw">비밀번호</label>
			</div>
			<input type="password" id="userPw" name="userPw" required>
			<p id="pwValidation" style="color: red; font-size: 0.8rem"> 비밀번호는 영문자, 숫자, 특수문자 조합의 9자리 이상으로 설정 부탁</p>
			<div class="label-wrapper">
				<label for="userPwCheck">비밀번호 확인</label>
			</div>
			<input type="password" id="userPwCheck" name="userPwCheck" required>
			<p id="pwCheckResult" style="font-size:0.8rem"></p>
			<div class="label-wrapper">
				<label for="userNm">이름</label>
			</div>
			<input type="text" id="userNm" name="userNm" required>
			<div class="label-wrapper">
				<label for="userMail">이메일</label>
			</div>
			<input type="email" id="userMail" name="userMail" required>
			<div class="label-wrapper">
				<label for="userTel">전화번호</label>
			</div>
			<input type="text" id="userTel" name="userTel" placeholder="숫자만 입력하세요.">
			<div style="display: block; margin: 20px auto;">
				<button type="submit">회원가입</button>
			</div>
		</form>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	<script>
		$(function() {
			//id 중복체크가 됐는지 확인하는 변수
			let checkId = false;
			let pwValidation = false;
			let pwCheck = false;
			
			//p태그 처음에는 숨김
			$("#pwValidation").hide();
			$("#pwCheckResult").hide();
			
			//id 중복체크
			$("#btnIdCheck").on("click", function() {
				if($("#userId").val() == null || $("#userId").val() == '') {
					alert("아이디를 입력하세요.");
					return;
				}
				
				$.ajax({
					url: '/user/idCheck.do',
					type: 'post',
					data: $("#joinForm").serialize(),
					success: function(obj) {
						console.log(obj);
						
						const data = JSON.parse(obj);
						
						console.log(data);
						console.log(data.resultIdCheck);
						
						if(data.resultIdCheck < 1) {
							if(confirm("사용가능한 아이디입니다. " + $("#userId").val() + "를(을) 사용하시겠습니까?")) {
								checkId = true;
								$("#btnIdCheck").attr("disabled", true);
							}
						} else {
							checkId = false;
							alert("이미 존재하는 아이디입니다.");
							$("#userId").focus();
							return;
						}
					},
					error: function(e) {
						console.log(e);
					}
				});
			});
			
			$("#userId").on("change", function(){
				checkId = false;
				$("#btnIdCheck").attr("disabled", false);
			});
			
			//비밀번호 유효성 검사
			function validatePassword(character){
				return /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{9,}$/.test(character)
			}
			
			$("#userPw").on("change", function(){
				if(!validatePassword($("#userPw").val())){
					pwValidation = false;
					$("#pwValidation").show();
					$("#userPw").focus();
				}else{
					pwValidation = true;
					$("#pwValidation").hide();
				}
				//비밀번호 값이 바뀌었을 때 
				if($("#userPw").val()== $("#userPwCheck").val()){
					pwCheck = true;
					$("#pwCheckResult").css("color", "green");
					$("#pwCheckResult").text("비밀번호 일치");
				} else{
					pwCheck = false;
					$("#pwCheckResult").css("color", "red");
					$("#pwCheckResult").text("비밀번호 불일치");
				} 
			});
			
			//비밀번호 확인
			$("#userPwCheck").on("change", function(){ //userPwCheck가 바뀔때마다
				$("#pwCheckResult").show();
				if($("#userPw").val()== $("#userPwCheck").val()){
					pwCheck = true;
					$("#pwCheckResult").css("color", "green");
					$("#pwCheckResult").text("비밀번호 일치");
				} else{
					pwCheck = false;
					$("#pwCheckResult").css("color", "red");
					$("#pwCheckResult").text("비밀번호 불일치");
				}
			});
			
			//회원가입할 (회원가입 폼 서브밋될)때 마지막 유효성 검사
			//아래의 경우 서브밋이 안되도록
			$("#joinForm").on("submit", function(e){
				if(!checkId){
					alert("ID 중복 체크 부탁");
					$("#userId").focus();
					e.preventDefault();
					return;
				}
				
				if(!pwValidation){
					alert("비밀번호는 영문자, 숫자, 특수문자 조합의 9자리 이상으로 설정 부탁");
					$("#userPw").focus();
					e.preventDefault();
					return;
				}
				
				if(!pwCheck){
					alert("비밀번호 불일치");
					$("#userPwCheck").focus();
					e.preventDefault();
					return;
				}	
			});
		});
	</script>
</body>
</html>
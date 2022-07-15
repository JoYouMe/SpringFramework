<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TOGAETHER</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>
    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app2.css">
        <!-- fabicon -->
    <link rel="icon" href="${pageContext.request.contextPath }/favicon.ico">
    <!-- jquery-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <!--버튼에 회원가입 onclick 넣기, 색깔 없에고 글자 주황, 체크 인풋박스, 체크코드 -->
</head>
<body>
    <div class="login-form">

        <div class="container">
            <img src="${pageContext.request.contextPath}/images/logo.png" width="100px" height="100px" alt="logo" onclick="location.href='index.html'">
        </div>

        <br>
        <h2>로그인</h2>

        <form id="loginForm">
            <input type="text" id="userId" name="userId" class="text-field" placeholder="ID" required>
            <input type="password" id="userPw" name="userPw" class="text-field" placeholder="PW" required>
            <input type="button" id="btnLogin" name="btnLogin" value="로그인" class="submit-btn">
        </form>

        <div class="links">
            <div class="idpw">
                <a href="forgot_id.html">아이디 찾기</a>
                <a href="forgot_id.html">비밀번호를 잊으셨나요?</a>
            </div>
            <div>
                <p>아직회원이 아닌가요?
                    <a href="signup.html">회원가입</a>
                </p>
            </div>
        </div>

        <div>
            <hr class="line">
            </hr>
            <p>
                <h6>간편 로그인</h6>
            </p>
        </div>

        <div class="logo">
            <img src="https://yaimg.yanolja.com/joy/sunny/static/images/img-login-kakao-52.svg" width="52px"
                height="52px" alt="페북">
            <img src="https://yaimg.yanolja.com/joy/sunny/static/images/img-login-naver-52.svg" width="52px"
                height="52px" alt="카카오">
            <img src="https://cdn6.agoda.net/images/universal-login/google-logo-v2.svg" width="52px" height="52px"
                alt="구글">
        </div>
    </div>
    <jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	<script>
		//로그인 시 아이디나 비밀번호가 틀렸을 경우를
		//대비하여 폼을 서브밋 하지 않고
		//후 처리를 위해 ajax로 처리
		$(function() {
			$("#btnLogin").on("click", function() {
				$.ajax({
					url: '/user/login.do',
					type: 'post',
					data: $("#loginForm").serialize(),
					success: function(obj) {
						const data = JSON.parse(obj);
						//1. 아이디 체크
						if(data.message == 'idFail') {
							alert("존재하지 않는 아이디입니다.");
							return;
						} else if(data.message == 'pwFail') {
							//2. 비밀번호 체크
							alert("비밀번호가 틀렸습니다.");
							return;
						}
						
						//3. 로그인 처리
						location.href = "/index.jsp";
					},
					error: function(e) {
						console.log(e);
					}
				});
			});
		});
	</script>
</body>
</html>
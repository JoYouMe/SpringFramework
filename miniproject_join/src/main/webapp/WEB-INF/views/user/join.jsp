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
    <!-- jquery-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <!--버튼에 회원가입 onclick 넣기, 색깔 없에고 글자 주황, 체크 인풋박스, 체크코드 -->
</head>
<body>

    <script>
        var chk = document.querySelector("input[name=test1]").checked;
        console.log(chk);
    </script>

    <div class="signup-form">
   
        <div class="container">
            <img src="${pageContext.request.contextPath }/images/logo.png" width="100px" height="100px" alt="logo" onclick="location.href='index.html'">
        </div>

        <h2>회원가입</h2>
        <p>
            <h6>간편가입</h6>
        </p>

        <div class="logo2-3">
            <img src="https://yaimg.yanolja.com/joy/sunny/static/images/img-login-kakao-52.svg" width="52px"
                height="52px" alt="페북">
            <img src="https://yaimg.yanolja.com/joy/sunny/static/images/img-login-naver-52.svg" width="52px"
                height="52px" alt="카카오">
            <img src="https://cdn6.agoda.net/images/universal-login/google-logo-v2.svg" width="52px" height="52px"
                alt="구글">
        </div>

        <form >
            <div class="id-img">
                <input type="text" name="id" class="text-field" placeholder="ID" required>
                <button type="button" class="chkId2" id="chkbutton">
                    <img src="https://cdn-icons-png.flaticon.com/128/3917/3917749.png" alt="id확인" id="chkimg">
                    <script>
                        $(function () {
                            $("#chkimg").on("click", function () {
                                $("#chkimg").attr("src",
                                    "https://cdn-icons-png.flaticon.com/128/7079/7079987.png")
                            });
                        });
                    </script>
                </button>
            </div>
            <input type="password" name="pw" class="text-field" placeholder="PW" required>
            <input type="password" name="pw" class="text-field" placeholder="비밀번호확인" required>
            <input type="number" name="pw" class="text-field" placeholder="핸드폰 번호" required>
            <input type="email" name="pw" class="text-field" placeholder="이메일" required>
            <div class="dropdown">
                <button class="btn dropdown-toggle btn-box" type="button" id="dropdownMenuButton1"
                    data-bs-toggle="dropdown" aria-expanded="false">
                    반려동물
                </button>

                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <li><a class="dropdown-item" href="#">소형견</a></li>
                    <li><a class="dropdown-item" href="#">중형견</a></li>
                    <li><a class="dropdown-item" href="#">대형견</a></li>
                </ul>
            </div>
        </form>
        <div>
            <input type="submit" value="회원가입" class="submit-btn" onclick="location.href='complete.html'">
        </div>
    </div>
</body>
</html>
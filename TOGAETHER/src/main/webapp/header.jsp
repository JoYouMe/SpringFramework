<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app1.css">
        <!-- fabicon -->
    <link rel="icon" href="${pageContext.request.contextPath }/favicon.ico">
    <!-- jquery-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <!--버튼에 회원가입 onclick 넣기, 색깔 없에고 글자 주황, 체크 인풋박스, 체크코드 -->
</head>
<body>
	<header class="container">
            <!-- navbar -->
            <nav id="mainNavbar" class="navbar navbar-dark navbar-expand-md py-0 fixed-top main_page_navbar">
                <a href="index.html" class="navbar-brand">TO GAE THER<br><span class="kr-logo">투개더</span></a>
                <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navLinks"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navLinks">
                    <ul class="navbar-nav ms-auto navbar-center">
                    <c:choose>
                    	<c:when test="${loginUser eq null }">
	                        <li class="nav-item">
	                            <a href="#" class="nav-link">지 도</a>
	                        </li>
	                        <li class="nav-item">
	                            <a href="/user/join.do" class="nav-link">회원가입</a>
	                        </li>
	                        <li class="nav-item">
	                            <a href="/user/login.do" class="nav-link">로그인</a>
	                        </li>
	                        <li class="nav-item">
	                            <a href="#" class="nav-link">Q&A</a>
	                        </li>
	                 	</c:when>
	                 	<c:otherwise>
	                 		<li class="nav-item">
                            	<a href="/insertComp.do" class="nav-link">등 록</a>
                        	</li>
	                 		<li class="nav-item">
                            	<a href="#" class="nav-link">여 행</a>
                        	</li>
                       		<li class="nav-item">
                            	<a href="#" class="nav-link">식 당</a>
                        	</li>
                        	<li class="nav-item">
                            	<a href="#" class="nav-link">카 페</a>
                        	</li>
                        	<li class="nav-item dropdown">
                            	<a href="" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">더보기</a>
	                            <div class="dropdown-menu">
	                                <a href="map.html" class="dropdown-item">지도</a>
	                                <a href="/user/mypage.do" class="dropdown-item">${loginUser.userId }</a>
	                                <a href="qna.html" class="dropdown-item">Q&A</a>
	                                <a href="/user/logout.do" class="dropdown-item" onclick="alert('로그아웃되었습니다.')">로그아웃</a>
	                            </div>
                        	</li>	
	                 	</c:otherwise>
                     </c:choose>
                    </ul>
                </div>
            </nav>

            <!-- search bar -->
            <div class="search-box fixed-top">
                <div class="search-container">
                    <div class="search-input">
                        <a href="#">
                            <input type="text" placeholder="어떤 서비스가 필요하세요?" disabled>
                            <button type="submit" class="search-button">
                                <img class="search-img" src="${pageContext.request.contextPath }/images/search.png" alt="search">
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </header>
</body>
</html>


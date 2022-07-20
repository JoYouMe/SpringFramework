<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app4.css">
        <!-- fabicon -->
    <link rel="icon" href="${pageContext.request.contextPath }/favicon.ico">
    <!-- jquery-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <!--버튼에 회원가입 onclick 넣기, 색깔 없에고 글자 주황, 체크 인풋박스, 체크코드 -->
    
</head>
<body>
	<div>
		<h2 style="margin: auto 0;">업체 등록<hr style="width: 100%;"></h2>
        	<div class="reservation_details">
            	<h5>시설 안내</h5>
                <table>
                	<tr>
                    <th>편의 서비스</th>
                    <span id="td1"><td><img id="res_img" src="images/wifi.png">&nbsp인터넷/WIFI</td></span>
                    <td><img id="res_img" src="images/pet.png">&nbsp애완동물 동반 가능</td>
                    </tr>
                    <tr>
                    	<th>편의 시설</th>
                        <td><img id="res_img" src="images/mart.png">&nbsp편의점</td>
                        <td><img id="res_img" src="images/waterful.png">&nbsp수영장(하절기)</td>
                        <td><img id="res_img" src="images/parking.png">&nbsp주차장</td>
                    </tr>
                </table>
			</div>              
	</div>
</body>
</html>
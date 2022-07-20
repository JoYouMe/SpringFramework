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
    <!--��ư�� ȸ������ onclick �ֱ�, ���� ������ ���� ��Ȳ, üũ ��ǲ�ڽ�, üũ�ڵ� -->
    
</head>
<body>
	<div>
		<h2 style="margin: auto 0;">��ü ���<hr style="width: 100%;"></h2>
        	<div class="reservation_details">
            	<h5>�ü� �ȳ�</h5>
                <table>
                	<tr>
                    <th>���� ����</th>
                    <span id="td1"><td><img id="res_img" src="images/wifi.png">&nbsp���ͳ�/WIFI</td></span>
                    <td><img id="res_img" src="images/pet.png">&nbsp�ֿϵ��� ���� ����</td>
                    </tr>
                    <tr>
                    	<th>���� �ü�</th>
                        <td><img id="res_img" src="images/mart.png">&nbsp������</td>
                        <td><img id="res_img" src="images/waterful.png">&nbsp������(������)</td>
                        <td><img id="res_img" src="images/parking.png">&nbsp������</td>
                    </tr>
                </table>
			</div>              
	</div>
</body>
</html>
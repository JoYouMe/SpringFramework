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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app1.css">
        <!-- fabicon -->
    <link rel="icon" href="${pageContext.request.contextPath }/favicon.ico">
    <!-- jquery-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <!--버튼에 회원가입 onclick 넣기, 색깔 없에고 글자 주황, 체크 인풋박스, 체크코드 -->
</head>
<body class="mainBg">
	<jsp:include page="./header.jsp"></jsp:include>

    <!-- main page loader -->
    <div class="loader">
        <iframe id="dogGif" src="https://giphy.com/embed/LRrc3OGe0cbrNO5US5" width="480" height="296" frameBorder="0"
            class="giphy-embed" allowFullScreen></iframe>
        <p>
            TOGAETHER
        </p>
    </div>


    <div class="container">
        <div class="main-container">
            <!-- silde category header -->
            <header class="row">
                <a href="list_hotel.html" class="category col-4">
                    <div class="category-header">
                        <div class="categoryText">
                            <img src="images/hotel.png" alt="여행">
                            여행
                        </div>
                        <div>
                            <span class="more-info">더보기+</span>
                        </div>
                    </div>
                </a>
                <a href="list_restaurant.html" class="category col-4">
                    <div class="category-header">
                        <div class="categoryText">
                            <img src="images/room-service.png" alt="식당">
                            식당
                        </div>
                        <div>
                            <span class="more-info">더보기+</span>
                        </div>
                    </div>
                </a>
                <a href="list_cafe.html" class="category col-4">
                    <div class="category-header">
                        <div class="categoryText">
                            <img src="images/breakfast.png" alt="카페">
                            카페
                        </div>
                        <div>
                            <span class="more-info">더보기+</span>
                        </div>
                    </div>
                </a>
            </header>

            <!-- silde pointer -->
            <a class="prev" onclick="plusSlides(-1)">❮❮</a>
            <a class="next" onclick="plusSlides(1)">❯❯</a>

            <!-- silde -->
            <section>
                <div class="main-carousel">
                    <!-- 1st silde -->
                    <div class="mainSlides row fade">
                        <div class="mainSlide-div col-4">
                            <a href="details_hotel.html">
                                <figure>
                                    <img src="images/JS애견풀빌라_여행.jpg" alt="JS 애견 풀빌라">
                                    <figcaption>JS 애견 풀빌라</figcaption>
                                </figure>
                            </a>
                        </div>
                        <div class="mainSlide-div col-4">
                            <a href="details_restaurant.html">
                                <figure>
                                    <img src="images/초원행_식당.jpg" alt="초원행">
                                    <figcaption>초원행</figcaption>
                                </figure>
                            </a>
                        </div>
                        <div class="mainSlide-div col-4">
                            <a href="details_cafe.html">
                                <figure>
                                    <img src="images/테일더블루.jpg" alt="테일더블루">
                                    <figcaption>테일더블루</figcaption>
                                </figure>
                            </a>
                        </div>
                    </div>

                    <!-- 2nd slide -->
                    <div class="mainSlides row fade">
                        <div class="mainSlide-div col-4">
                            <a href="details_hotel.html">
                                <figure>
                                    <img src="images/main_acc01.jpg" alt="서울드래곤시티">
                                    <figcaption>서울드래곤시티</figcaption>
                                </figure>
                            </a>
                        </div>
                        <div class="mainSlide-div col-4">
                            <a href="details_restaurant.html">
                                <figure>
                                    <img src="images/main_res01.jpeg" alt="코시나">
                                    <figcaption>코시나</figcaption>
                                </figure>
                            </a>
                        </div>
                        <div class="mainSlide-div col-4">
                            <a href="details_cafe.html">
                                <figure>
                                    <img src="images/main_cafe01.jpg" alt="스테이지28 웁시데이지">
                                    <figcaption>스테이지28 웁시데이지</figcaption>
                                </figure>
                            </a>
                        </div>
                    </div>

                    <!-- 3rd slide -->
                    <div class="mainSlides row fade">
                        <div class="mainSlide-div col-4">
                            <a href="details_hotel.html">
                                <figure>
                                    <img src="images/main_acc02.jpg" alt="비스타 워커힐 서울">
                                    <figcaption>비스타 워커힐 서울</figcaption>
                                </figure>
                            </a>
                        </div>
                        <div class="mainSlide-div col-4">
                            <a href="details_restaurant.html">
                                <figure>
                                    <img src="images/main_res02.jpg" alt="빠리가옥">
                                    <figcaption>빠리가옥</figcaption>
                                </figure>
                            </a>
                        </div>
                        <div class="mainSlide-div col-4">
                            <a href="details_cafe.html">
                                <figure>
                                    <img src="images/main_cafe02.jpg" alt="5to7 카페">
                                    <figcaption>5to7 카페</figcaption>
                                </figure>
                            </a>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script>
        // running dog gif
        var $dog = $("#dogGif"),
            timerID = 0,
            x = parseInt($dog.css("marginLeft"));

        timerID = setInterval(function () {
            x += 30;
            $dog.css("marginLeft", x + 'px');
            console.log($dog.css("marginLeft"));
        }, 100);

        // main page loader
        $(window).on("load", function () {
            $(".loader").slideUp(3000, function() {
                clearInterval(timerID);
            });
        });

        // main page slide
        var slideIndex = 1;

        $(document).ready(function () {
            showSlides(slideIndex);

            // setInterval(function() {
            //     showSlides(++slideIndex);
            // }, 3000);
        });

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mainSlides");

            if (n > slides.length) {
                slideIndex = 1
            }

            if (n < 1) {
                slideIndex = slides.length
            }

            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }

            slides[slideIndex - 1].style.display = "flex";
        }
    </script>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>
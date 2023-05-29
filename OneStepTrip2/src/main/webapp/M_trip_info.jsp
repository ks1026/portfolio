<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>이벤트 페이지</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
</head>
<style>

	body{
		display:inline-block;
		margin:auto;
		
		}
		
	.im{
		width:100%;
		height:480px;
		display:inline-block;
		margin:auto;
	}
	
body {
    
    font-family: 'Open Sans', sans-serif;
    background-color: #f7f7f7;
}

.lib-panel {
    margin-bottom: 20Px;
}
.lib-panel img {
    width: 100%;
    background-color: transparent;
}

.lib-panel .row,
.lib-panel .col-md-6 {
    padding: 0;
    background-color: #FFFFFF;
}


.lib-panel .lib-row {
    padding: 0 20px 0 20px;
}

.lib-panel .lib-row.lib-header {
    background-color: #FFFFFF;
    font-size: 20px;
    padding: 10px 20px 0 20px;
}

.lib-panel .lib-row.lib-header .lib-header-seperator {
    height: 2px;
    width: 26px;
    background-color: #d9d9d9;
    margin: 7px 0 7px 0;
}

.lib-panel .lib-row.lib-desc {
    position: relative;
    height: 100%;
    display: block;
    font-size: 13px;
}
.lib-panel .lib-row.lib-desc a{
    position: absolute;
    width: 100%;
    bottom: 10px;
    left: 20px;
}

.row-margin-bottom {
    margin-bottom: 20px;
}

.box-shadow {
    -webkit-box-shadow: 0 0 10px 0 rgba(0,0,0,.10);
    box-shadow: 0 0 10px 0 rgba(0,0,0,.10);
}

.no-padding {
    padding: 0;
}	

.row {
	text-align: center;
}

div {
	text-align: center;
}

#nav{
  border:1px solid #ccc;
  border-width:1px 0;
  list-style:none;
  margin:0;
  padding:0;
  text-align:center;
}
#nav li{
  display:inline;
}
#nav a{
  display:inline-block;
  padding:10px;
}

</style>

</head>
<body>
<!-- top -->
<jsp:include page="top.jsp"/>
<img class="im" alt="a-1" src="./image/test1.jpg" style="opacity:0.5; vertical-align: bottom">
<!-- main -->

<div class="container" style="margin-top: 10pt;" text-align="center">
	<div class="row">
		<h2>OneStepTrip 여행정보</h2>
		<p>
		<h5>OneStepTrip 에서 제공되는 여행정보입니다.</h5>
	</div>
    <hr>
            <div class="row row-margin-bottom">
            <div class="col-md-5 no-padding lib-item" data-category="view">
                <div class="lib-panel">
                    <div class="row box-shadow">
                        <div class="col-md-6">
                           <a href="trip_info_detail.jsp"> 
                     	      <img class="lib-img-show" src="./image/trip_info/biketrip.jpg">
                           </a>
                        </div>
                        <div class="col-md-6">
                            <div class="lib-row lib-header">
                                국토종주 자전거길 소개
                                <div class="lib-header-seperator"></div>
                            </div>
                            <div class="lib-row lib-desc">
                             <h6>국토종주 자전거길 여행</h6>
                             대한민국 전국을 자전거로 종주할 수 있는
							"국토종주 자전거길"에 대한 정보를 함께 알아보시고 자전거 여행 떠나보시죠:)
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-1"></div>
            <div class="col-md-5 no-padding lib-item" data-category="ui">
                <div class="lib-panel">
                    <div class="row box-shadow">
                        <div class="col-md-6">
                        <a href="trip_info_detail2.jsp">
                            <img class="lib-img" src="./image/trip_info/glamping.jpg">
                         </a>
                        </div>
                        <div class="col-md-6">
                            <div class="lib-row lib-header">
                                경기 근교 글램핑 추천
                                <div class="lib-header-seperator"></div>
                            </div>
                            <div class="lib-row lib-desc">
								날씨가 따뜻해지면서 답답한 도심에서 벗어나 탁트인 곳에서 바람쐬며 산책하고 싶어지는 날이 왔어요 :)
								도심을 떠나 글램핑을 함께 하시는건 어떠세요 ?
								
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        
        </div>

        	
        	<div class="row row-margin-bottom">
            <div class="col-md-5 no-padding lib-item" data-category="view">
                <div class="lib-panel">
                    <div class="row box-shadow">
                        <div class="col-md-6">
                        <a href="trip_info_detail3.jsp">
                            <img class="lib-img-show" src="./image/trip_info/cablecar.jpg" height="210px">
                        </a>
                        </div>
                        <div class="col-md-6">
                            <div class="lib-row lib-header">
                                가족여행자들을 위한 국내케이블 정보
                                <div class="lib-header-seperator"></div>
                            </div>
                            <div class="lib-row lib-desc">
                                가끔 높은 곳에 올라가서 싶을 때 있으시죠?
								그런데 걷기는 싫고 편하게 높은 곳에 올라가고 싶을 때 케이블카 타고 올라가 보세요:)
								우리나라 관광지에 케이블카가 설치된 곳이 많이 있답니다.
​
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-1"></div>
            <div class="col-md-5 no-padding lib-item" data-category="ui">
                <div class="lib-panel">
                    <div class="row box-shadow">
                        <div class="col-md-6">
                        <a href="trip_info_detail4.jsp">
                            <img class="lib-img" src="./image/trip_info/luge.jpg">
                         </a>
                        </div>
                        <div class="col-md-6">
                            <div class="lib-row lib-header">
                                통영 루지
                                <div class="lib-header-seperator"></div>
                            </div>
                            <div class="lib-row lib-desc">
								통영에서 꼭 즐겨야 할 대표 액티비티!
								누구나 쉽게 배우고 안전하게 즐길 수 있는 카트 체험이에요.
								터널, 커브 등 스릴을 맛볼 수 있는 다양한 트랙으로 더욱 짜릿한 라이딩을 즐길 수 있어요.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        	
        	
        	
            <!-- 페이지 이동 -->
     		   <!-- <div class="row mb-2" >
		        <div class="col-md-12">
		            <nav aria-label="Page navigation example" text-align="center">
                      <ul class="pagination">
                        <li class="page-item">
                          <a class="page-link" href="#" aria-label="Previous" >
                            <span aria-hidden="true">«</span>
                            <span class="sr-only">Previous</span>
                          </a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                          <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">»</span>
                            <span class="sr-only">Next</span>
                          </a>
                        </li>
                      </ul>
                    </nav>
		        </div>
		    </div> -->
     		
         
        
        	</div>
        </div>
     
</div>

  
<!-- footer -->
<jsp:include page="footer.jsp"/>    
</body>
</html>
window.onload = function(){
	
	// 호텔 클릭
	$("#main_li1").on("click", function(){
		$("#mainImg").attr("src", "static/img/main/hotel_main.jpg");
		document.getElementById('selContent_h2').innerHTML = "Sono Hotels";
		document.getElementById('selContent_P1').innerHTML = "Life Value Creator, 가족의 가치를 소중히 여기는 기업";
		document.getElementById('selContent_h3').innerHTML = "내명 호텔";
		$("#sel_img").attr("src", "static/img/main/hotel_sel.jpg");
		document.getElementById('selContent_P2').innerHTML = "소노호텔&리조트는 대명소노그룹의 대표 브랜드로 지난 20여년간 고객들로부터 꾸준하고 지속적인 사랑을 받고 있습니다. <br>"
															+ "국내 최대의 호텔 &리조트 객실을 보유하고 있는 소노호텔&리조트는 1987년 대명리조트 설악을 시작으로 전국에 호텔과 리조트를 운영 중입니다."
															+ "또한 각 지역의 지역 관광 요충지로서 지역 전체의 발전과 일자리 창출을 이끌어내는 ‘상생 기업’으로 인정받고 있습니다. <br>소노호텔&리조트는 앞으로도 지금처럼 고객의 가치와 편의를 위해 노력하겠습니다.";
		$("#webSiteMove").attr("href", "hotel/hotelMain");
	});
	// 레져 클릭
	$("#main_li2").on("click", function(){
		$("#mainImg").attr("src", "static/img/main/water_sel.jpg");
		document.getElementById('selContent_h2').innerHTML = "Snow & Water Park";
		document.getElementById('selContent_P1').innerHTML = "짜릿 시원한 레저 스포츠";
		document.getElementById('selContent_h3').innerHTML = "비발디 & 오션월드";
		$("#sel_img").attr("src", "static/img/main/WaterPark_main.jpg");
		document.getElementById('selContent_P2').innerHTML = "일년 365일, 이글거리는 태양 아래 넘실대는 파도가 끊이지 않는 테마 워터파크 ‘비발디파크 오션월드’.이집트 사막과 오아시스의 이국적인 풍경을 그대로 옮겨놓은 오션월드에서 여러분의 바다를 만끽하세요.";
		$("#webSiteMove").attr("href", "#");
	});
	// 푸드 클릭
	$("#main_li3").on("click", function(){
		$("#mainImg").attr("src", "static/img/main/food_dining_main.jpg");
		document.getElementById('selContent_h2').innerHTML = "F&B BRAND STORY";
		document.getElementById('selContent_P1').innerHTML = "여행의 가치를 더하는 소노 호텔&리조트만의 다양한 외식브랜드";
		document.getElementById('selContent_h3').innerHTML = "식음브랜드";
		$("#sel_img").attr("src", "static/img/main/food_sel.jpg");
		document.getElementById('selContent_P2').innerHTML = "소노호텔&리조트만의 다양한 먹을거리는 단순한 여행의 의미를 넘어, <br/>" +
															 "그 이상의 만족에 대한 가치를 선사합니다. 최고의 음식을 자랑하는 식객과 신개념 뷔페 레스토랑 쿠치나엠, " +
															 "<br/>다양한 컨셉의 음식을 한 곳에서 만날수 있는 비발디파크 푸드월드까지, <br/>" +
															 "그외에 30여개의 외식브랜드의 새로운 이야기들로 여러분의 여행에 함께합니다.";
		$("#webSiteMove").attr("href", "#");
	});
	
	$("#main_li1").trigger("click");
}
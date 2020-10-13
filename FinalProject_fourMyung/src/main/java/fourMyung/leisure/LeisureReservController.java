package fourMyung.leisure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.leisure.service.LeisureReservService;
import fourMyung.leisure.service.LeisureService;

@Controller
@RequestMapping("reserv")
public class LeisureReservController {
	@Autowired
	LeisureService leisureService;
	@Autowired
	LeisureReservService leisureReservService;
	
	//레저 예약, 예약확인, 예약취소, 예약조회 페이지
	//관리자 - 레저 예약자 조회
	@RequestMapping(value="reservList", method = RequestMethod.GET)
	public String reservList() {
		return "thymeleaf/leisure/reservList";
	}
	
	//레저 예약
	@RequestMapping(value="reservation_1", method = RequestMethod.GET)
	public String reservation() {
		return "thymeleaf/leisure/leisureReserv_1";
	}
	@RequestMapping(value="reservation_1", method = RequestMethod.POST)
	public String reservation_1() {
		return "thymeleaf/leisure/leisureReserv_1";
	}
	@RequestMapping(value="reservation_2", method = RequestMethod.POST)
	public String reservation_2(Model model) {
		leisureService.selectByLeisure(model);
		return "thymeleaf/leisure/leisureReserv_2";	
	}
	@RequestMapping(value="reservation_3", method = RequestMethod.POST)
	public String reservation_3() {
		leisureReservService.memberInfo();
		return "thymeleaf/leisure/leisureReserv_3";
	}
	@RequestMapping(value="reservation_4")
	public String reservation_4() {
		return "thymeleaf/leisure/leisureReserv_4";
	}
}

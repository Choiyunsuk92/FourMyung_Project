package fourMyung.leisure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.LeisureCommand;
import fourMyung.Command.LeisureTicketCommand;
import fourMyung.Command.ReservCommand2;
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
	public String reservation_2(Model model)throws Exception {
		leisureService.leisureCheck(model);
		return "thymeleaf/leisure/leisureReserv_2";	
	}
	@RequestMapping(value="reservation_3")
	public String reservation_3(Model model, HttpSession session, HttpServletRequest request)throws Exception {
		leisureReservService.ticketCheck(model, session, request);
		return "thymeleaf/leisure/leisureReserv_3";
	}
	@RequestMapping(value="reservation_4")
	public String reservation_4(HttpSession session, ReservCommand2 reservCommand2, Model model)throws Exception {
		leisureReservService.memberCheck(session, reservCommand2, model);
		leisureService.leisureCheck(model);
		return "thymeleaf/leisure/leisureReserv_4";
	}
}

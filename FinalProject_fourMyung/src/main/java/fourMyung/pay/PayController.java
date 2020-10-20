package fourMyung.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.PayCommand;
import fourMyung.hotel.service.HotelResInsertService;
import fourMyung.pay.service.KaKaoPaySuccesService;
import fourMyung.pay.service.KakaoPayService;
import lombok.extern.java.Log;

@Controller
@RequestMapping("pay")
@Log
public class PayController {
	@Autowired
	KakaoPayService kakaoPayService;
	@Autowired
	KaKaoPaySuccesService kaKaoPaySuccesService;
	@Autowired
	HotelResInsertService hotelResInsertService;
	
	@RequestMapping(value="kakaoPay", method = RequestMethod.POST)
	public String kakaoPay(PayCommand payCommand, HttpServletRequest request) {
		
		return "redirect:" + kakaoPayService.kakaoPayReady(payCommand, request);
		//return "redirect:/pay/kakaoPaySucces";
	}
	
	@RequestMapping(value="kakaoPaySucces", method = RequestMethod.GET)
	public String kakaoPaySucces(@RequestParam("pg_token") String pg_token, Model model, HttpServletRequest request) {
		log.info("GET pg_token: " + pg_token);
		//결제 성공
		model.addAttribute("payInfo", kakaoPayService.kakaoPayInfo(pg_token, request));
		
		// 결제 이후 예약정보 세팅
		HttpSession session = request.getSession();
		PayCommand paycommand = (PayCommand) session.getAttribute("resInfo");
		String location = "";
		if(paycommand.getDivCd().equals("H")) {
			// 호텔 예약 서비스 호출
			location = "redirect:/hotel/HotelResInfo";
		}else {
			// 레저 예약 서비스 호출
			location ="redirect:/reserv/reservation_5";
		}
		return location;
	}
	
	@RequestMapping(value="kakaoPaySucces", method = RequestMethod.POST)
	public void kakaoPaySuccesPost(@RequestParam("pg_token") String pg_token, Model model) {
		log.info("POST pg_token: " + pg_token);
	}

}

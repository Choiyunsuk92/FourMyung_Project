package fourMyung.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.HotelCnclCommand;
import fourMyung.Command.LeisureCnclCommand;
import fourMyung.Command.PayCommand;
import fourMyung.pay.service.KaKaoPaySuccesService;
import fourMyung.pay.service.KakaoPayService;
import fourMyung.pay.service.PaymentInfogService;
import fourMyung.pay.service.ReservationCnclService;
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
	PaymentInfogService paymentInfoService;
	@Autowired
	ReservationCnclService reservationCnclService;
	
	@RequestMapping(value="kakaoPay", method = RequestMethod.POST)
	public String kakaoPay(PayCommand payCommand, HttpServletRequest request) {
		
		//return "redirect:" + kakaoPayService.kakaoPayReady(payCommand, request);
		HttpSession session = request.getSession();
		session.setAttribute("resInfo", payCommand);
		return "redirect:/pay/kakaoPaySucces";
	}
	
	@RequestMapping(value="kakaoPaySucces", method = RequestMethod.GET)
	//public String kakaoPaySucces(@RequestParam("pg_token") String pg_token, Model model, HttpServletRequest request) {
	public String kakaoPaySucces(Model model, HttpServletRequest request) {
		//log.info("GET pg_token: " + pg_token);
		//결제 성공
		//model.addAttribute("payInfo", kakaoPayService.kakaoPayInfo(pg_token));
		
		// 결제 이후 예약정보 세팅
		HttpSession session = request.getSession();
		PayCommand paycommand = (PayCommand) session.getAttribute("resInfo");
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		try {
			paymentInfoService.payInsert(paycommand, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	@RequestMapping(value="Lcncl", method= RequestMethod.POST)
	public String LeisureCncl(LeisureCnclCommand leisureCnclCommand, HttpServletRequest request) throws Exception{
		reservationCnclService.LeisureCncl(leisureCnclCommand, request);
		return "thymeleaf/hotel/h_cnclSucces";
	}
	
	@RequestMapping(value="Hcncl", method = RequestMethod.POST)
	public String HotelCncl(HotelCnclCommand hotelCnclCommand, HttpServletRequest request) throws Exception{
		reservationCnclService.HotelCncl(hotelCnclCommand, request);
		//return "redirect:/my/myRoomSttus";
		return "thymeleaf/hotel/h_cnclSucces";
	}

}

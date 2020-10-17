package fourMyung.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.PayCommand;
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
	
	@RequestMapping(value="kakaoPay", method = RequestMethod.POST)
	public String kakaoPay(PayCommand payCommand) {
		
		//return "redirect:" + kakaoPayService.kakaoPayReady(payCommand);
		return "thymeleaf/main/paySucces";
	}
	
	@RequestMapping(value="kakaoPaySucces", method = RequestMethod.GET)
	public String kakaoPaySucces(@RequestParam("pg_token") String pg_token, Model model, PayCommand payCommand) {
		log.info("GET pg_token: " + pg_token);
		//결제 성공
		model.addAttribute("payInfo", kakaoPayService.kakaoPayInfo(pg_token, payCommand));
		
		// 결제 이후 예약정보 세팅
		/*
		 * if(payCommand.getdivCd() == "H") { 호텔서비스 }else { 레저서비스 }
		 */
		return "thymeleaf/main/paySucces";
		
	}
	
	@RequestMapping(value="kakaoPaySucces", method = RequestMethod.POST)
	public void kakaoPaySuccesPost(@RequestParam("pg_token") String pg_token, Model model) {
		log.info("POST pg_token: " + pg_token);
	}

}

package fourMyung.pay.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fourMyung.Command.KaKaoPayReadyCommand;
import fourMyung.Command.KakaoPayApprovalCommand;
import fourMyung.Command.PayCommand;
import lombok.extern.java.Log;

@Component
@Service
@Log
public class KakaoPayService {
	
	private static final String HOST = "https://kapi.kakao.com";
	
	private KaKaoPayReadyCommand kaKaoPayReadyCommand;
	private KakaoPayApprovalCommand kakaoPayApprovalCommand;
	
	public String kakaoPayReady(PayCommand paycommand, HttpServletRequest request) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		
		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+"b88f652672b752d6e8e297d1c39fa3e0");
		headers.add("Accept", "application/json;charset=UTF-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1002");
		params.add("partner_user_id", "FourMyung");
		params.add("item_name", paycommand.getProdNm()); // 상품명
		params.add("quantity", "1"); // 상품수량
		params.add("total_amount", paycommand.getPrice()); // 총 가격
		params.add("tax_free_amount", "0"); // 비과세
		params.add("approval_url", "http://localhost:9090/pay/kakaoPaySucces"); // 결제 성공시 redirect URL
		params.add("cancel_url", "http://localhost:9090/kakaoPayCancel");
		params.add("fail_url", "http://localhost:9090/kakaoPaySuccessFail");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		HttpSession session = request.getSession();
		session.setAttribute("resInfo", paycommand);
		try {
			kaKaoPayReadyCommand = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KaKaoPayReadyCommand.class);
			log.info(" "+ kaKaoPayReadyCommand);
			return kaKaoPayReadyCommand.getNext_redirect_pc_url();
		} catch (RestClientException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (URISyntaxException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "/pay";
	}
	
	public KakaoPayApprovalCommand kakaoPayInfo(String pg_token, HttpServletRequest request) {
		log.info("KakaoPayInfoVO............................................");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("========================");
		HttpSession session = request.getSession();
		System.out.println("command" + session.getAttribute("resInfo"));
		System.out.println("========================");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+"b88f652672b752d6e8e297d1c39fa3e0");
		headers.add("Accept", "application/json;charset=UTF-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", kaKaoPayReadyCommand.getTid());
		params.add("partner_order_id", "1002");
		params.add("partner_user_id", "FourMyung");
		params.add("pg_token", pg_token);
		params.add("total_amount", "0");
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		try {
			kakaoPayApprovalCommand = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalCommand.class);
			log.info("" + kakaoPayApprovalCommand);
			
			return kakaoPayApprovalCommand;
		} catch (RestClientException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}

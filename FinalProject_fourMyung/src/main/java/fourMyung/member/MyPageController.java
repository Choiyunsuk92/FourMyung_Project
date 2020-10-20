package fourMyung.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fourMyung.member.service.MyPageSelectService;

@Controller
@RequestMapping("my")
public class MyPageController {
	@Autowired
	MyPageSelectService myPageSelectService;
	
	@RequestMapping("MyPage")
	public String MyPage(HttpServletRequest request,Model model) throws Exception{
		
		myPageSelectService.reservationTxn(request, model);
		return "thymeleaf/member/MyPage";
	}
	@RequestMapping("myRoomSttus")
	public String MyRoomSttus() {
		
		return "thymeleaf/hotel/h_resSelect";
	}
	@RequestMapping("mySports")
	public String mySports() {
		
		return "thymeleaf/leisure/r_resSelect";
	}
}

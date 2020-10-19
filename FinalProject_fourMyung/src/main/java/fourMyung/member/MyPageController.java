package fourMyung.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mem")
public class MyPageController {
	
	@RequestMapping("MyPage")
	public String MyPage() {
		
		return "thymeleaf/member/MyPage";
	}
}

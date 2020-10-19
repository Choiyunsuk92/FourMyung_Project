package fourMyung.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.MemberCommand;
import fourMyung.domain.login.LoginDTO;
import fourMyung.member.service.MemberInfoService;
import fourMyung.member.service.MemberJoinService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberInfoService memberInfoService;
	
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public String regist() {
		return "thymeleaf/member/memberForm";
	}
	@RequestMapping(value="regist", method = RequestMethod.POST)
	public String regist1(Model model)throws Exception {
		return "thymeleaf/member/memberForm";
	}
	@RequestMapping(value="registOk", method = RequestMethod.POST)
	public String registOk(@Validated MemberCommand memberCommand, BindingResult result, Model model )throws Exception {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		Integer i = memberJoinService.insertMember(memberCommand,model) ;
		if(i == null) return "thymeleaf/member/memberForm";
		return "redirect:/";
	}
	@RequestMapping(value="memberMail", method = RequestMethod.GET)
	public String memberMail(@RequestParam(value="num")String joinOk, 
							 @RequestParam(value="reciver")String reciver, 
							 @RequestParam(value="userId")String userId)throws Exception {
		Integer i = memberJoinService.joinOkUpdate(joinOk, reciver, userId);
		System.out.println(i);
		if(i > 0) {
			return "thymeleaf/member/success";
		}else {
			return "thymeleaf/member/fail";
		}
	}
	@RequestMapping(value="mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session, Model model)throws Exception {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		memberInfoService.myInfo(userId, model);
		return "thymeleaf/member/myInfo";
	}
}





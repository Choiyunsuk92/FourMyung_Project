package fourMyung.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.ChangePwCommand;
import fourMyung.Command.MemberCommand;
import fourMyung.domain.member.MemberDTO;
import fourMyung.member.service.MemberDeleteService;
import fourMyung.member.service.MemberInfoService;
import fourMyung.member.service.MemberJoinService;
import fourMyung.member.service.MemberModifyService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	@ModelAttribute
	ChangePwCommand setChangePwCommand() {
		return new ChangePwCommand();
	}
	
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public String regist() {
		return "thymeleaf/member/memberForm2";
	}
	@RequestMapping(value="regist", method = RequestMethod.POST)
	public String regist1(Model model)throws Exception {
		return "thymeleaf/member/memberForm2";
	}
	@RequestMapping(value="registOk", method = RequestMethod.POST)
	public String registOk(@Validated MemberCommand memberCommand, BindingResult result, Model model )throws Exception {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm2";
		}
		Integer i = memberJoinService.insertMember(memberCommand,model) ;
		if(i == null) return "thymeleaf/member/memberForm2";
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
	@RequestMapping(value="myInfo", method = RequestMethod.GET)
	public String myInfo(HttpSession session, Model model)throws Exception {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		memberInfoService.myInfo(userId, model);
		return "thymeleaf/member/myInfo/myInfo";
	}
	@RequestMapping(value="mypagePw")
	public String mypagePwOk() {
		return "thymeleaf/member/myInfo/pwModify";
	}
	@RequestMapping(value="mypagePwOk", method = RequestMethod.POST)
	public String mypagePwOk(HttpSession session, Model model, @RequestParam(value="userPass")String userPass)throws Exception {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		MemberDTO dto = memberInfoService.myInfo(userId, model);
		if(passwordEncoder.matches(userPass, dto.getUserPass())) {
			return "thymeleaf/member/myInfo/myInfoModify";
		}else {
			model.addAttribute("valid_Pass", "비밀번호를 확인하세요. ");
			return "thymeleaf/member/myInfo/pwModify";
		}
	}
	@RequestMapping(value = "myInfoModifyPro", method = RequestMethod.POST)
	public String myInfoModifyPro(MemberCommand memberCommand, Model model)throws Exception {
		Integer i = memberModifyService.memberModify(memberCommand, model);
		if(i > 0) {
			return "redirect:/mem/myInfo";
		}else {
			model.addAttribute("valid_Pass", "비밀번호가 틀렸습니다.");
			return "thymeleaf/member/myInfo/myInfoModify";
		}
	}
	@RequestMapping(value="memberPwForm", method = RequestMethod.GET)
	public String memberPwForm() {
		return "thymeleaf/member/myInfo/pwModify_1";
	}
	@RequestMapping(value="pwModifyPro", method = RequestMethod.POST)
	public String memberPwFormPro(HttpSession session, Model model, @Validated ChangePwCommand changePwCommand, BindingResult result)throws Exception {
		if(result.hasErrors()) {
			return "thymeleaf/member/myInfo/pwModify_1";
		}
		return memberModifyService.myPwChange(session, model, changePwCommand);
	}
	@RequestMapping(value = "myInfoDel", method = RequestMethod.GET)
	public String myInfoDel() {
		return "thymeleaf/member/myInfo/delete_pw";
	}
	@RequestMapping(value = "myInfoDelPro", method = RequestMethod.POST)
	public String myInfoDelPro(HttpSession session,@RequestParam(value="userPass")String userPass, Model model)throws Exception {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		MemberDTO member = memberInfoService.myInfo(userId, model);
		if(passwordEncoder.matches(userPass, member.getUserPass())) {
			memberDeleteService.memberDelete(userId);
			return "redirect:/logout";
		}else {
			model.addAttribute("valid_pass", "비밀번호가 일치하지않습니다.");
			return "thymeleaf/member/myInfo/delete_pw";
		}
	}
}





























package fourMyung.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.ChangePwCommand;
import fourMyung.Command.MemberCommand;
import fourMyung.domain.member.MemberDTO;
import fourMyung.domain.member.PwChangeDTO;
import fourMyung.mapper.MemberMapper;
@Service
@Component
public class MemberModifyService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public Integer memberModify(MemberCommand memberCommand, Model model)throws Exception {
		MemberDTO member = new MemberDTO();
		member.setUserId(memberCommand.getUserId());
		member.setUserAddr(memberCommand.getUserAddr());
		member.setUserEmail(memberCommand.getUserEmail());
		member.setUserPh(memberCommand.getUserPh());
		
		MemberDTO dto = new MemberDTO();					//db에 저장되어있는 user의 정보를 가져옴
		dto = memberMapper.selectByMember(member).get(0);	//member 테이블에 있는 user의 정보를 가져오는데 특정 userId에 해당하는 정보만 가져오므로 get(0)
		if(passwordEncoder.matches(memberCommand.getUserPass(),dto.getUserPass())) {
			return memberMapper.memberUpdate(member);		//입력한 pw가 일치하면mapper를 이용하여 member의 정보를 업데이트하고, controller에 반환받함
		}
		return 0;	
	}
	
	public String myPwChange(HttpSession session, Model model, ChangePwCommand changePwCommand)throws Exception {
		if(!changePwCommand.isEqualNewPwToNewPwOk()) {
			model.addAttribute("valid_newPw", "새로운 비밀번호가 일치하지않습니다. ");
			return "thymeleaf/member/myInfo/pwModify_1";
		}
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member = memberMapper.selectByMember(member).get(0);
		if(passwordEncoder.matches(changePwCommand.getUserPass(), member.getUserPass())) {
			PwChangeDTO dto = new PwChangeDTO(userId, passwordEncoder.encode(changePwCommand.getNewPw()));
			memberMapper.pwChange(dto);
			return "redirect:/mem/myInfo";
		}else {
			model.addAttribute("valid_pass", "현재 비밀번호가 일치하지않습니다.");
			return "thymeleaf/member/myInfo/pwModify_1";
		}
	}

}

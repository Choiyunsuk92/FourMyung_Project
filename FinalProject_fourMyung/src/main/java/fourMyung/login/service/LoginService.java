package fourMyung.login.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.LoginCommand;
import fourMyung.domain.member.MemberDTO;
import fourMyung.mapper.MemberMapper;

@Service
@Component
public class LoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	AuthInfo authInfo;
	
	public String loginOk(LoginCommand loginCommand, HttpSession session, Model model)throws Exception {
		String location = "";
		MemberDTO dto = new MemberDTO();
		dto.setUserId(loginCommand.getUserId());
		List<MemberDTO> lists = memberMapper.selectByMember(dto);
		
		if(lists.size()==0) {
			model.addAttribute("valid_userId", "아이디가 존재하지않습니다.");
			location = "thymeleaf/login/login";
		}else {
			dto = lists.get(0);
			if(passwordEncoder.matches(loginCommand.getUserPass(), dto.getUserPass())) {
				authInfo = new AuthInfo(dto.getUserId(), dto.getUserPass(), dto.getUserEmail(), dto.getUserNm());
				session.setAttribute("authInfo", authInfo);
				location = "redirect:/";
			}else {
				model.addAttribute("valid_userPass", "비밀번호가 일치하지않습니다. ");
				location = "thymeleaf/login/login";
			}
		}
		return location;
	}

}

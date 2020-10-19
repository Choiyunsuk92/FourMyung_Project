package fourMyung.login.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.LoginCommand;
import fourMyung.domain.login.LoginDTO;
import fourMyung.mapper.LoginMapper;

@Service
@Component
public class LoginService {
	@Autowired
//	MemberMapper memberMapper;
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String loginOk(LoginCommand loginCommand, HttpSession session, Model model)throws Exception {
		String location = "";
		AuthInfo dto = loginMapper.login(loginCommand.getUserId());
		
		if(dto == null) {
			model.addAttribute("valid_userId", "아이디가 존재하지않습니다.");
			location = "thymeleaf/login/login";
		}else {
			if(passwordEncoder.matches(loginCommand.getUserPass(), dto.getUserPass())) {
				session.setAttribute("authInfo", dto);
				location = "redirect:/";
			}else {
				model.addAttribute("valid_userPass", "비밀번호가 일치하지않습니다. ");
				location = "thymeleaf/login/login";
			}
		}
		return location;
	}

}

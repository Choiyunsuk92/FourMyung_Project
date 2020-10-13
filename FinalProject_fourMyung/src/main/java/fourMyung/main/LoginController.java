package fourMyung.main;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.LoginCommand;
import fourMyung.login.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@ModelAttribute
	LoginCommand setLoginCommand() {
		return new LoginCommand();
	}
	
	//로그인 창 - 로그인 화면
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login() {
		return "thymeleaf/login/login";
	}
	
	//로그인 클릭
	@RequestMapping(value="loginOk", method = RequestMethod.POST)
	public String loginOk(@Validated LoginCommand loginCommand, BindingResult result, 
							HttpSession session, Model model)throws Exception {
		if(result.hasErrors()) {
			return "thymeleaf/login/login";
		}
		String location = loginService.loginOk(loginCommand, session, model);
		return location;
	}
	
	//로그아웃
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}

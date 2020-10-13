package fourMyung.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

	@RequestMapping(value="/")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		
		return "thymeleaf/main/main";
	}
	
}

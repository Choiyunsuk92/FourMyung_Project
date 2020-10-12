package fourMyung.leisure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="leisureInfo")
public class LeisureInfoController {
	@RequestMapping("oceanCharge")
	public String ocaenCharge() {
		return "thymeleaf/leisure/oceanCharge";
	}
	@RequestMapping("oceanInfo")
	public String oceanInfo() {
		return "thymeleaf/leisure/oceanInfo";
	}
}

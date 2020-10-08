package fourMyung.leisure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.LeisureCommand;
import fourMyung.leisure.service.LeisureService;


@Controller
@RequestMapping("leisure")
public class LeisureController {
	@Autowired
	LeisureService leisureService;
	
	@RequestMapping(value="leisureMain", method = RequestMethod.GET)
	public String leisureMain() {
		return "thymeleaf/leisure/leisureMain";
	}
	@RequestMapping(value="manageMain", method = RequestMethod.GET)
	public String manageMain() {
		return "thymeleaf/leisure/leisureManage";
	}
	//레저 등록, 조회, 삭제 페이지
	@RequestMapping(value="leisureList", method = RequestMethod.GET)
	public String leisureList(Model model) {
		leisureService.selectByLeisure(model);
		return "thymeleaf/leisure/leisureList";
	}
	@RequestMapping(value="leisureOk", method = RequestMethod.POST)
	public String leisureOk(@Validated LeisureCommand leisureCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "redirect:/leisure/leisureList";
		}
		leisureService.insertLeisure(leisureCommand,model);
		return "redirect:/leisure/leisureList";
	}
	@RequestMapping(value="leisureDel", method = RequestMethod.POST)
	public String leisureDel(@RequestParam(value="leisureNum")Integer leisureNum) {
		leisureService.deleteLeisure(leisureNum);
		return "redirect:/leisure/leisureList";
	}
}

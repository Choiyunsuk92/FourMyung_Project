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
import fourMyung.Command.LeisureTicketCommand;
import fourMyung.Command.RentalCommand;
import fourMyung.leisure.service.LeisureService;
import fourMyung.leisure.service.ResntalService;


@Controller
@RequestMapping("leisure")
public class LeisureController {
	@Autowired
	LeisureService leisureService;
	@Autowired
	ResntalService rentalService;
	
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
	
	//발권등록, 조회페이지
	@RequestMapping(value="ticketBuy", method = RequestMethod.GET)
	public String ticketBuy() {
		return "thymeleaf/leisure/ticketBuy";
	}
	@RequestMapping(value="ticketList", method = RequestMethod.GET)
	public String ticketList() {
		return "thymeleaf/leisure/ticketList";
	}

	//대여물품 등록, 물품 조회
	@RequestMapping(value="rentalGoodsList", method = RequestMethod.GET)
	public String rentalList(Model model)throws Exception {
		rentalService.selectByRental(model);
		return "thymeleaf/leisure/rentalGoodsList";
	}
	@RequestMapping(value="goodsOk", method = RequestMethod.POST)
	public String rentalOk(@Validated RentalCommand rentalCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "redirect:/leisure/rentalGoodsList";
		}
		rentalService.insertGoods(rentalCommand,model);
		return "redirect:/leisure/rentalGoodsList";
	}
	@RequestMapping(value="goodsDel", method = RequestMethod.POST)
	public String goodsDel(@RequestParam(value="goodsNum")String goodsNum) {
		rentalService.deleteGoods(goodsNum);
		return "redirect:/leisure/rentalGoodsList";
	}
	
	//물품 대여자 조회
	@RequestMapping(value="lendList", method = RequestMethod.GET)
	public String lendList() {
		return "thymeleaf/leisure/lendList";
	}
}

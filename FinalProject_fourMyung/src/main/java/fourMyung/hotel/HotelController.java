package fourMyung.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hotel")
public class HotelController {
	@RequestMapping("hotelMain")
	public String hotelMain() {
		
		return "";
	}
}

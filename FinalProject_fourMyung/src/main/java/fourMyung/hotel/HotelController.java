package fourMyung.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.HotelRoomCommand;
import fourMyung.hotel.service.RoomSearchService;

@Controller
@RequestMapping("hotel")
public class HotelController {
	@Autowired
	RoomSearchService rommSearchService;
	@RequestMapping("hotelMain")
	public String hotelMain() {
		
		return "thymeleaf/hotel/h_main";
	}
	
	@RequestMapping(value = "RoomSearch", method = RequestMethod.POST)
	public String RoomSearch(HotelRoomCommand hotelRoomCommand, Model model) {
		
		rommSearchService.roomSearch(hotelRoomCommand, model);
		
		return "thymeleaf/hotel/room/roomSel";
	}
}

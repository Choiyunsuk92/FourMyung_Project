package fourMyung.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.HotelResCommand;
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
	public String RoomSearch(HotelRoomCommand hotelRoomCommand, Model model) throws Exception{
		
		rommSearchService.roomSearch(hotelRoomCommand, model);
		
		return "thymeleaf/hotel/room/roomSel";
	}
	
	@RequestMapping(value="RoomSelect", method = RequestMethod.POST)
	public String RoomReservation(HotelResCommand hotelResCommand, Model model) {
		
		return "thymeleaf/hotel/h_room_res";
	}
}

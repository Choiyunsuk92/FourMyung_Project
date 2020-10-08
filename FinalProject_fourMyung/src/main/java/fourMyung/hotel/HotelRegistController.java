package fourMyung.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.RoomInfoCommand;
import fourMyung.hotel.service.RoomRegistService;

@Controller
@RequestMapping("regist")
public class HotelRegistController {
	
	@Autowired
	RoomRegistService roomRegistService;
	
	@RequestMapping("hotelList")
	public String hotelListSelect() {
		
		return "thymeleaf/hotel/room/room_List";
	}
	@RequestMapping("roomWrite")
	public String roomWrite() {
		return "thymeleaf/hotel/room/room_Write";
	}
	
	@RequestMapping(value="roomWritePro", method = RequestMethod.POST)
	public String roomWritePro(RoomInfoCommand roomInfoCommand, Model model) throws Exception{
		roomRegistService.roomInsert(roomInfoCommand, model);
		return "redirect:/regist/hotelList";
	}
}

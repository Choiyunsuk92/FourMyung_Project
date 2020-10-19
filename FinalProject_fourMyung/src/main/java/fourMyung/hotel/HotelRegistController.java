package fourMyung.hotel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.RoomInfoCommand;
import fourMyung.hotel.service.RoomListSelectService;
import fourMyung.hotel.service.RoomRegistService;

@Controller
@RequestMapping("regist")
public class HotelRegistController {
	
	@Autowired
	RoomRegistService roomRegistService;
	@Autowired
	RoomListSelectService roomListSelectService;
	
	@RequestMapping("hotelList")
	public String hotelListSelect(Model model) throws Exception{
		roomListSelectService.roomListSelect(model);
		return "thymeleaf/hotel/room/room_List";
	}
	@RequestMapping("roomWrite")
	public String roomWrite() {
		return "thymeleaf/hotel/room/room_Write";
	}
	
	@RequestMapping(value="roomWritePro", method = RequestMethod.POST)
	public String roomWritePro(RoomInfoCommand roomInfoCommand, Model model, HttpServletRequest request) throws Exception{
		String location  = roomRegistService.roomInsert(roomInfoCommand, model, request);
		return location;
	}
	@RequestMapping("test")
	public String test() {
		
		return "thymeleaf/main/paySucces";
	}
}

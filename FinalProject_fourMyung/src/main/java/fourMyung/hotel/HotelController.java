package fourMyung.hotel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fourMyung.Command.HotelResCommand;
import fourMyung.Command.HotelRoomCommand;
import fourMyung.hotel.service.HotelFinalResService;
import fourMyung.hotel.service.HotelResInfoInsertService;
import fourMyung.hotel.service.RoomProReservationService;
import fourMyung.hotel.service.RoomReservationService;
import fourMyung.hotel.service.RoomSearchService;

@Controller
@RequestMapping("hotel")
public class HotelController {
	@Autowired
	RoomSearchService rommSearchService;
	@Autowired
	RoomReservationService roomReservationService;
	@Autowired
	RoomProReservationService roomProReservationService;
	@Autowired
	HotelFinalResService hotelFinalResService;
	@Autowired
	HotelResInfoInsertService HotelResInfoInsertService;
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
	public String RoomReservation(HotelResCommand hotelResCommand, Model model) throws Exception{
		
		roomReservationService.roomResInfo(hotelResCommand, model);
		
		return "thymeleaf/hotel/h_room_res";
	}
	
	@RequestMapping(value="RoomReservation", method =RequestMethod.POST)
	public String RoomProReservation(HotelResCommand hotelResCommand, Model model) throws Exception{
		hotelFinalResService.infoComm(hotelResCommand, model);
		//roomProReservationService.hotelResInsert(hotelResCommand, model);
		return "thymeleaf/hotel/h_payPage";
	}
	@RequestMapping(value="HotelResInfo")
	public String HotelResInfo(HttpServletRequest request, Model model) throws Exception{
		HotelResInfoInsertService.resInfoInsert(request, model);
		return "thymeleaf/hotel/h_paySucces";
	}
	
}

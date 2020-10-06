package fourMyung.hotel.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.HotelRoomCommand;
import fourMyung.hotel.domain.RoomDTO;

@Component
@Service
public class RoomSearchService {

	public void roomSearch(HotelRoomCommand hotelRoomCommand, Model model) {
		// TODO Auto-generated method stub
		RoomDTO roomDTO = new RoomDTO();
		
	}
	

}

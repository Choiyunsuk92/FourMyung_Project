package fourMyung.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.RoomInfoCommand;
import fourMyung.hotel.domain.RoomDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class RoomRegistService {
	
	@Autowired
	HotelMapper hotelMapper;
	public void roomInsert(RoomInfoCommand roomInfoCommand, Model model) throws Exception{
		// TODO Auto-generated method stub
		RoomDTO roomDTO = new RoomDTO();
		
		
		int i = hotelMapper.roomInsert(roomDTO);
		
	}

}

package fourMyung.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.HotelRoomCommand;
import fourMyung.hotel.domain.RoomDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class RoomSearchService {
	
	@Autowired
	HotelMapper hotelMapper;
	public void roomSearch(HotelRoomCommand hotelRoomCommand, Model model) throws Exception{
		// TODO Auto-generated method stub
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setCheck_adult(hotelRoomCommand.getCheck_adult());
		roomDTO.setCheck_child(hotelRoomCommand.getCheck_child());
		roomDTO.setChek_In_Date(hotelRoomCommand.getChek_In_Date());
		roomDTO.setChek_Out_Date(hotelRoomCommand.getChek_Out_Date());
		
		List<RoomDTO> roomSel = hotelMapper.roomSearch(roomDTO);
	}
	

}

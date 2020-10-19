package fourMyung.hotel.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.HotelRoomCommand;
import fourMyung.domain.hotel.RoomDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class RoomSearchService {
	
	@Autowired
	HotelMapper hotelMapper;
	public void roomSearch(HotelRoomCommand hotelRoomCommand, Model model) throws Exception{
		// TODO Auto-generated method stub
		RoomDTO roomDTO = new RoomDTO();
		SimpleDateFormat trans = new SimpleDateFormat("yyyy-mm-dd");
		Date CheckIn = trans.parse(hotelRoomCommand.getChek_In_Date());
		Date CheckOut = trans.parse(hotelRoomCommand.getChek_Out_Date());
		System.out.println("search checkIn: "+hotelRoomCommand.getChek_In_Date());
		roomDTO.setCheck_adult(hotelRoomCommand.getCheck_adult());
		roomDTO.setCheck_child(hotelRoomCommand.getCheck_child());
		roomDTO.setChek_In_Date(CheckIn);
		roomDTO.setChek_Out_Date(CheckOut);
		
		List<RoomDTO> roomSel = hotelMapper.roomSearch(roomDTO);
		model.addAttribute("resInfoCom", hotelRoomCommand);
		model.addAttribute("roomRel", roomSel);
	}
	

}

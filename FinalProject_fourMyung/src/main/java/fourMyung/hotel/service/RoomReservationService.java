package fourMyung.hotel.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.HotelResCommand;
import fourMyung.Command.HotelRoomCommand;

@Component
@Service
public class RoomReservationService {

	public void roomResInfo(HotelResCommand hotelResCommand, Model model) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("=============================");
		System.out.println(hotelResCommand.getCheckInDt());
		System.out.println();
		System.out.println("=============================");
		String form = "2020-10-29";
		SimpleDateFormat trans = new SimpleDateFormat("yyyy-mm-dd");
		Date to = trans.parse(form);
		model.addAttribute("roomResInfo", hotelResCommand);
	}

}

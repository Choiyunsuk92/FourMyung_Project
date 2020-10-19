package fourMyung.hotel.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.HotelResCommand;

@Component
@Service
public class HotelFinalResService {

	public void infoComm(HotelResCommand hotelResCommand, Model model) {
		// TODO Auto-generated method stub
		System.out.println("roomClass: ::::"+ hotelResCommand.getRoomClass());
		model.addAttribute("hotelResInfo", hotelResCommand);
	}

}

package fourMyung.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.PayCommand;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class HotelResInsertService {
	
	@Autowired
	HotelMapper hotelMapper;
	public void resInfoInsert(PayCommand payCommand, Model model) {
		// TODO Auto-generated method stub
		System.out.println("checkIn : "+payCommand.getCheckInDt());
	}

}

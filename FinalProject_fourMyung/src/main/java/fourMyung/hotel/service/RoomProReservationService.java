package fourMyung.hotel.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.HotelResCommand;
import fourMyung.domain.hotel.HotelResDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class RoomProReservationService {
	
	@Autowired
	HotelMapper hotelMapper;
	
	public void hotelResInsert(HotelResCommand hotelResCommand, Model model) throws Exception{
		// TODO Auto-generated method stub
		HotelResDTO resDto = new HotelResDTO();
		
		SimpleDateFormat trans = new SimpleDateFormat("yyyy-mm-dd");
		Date CheckIn = trans.parse(hotelResCommand.getCheckInDt());
		Date CheckOut = trans.parse(hotelResCommand.getCheckOutDt());
		
		resDto.setAddReq(hotelResCommand.getAddReq());
		resDto.setCheck_adult(hotelResCommand.getCheck_adult());
		resDto.setCheck_child(hotelResCommand.getCheck_child());
		resDto.setCheckInDt(CheckIn);
		resDto.setCheckOutDt(CheckOut);
		resDto.setPrice(hotelResCommand.getPrice());
		resDto.setRoomNm(hotelResCommand.getRoomNm());
		resDto.setRoomOfNum(hotelResCommand.getRoomOfNum());
		resDto.setUserNm(hotelResCommand.getUserNm());
		resDto.setUserPh(hotelResCommand.getUserPh());
		
		Integer num = Integer.parseInt(hotelResCommand.getRoomOfNum());
		for(int i=1; num < i; i++) {
			System.out.println("insert문 실행 횟수 : "+i);
			//hotelMapper.hotelResInsert(resDto);
		}
	}

}

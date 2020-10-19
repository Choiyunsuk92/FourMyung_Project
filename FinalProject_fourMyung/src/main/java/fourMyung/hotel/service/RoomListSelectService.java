package fourMyung.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.domain.hotel.RoomDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class RoomListSelectService {
	
	@Autowired
	HotelMapper hotelMapper;
	
	// 관리자 객실등록 리스트 조회
	public void roomListSelect(Model model) throws Exception{
		// TODO Auto-generated method stub
		
		List<RoomDTO> lists = hotelMapper.roomListSelect();
		model.addAttribute("lists", lists);
	}

}

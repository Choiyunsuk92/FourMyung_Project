package fourMyung.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.domain.hotel.HotelResDTO;
import fourMyung.domain.hotel.HotelResInfoDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class ResInfoSelectService {
	
	@Autowired
	HotelMapper hotelMapper;
	public void resInfoSelect(HotelResDTO hotelResDTO, Model model) throws Exception{
		// TODO Auto-generated method stub
		
		HotelResInfoDTO resultDto = hotelMapper.resInfoSelect(hotelResDTO);
		resultDto.setROOM_NM(hotelResDTO.getRoomNm());
		
		model.addAttribute("resResult", resultDto);
	}

}

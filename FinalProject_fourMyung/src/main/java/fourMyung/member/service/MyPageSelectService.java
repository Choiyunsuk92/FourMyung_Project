package fourMyung.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.AuthInfo;
import fourMyung.domain.hotel.HotelResInfoDTO;
import fourMyung.mapper.MemberMapper;

@Component
@Service
public class MyPageSelectService {
	
	@Autowired
	MemberMapper memberMapper;
	public void reservationTxn(HttpServletRequest request,Model model) throws Exception{
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		//AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		//String userId = authInfo.getUserId();
		
		List<HotelResInfoDTO> hotelListDTO = memberMapper.myPageHotel("TEST");
		
		model.addAttribute("hotelListDTO", hotelListDTO);
	}

}

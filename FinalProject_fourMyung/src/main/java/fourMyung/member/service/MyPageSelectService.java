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
import fourMyung.domain.member.MypageLeisureDTO;
import fourMyung.mapper.MemberMapper;

@Component
@Service
public class MyPageSelectService {
	
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	MemberInfoService memberInfoService;
	public String reservationTxn(HttpServletRequest request,Model model) throws Exception{
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		memberInfoService.myInfo(userId, model);
		
		List<HotelResInfoDTO> hotelListDTO = memberMapper.myPageHotel(userId);
		System.out.println("sysCredDt: "+ hotelListDTO.get(0).getSYS_CRET_DT());
		
		model.addAttribute("hotelListDTO", hotelListDTO);
		
		List<MypageLeisureDTO> leisureListDTO = memberMapper.myPageLeisure(userId);
		System.out.println(leisureListDTO.get(0));
		model.addAttribute("leisure", leisureListDTO);
		
		return "";
	}
	public void leisureRexDeailTxn(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		List<MypageLeisureDTO> detailList = memberMapper.myPageLeisureDetail(userId);
		
		model.addAttribute("detailList", detailList);
		
	}
	
	

}

package fourMyung.pay.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.HotelCnclCommand;
import fourMyung.Command.LeisureCnclCommand;
import fourMyung.domain.member.HotelCnclDTO;
import fourMyung.domain.member.LeisureCnclDTO;
import fourMyung.mapper.MemberMapper;

@Component
@Service
public class ReservationCnclService {
	
	@Autowired
	MemberMapper memberMapper;
	public void LeisureCncl(LeisureCnclCommand leisureCnclCommand, HttpServletRequest request) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("레저 결제 취소 진입");
		LeisureCnclDTO cnclDTO = new LeisureCnclDTO();
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		System.out.println("payNum : " + leisureCnclCommand.getPayNum() );
		System.out.println("TicketNum : " + leisureCnclCommand.getTicketNum());
		cnclDTO.setPayNum(leisureCnclCommand.getPayNum());
		cnclDTO.setPrice(leisureCnclCommand.getPrice());
		cnclDTO.setTicketNum(leisureCnclCommand.getTicketNum());
		cnclDTO.setUserId(authInfo.getUserId());
		
		Integer i = memberMapper.leisureCncl(cnclDTO);
		System.out.println(i+"건의 예약이 취소되었습니다.");
	}

	public void HotelCncl(HotelCnclCommand hotelCnclCommand, HttpServletRequest request) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("호텔 결제 취소 진입");
		HotelCnclDTO cnclDTO = new HotelCnclDTO();
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		System.out.println("payNum : " + hotelCnclCommand.getPayNum() );
		System.out.println("resNum : " + hotelCnclCommand.getResNum() );
		cnclDTO.setPayNum(hotelCnclCommand.getPayNum());
		cnclDTO.setResNum(hotelCnclCommand.getResNum());
		cnclDTO.setUserId(authInfo.getUserId());
		
		Integer i = memberMapper.hotelCncl(cnclDTO);
		System.out.println(i+"건의 예약이 취소되었습니다.");
	}

}

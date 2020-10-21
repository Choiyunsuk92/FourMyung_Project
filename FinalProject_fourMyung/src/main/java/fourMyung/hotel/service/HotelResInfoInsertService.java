package fourMyung.hotel.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.PayCommand;
import fourMyung.domain.hotel.HotelResDTO;
import fourMyung.mapper.HotelMapper;
import fourMyung.mapper.PayMapper;
import lombok.extern.java.Log;

@Component
@Service
@Log
public class HotelResInfoInsertService {
	
	@Autowired
	HotelMapper hotelMapper;
	@Autowired
	PayMapper payMapper;
	@Autowired
	ResInfoSelectService resInfoSelectService;
	public void resInfoInsert(HttpServletRequest request, Model model) throws Exception{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PayCommand payCommand = (PayCommand) session.getAttribute("resInfo");
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		HotelResDTO resDTO = new HotelResDTO();
		
		SimpleDateFormat trans = new SimpleDateFormat("yyyy-mm-dd");
		Date checkIn = trans.parse(payCommand.getCheckInDt());
		Date checkOut = trans.parse(payCommand.getCheckOutDt());
		
		resDTO.setAddReq(payCommand.getAddReq());
		resDTO.setCheck_adult(payCommand.getCheck_adult());
		resDTO.setCheck_child(payCommand.getCheck_child());
		resDTO.setCheckInDt(checkIn);
		resDTO.setCheckOutDt(checkOut);
		resDTO.setPrice(payCommand.getPrice());
		resDTO.setRoomDivCd(payCommand.getRoomDivCd());
		resDTO.setRoomNm(payCommand.getProdNm());
		resDTO.setRoomOfNum(payCommand.getRoomOfNum());
		resDTO.setUserNm(payCommand.getUserNm());
		resDTO.setUserPh(payCommand.getUserPh());
		resDTO.setPayType(payCommand.getPayType());
		resDTO.setUserId(userId);
		resDTO.setRoomNum(payCommand.getRoomNum());
		
		log.info("resDTO : "+ resDTO);
		
		Integer res = hotelMapper.hotelResInsert(resDTO);
		System.out.println(res+"건의 예약정보가 입력되었습니다.");
		
		Integer i = payMapper.hotelPayInsert(userId);
		System.out.println(i+"건의 호텔 결제 정보가 입력되었습니다.");
		
		if(res != null) {
			System.out.println("예약여부 업데이트!!!!");
			// 예약정보 입력 후 객실예약여부 Y/N 업데이트
			hotelMapper.roomResYnUpdate(resDTO);
			// 예약성공 화면에 출력하기 위해 예약정보 조회
			resInfoSelectService.resInfoSelect(resDTO, model);
		}
	}

}

package fourMyung.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fourMyung.Command.PayCommand;
import fourMyung.domain.pay.PayDTO;
import fourMyung.mapper.PayMapper;

@Component
@Service
public class PaymentInfogService {
	
	@Autowired
	PayMapper payMapper;
	@Autowired
	PaymentInfogService paymentInfogService;
	public void payInsert(PayCommand paycommand, String userId) throws Exception{
		// TODO Auto-generated method stub
		PayDTO payDto = new PayDTO();
		payDto.setPayType(paycommand.getPayType());
		payDto.setPayPrice(paycommand.getPrice());
		payDto.setPayDetail("KP");
		payDto.setCardNum("1234");
		payDto.setUserId(userId);
		payDto.setSttusDivCd("Y"); // Y:결제완료 C:결제취소
		Integer i = payMapper.payInfoInsert(payDto);
		System.out.println(i+"개의 결제 정보가 입력되었습니다.");
		
	}
	public void payHotelInsert(String userId) throws Exception{
		// TODO Auto-generated method stub
		Integer j = payMapper.hotelPayInsert(userId);
		System.out.println(j+"개의 호텔결제 정보가 입력되었습니다.");
	}
	public void payleisureInsert(String userId) {
		
	}
}

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
	
	public void payInsert(PayCommand paycommand) throws Exception{
		// TODO Auto-generated method stub
		PayDTO payDto = new PayDTO();
		payDto.setPayType(paycommand.getPayType());
		payDto.setPayPrice(paycommand.getPrice());
		
		Integer i = payMapper.payInfoInsert(payDto);
		System.out.println(i+"개의 결제 정보가 입력되었습니다.");
	}

}

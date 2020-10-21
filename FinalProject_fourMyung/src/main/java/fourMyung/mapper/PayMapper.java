package fourMyung.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.pay.PayDTO;

@Component
@Repository(value="fourMyung.mapper.PayMapper")
public interface PayMapper {
	public String selectPayNum();
	public Integer payInfoInsert(PayDTO dto) throws Exception;
	public Integer hotelPayInsert(String userId) throws Exception;
	public Integer leisurePayInsert(String userId) throws Exception;
}
